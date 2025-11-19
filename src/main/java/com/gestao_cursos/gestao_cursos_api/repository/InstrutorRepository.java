package com.gestao_cursos.gestao_cursos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestao_cursos.gestao_cursos_api.entity.Instrutor;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
	
}
