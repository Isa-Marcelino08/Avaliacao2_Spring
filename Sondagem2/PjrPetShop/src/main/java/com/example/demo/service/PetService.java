package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entitie.Cliente;
import com.example.demo.Entitie.Pet;
import com.example.demo.Repository.ClienteRepository;
import com.example.demo.Repository.PetRepository;

@Service
public class PetService {
	
	private final PetRepository petRepository;
	private final ClienteRepository clienteRepository;

	@Autowired
	public PetService(PetRepository petRepository,
			ClienteRepository clienteRepository) {
		this.petRepository = petRepository;
		this.clienteRepository = clienteRepository;
	}

	public Pet buscarPetPorId(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	public List<Pet> buscarTodosPet() {
		return petRepository.findAll();
	}

	public void excluirPet(Long id) {
		petRepository.deleteById(id);
	}
	
	
	public Pet salvarPet(Pet pet) {

	if (pet.getCliente() != null && pet.getCliente().getId() != null) {

	Optional<Cliente> cliente = clienteRepository.findById(pet.getCliente().getId());

	if (cliente.isPresent()) {

	pet.setCliente(cliente.get());

	return petRepository.save(pet);

	} else {

   throw new RuntimeException("Cliente não encontrado");

  }

		} else {

			throw new RuntimeException("ID do CLiente é Obrigatório");

		}

	}

	
	}

