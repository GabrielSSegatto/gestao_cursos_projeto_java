package com.gestao_cursos.gestao_cursos_api.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 200)
	private String nome;

	@Column(name = "carga_horaria", nullable = false)
	private Integer cargaHoraria;

	@Column(name = "descricao", nullable = false, length = 200)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_instrutor", nullable = false)
	private Instrutor instrutor;

	@ManyToMany
	@JoinTable(
		name = "curso_aluno",
		joinColumns = @JoinColumn(name = "id_curso"),
		inverseJoinColumns = @JoinColumn(name = "id_aluno")
	)
	private List<Aluno> alunos = new ArrayList<>();

	public Curso() {
	}

	public Curso(Long id, String nome, Integer cargaHoraria, String descricao, Instrutor instrutor) {
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.descricao = descricao;
		this.instrutor = instrutor;
	}

	// Getters e Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public Integer getCargaHoraria() { return cargaHoraria; }
	public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }

	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	public Instrutor getInstrutor() { return instrutor; }
	public void setInstrutor(Instrutor instrutor) { this.instrutor = instrutor; }

	public List<Aluno> getAlunos() { return alunos; }
	public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Curso)) return false;
		Curso curso = (Curso) o;
		return Objects.equals(id, curso.id);
	}
	@Override
	public String toString() {
		return "Curso{" +
			"id=" + id +
			", nome='" + nome + '\'' +
			", cargaHoraria=" + cargaHoraria +
			", descricao='" + descricao + '\'' +
			", instrutor=" + (instrutor != null ? instrutor.getId() : null) + '\'' +
			", List<Aluno>=" + (List<Aluno> != null ? List<Aluno>.getID() : null) +
			'}';
	}

	
}
