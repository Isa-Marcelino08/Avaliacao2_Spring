package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Pet;
import com.example.demo.service.PetService;

@RestController
@RequestMapping("/drogaria")
public class PetController {

	private final PetService drogariaService;

	@Autowired
	public PetController(PetService drogariaService) {
		this.drogariaService = drogariaService;
	}

	@PostMapping("/inserir")
	public Pet criarDrogaria(@RequestBody Pet drogaria) {
		return drogariaService.slavarDrogaria(drogaria);
	}

	@GetMapping
	public List<Pet> buscarTodosDrogaria() {
		return drogariaService.buscarTodosDrogaria();
	}

	@GetMapping("/{id}")
	public Pet buscarPorId(@PathVariable Long id) {
		return drogariaService.buscarDrogariaPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarDrogaria(@PathVariable Long id) {
		drogariaService.excluirDrogaria(id);
	}

	@PutMapping
	public ResponseEntity<Pet> atualizarDrogaria(@PathVariable Long id, @RequestBody Pet drogaria) {
		Pet drogariaAtualizado = drogariaService.atualizarDrogaria(id, drogaria);
		if (drogariaAtualizado != null) {
			return ResponseEntity.ok(drogariaAtualizado);
		} else {
			return null;
		}
	}
}