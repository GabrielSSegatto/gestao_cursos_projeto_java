package com.gestao_cursos.gestao_cursos_api.repository;

import com.gestao_cursos.gestao_cursos_api.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
