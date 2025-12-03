package com.gestao_cursos.gestao_cursos_api.controller;

import com.gestao_cursos.gestao_cursos_api.entity.Aluno;
import com.gestao_cursos.gestao_cursos_api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository; 


    @GetMapping
    public List<Aluno> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }


    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno) {
        Optional<Aluno> optionalAluno = repository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setNome(novoAluno.getNome());
            aluno.setMatricula(novoAluno.getMatricula());
            aluno.setIdade(novoAluno.getIdade());

            return repository.save(aluno);
        }
        return null; 
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}