package com.gestao_cursos.gestao_cursos_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_cursos.gestao_cursos_api.entity.Instrutor;
import com.gestao_cursos.gestao_cursos_api.repository.InstrutorRepository;


@RestController
@RequestMapping("/api/instrutores")
public class InstrutorController {
	
	@Autowired
	InstrutorRepository instrutorRepository;
	
	@GetMapping
	public List<Instrutor> listarInstrutores(){
		return instrutorRepository.findAll();
	}
	
	@PostMapping
	public Instrutor salvarInstrutor(@RequestBody Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	@DeleteMapping("/{id}")
	public void deletarInstrutor(@PathVariable Long id) {
		instrutorRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Instrutor atualizarInstrutor(@PathVariable Long id,
										@RequestBody Instrutor instrutor) {
		Optional<Instrutor> oInstrutor = instrutorRepository.findById(id);
		if (oInstrutor.isPresent()) {
			Instrutor i = oInstrutor.get();
			i.setNome(instrutor.getNome());
			i.setFormacao(instrutor.getFormacao());
			i.setIdade(instrutor.getIdade());
			
			return instrutorRepository.save(i);
		}
		return null;
	}
	
	
}
