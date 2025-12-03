package com.gestao_cursos.gestao_cursos_api.controller;

import com.gestao_cursos.gestao_cursos_api.entity.Curso;
import com.gestao_cursos.gestao_cursos_api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos") 
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> listar() {
        return repository.findAll();
    }


    @PostMapping
    public Curso criar(@RequestBody Curso curso) {
        return repository.save(curso); 
    }


    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @RequestBody Curso novoCurso) {
        Optional<Curso> optionalCurso = repository.findById(id);

        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();
            curso.setNome(novoCurso.getNome());
            curso.setCargaHoraria(novoCurso.getCargaHoraria());
            curso.setDescricao(novoCurso.getDescricao());
            // mantem o instrutor antigo, a menos que o novoCurso contenha um novo instrutor:
            if (novoCurso.getInstrutor() != null) {
                curso.setInstrutor(novoCurso.getInstrutor());
            }

            return repository.save(curso);
        }
        return null; 
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}