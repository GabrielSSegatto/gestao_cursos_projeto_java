package com.gestao_cursos.gestao_cursos_api.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CursoAlunoId implements Serializable {
	private Long idCurso;
	private Long idAluno;

	public CursoAlunoId() {}

	public CursoAlunoId(Long idCurso, Long idAluno) {
		this.idCurso = idCurso;
		this.idAluno = idAluno;
	}

	public Long getIdCurso() { return idCurso; }
	public void setIdCurso(Long idCurso) { this.idCurso = idCurso; }

	public Long getIdAluno() { return idAluno; }
	public void setIdAluno(Long idAluno) { this.idAluno = idAluno; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CursoAlunoId)) return false;
		CursoAlunoId that = (CursoAlunoId) o;
		return Objects.equals(idCurso, that.idCurso) &&
			   Objects.equals(idAluno, that.idAluno);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCurso, idAluno);
	}
}
