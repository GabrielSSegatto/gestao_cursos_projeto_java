package com.gestao_cursos.gestao_cursos_api.controller;

import com.gestao_cursos.gestao_cursos_api.entity.Instrutor;
import com.gestao_cursos.gestao_cursos_api.repository.InstrutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

	private final InstrutorRepository instrutorRepository;

	public InstrutorController(InstrutorRepository instrutorRepository) {
		this.instrutorRepository = instrutorRepository;
	}

	@GetMapping
	public List<Instrutor> listar() {
		return instrutorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Instrutor obterPorId(@PathVariable @NonNull Long id) {
		return instrutorRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instrutor não encontrado"));
	}

	@PostMapping
	public ResponseEntity<Instrutor> criar(@RequestBody @NonNull Instrutor instrutor) {
		Instrutor salvo = instrutorRepository.save(instrutor);
		return new ResponseEntity<>(salvo, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Instrutor atualizar(@PathVariable @NonNull Long id, @RequestBody @NonNull Instrutor dados) {
		Instrutor existente = instrutorRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instrutor não encontrado"));
		existente.setNome(dados.getNome());
		existente.setFormacao(dados.getFormacao());
		existente.setIdade(dados.getIdade());
		return instrutorRepository.save(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable @NonNull Long id) {
		Instrutor existente = instrutorRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instrutor não encontrado"));
		instrutorRepository.delete(Objects.requireNonNull(existente));
		return ResponseEntity.noContent().build();
	}
}
