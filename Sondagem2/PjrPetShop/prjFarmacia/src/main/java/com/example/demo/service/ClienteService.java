package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitie.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> buscarTodosCliente() {
		return clienteRepository.findAll();
	}

	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
		Optional<Cliente> clienteExistente = clienteRepository.findById(id);
		if (clienteExistente.isPresent()) {
			Cliente cliente = clienteExistente.get();
			cliente.setRazaoSoc(clienteAtualizado.getRazaoSoc());
			cliente.setNomeFant(clienteAtualizado.getNomeFant());
			cliente.setCnpj(clienteAtualizado.getCnpj());
			cliente.setEndereco(clienteAtualizado.getEndereco());
			cliente.setFone(clienteAtualizado.getFone());
			cliente.setEmail(clienteAtualizado.getEmail());
			cliente.setInscEst(clienteAtualizado.getInscEst());
			return clienteRepository.save(cliente);
		} else {
			return null;
		}
	}
}