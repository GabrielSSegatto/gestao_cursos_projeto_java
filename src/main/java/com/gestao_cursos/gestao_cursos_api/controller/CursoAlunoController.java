package com.gestao_cursos.gestao_cursos_api.controller;

import com.gestao_cursos.gestao_cursos_api.entity.CursoAluno;
import com.gestao_cursos.gestao_cursos_api.entity.CursoAlunoId;
import com.gestao_cursos.gestao_cursos_api.repository.CursoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PatchMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/matriculas") 
public class CursoAlunoController {

    @Autowired
    private CursoAlunoRepository repository;

    @PostMapping
    public CursoAluno criarMatricula(@RequestBody CursoAluno matricula) {
        return repository.save(matricula);
    }

    @GetMapping
    public List<CursoAluno> listarMatriculas() {
        return repository.findAll();
    }
    
    @DeleteMapping("/{idCurso}/{idAluno}")
    public void deletarMatricula(
        @PathVariable Long idCurso,
        @PathVariable Long idAluno) {

        CursoAlunoId id = new CursoAlunoId(idCurso, idAluno);
        
        repository.deleteById(id); 
    }
    
    @PatchMapping("/{idCurso}/{idAluno}")
    public CursoAluno alterarDataMatricula(
        @PathVariable Long idCurso,
        @PathVariable Long idAluno,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate novaData) {
        
        CursoAlunoId id = new CursoAlunoId(idCurso, idAluno);
        
        Optional<CursoAluno> optionalMatricula = repository.findById(id);

        if (optionalMatricula.isPresent()) {
            CursoAluno matricula = optionalMatricula.get();
            
            matricula.setDataMatricula(novaData);
            
            return repository.save(matricula);
        }
        
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada para os IDs fornecidos");
    }
    
}