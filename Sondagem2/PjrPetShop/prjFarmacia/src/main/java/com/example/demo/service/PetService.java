package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitie.Pet;
import com.example.demo.repository.PetRepository;

@Service
public class PetService {

	private final PetRepository drogariaRepository;

	@Autowired
	public PetService(PetRepository drogariaRepository) {
		this.drogariaRepository = drogariaRepository;
	}

	public Pet slavarDrogaria(Pet drogaria) {
		return drogariaRepository.save(drogaria);
	}

	public Pet buscarDrogariaPorId(Long id) {
		return drogariaRepository.findById(id).orElse(null);
	}

	public List<Pet> buscarTodosDrogaria() {
		return drogariaRepository.findAll();
	}

	public void excluirDrogaria(Long id) {
		drogariaRepository.deleteById(id);
	}

	public Pet atualizarDrogaria(Long id, Pet drogariaAtualizado) {
		Optional<Pet> drogariaExistente = drogariaRepository.findById(id);
		if (drogariaExistente.isPresent()) {
			Pet drogaria = drogariaExistente.get();
			drogaria.setNome(drogariaAtualizado.getNome());
			drogaria.setCnpj(drogariaAtualizado.getCnpj());
			return drogariaRepository.save(drogaria);
		} else {
			return null;
		}
	}
}