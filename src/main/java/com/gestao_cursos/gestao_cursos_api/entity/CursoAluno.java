package com.gestao_cursos.gestao_cursos_api.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "curso_aluno")
public class CursoAluno implements Serializable {

	@EmbeddedId
	private CursoAlunoId id = new CursoAlunoId();

	@ManyToOne
	@MapsId("idCurso")
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@ManyToOne
	@MapsId("idAluno")
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@Column(name = "data_matricula")
	private LocalDate dataMatricula;

	public CursoAluno() {}

	public CursoAluno(Curso curso, Aluno aluno, LocalDate dataMatricula) {
		this.curso = curso;
		this.aluno = aluno;
		this.dataMatricula = dataMatricula;
		this.id = new CursoAlunoId(curso.getId(), aluno.getId());
	}

	public Curso getCurso() { return curso; }
	public void setCurso(Curso curso) { this.curso = curso; }

	public Aluno getAluno() { return aluno; }
	public void setAluno(Aluno aluno) { this.aluno = aluno; }

	public LocalDate getDataMatricula() { return dataMatricula; }
	public void setDataMatricula(LocalDate dataMatricula) { this.dataMatricula = dataMatricula; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CursoAluno)) return false;
		CursoAluno that = (CursoAluno) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
