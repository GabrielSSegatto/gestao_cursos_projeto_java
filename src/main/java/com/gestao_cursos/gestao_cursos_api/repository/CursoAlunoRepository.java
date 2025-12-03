package com.gestao_cursos.gestao_cursos_api.repository;

import com.gestao_cursos.gestao_cursos_api.entity.CursoAluno;
import com.gestao_cursos.gestao_cursos_api.entity.CursoAlunoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoAlunoRepository extends JpaRepository<CursoAluno, CursoAlunoId> {

}