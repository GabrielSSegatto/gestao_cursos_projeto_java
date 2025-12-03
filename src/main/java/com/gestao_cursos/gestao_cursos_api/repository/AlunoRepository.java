package com.gestao_cursos.gestao_cursos_api.repository;

import com.gestao_cursos.gestao_cursos_api.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
