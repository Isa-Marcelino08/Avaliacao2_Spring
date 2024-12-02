package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entitie.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente")

public class ClienteController {
	
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping("/inserir")
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}

	@GetMapping
	public List<Cliente> buscarTodosCliente() {
		return clienteService.buscarTodosCliente();
	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return clienteService.buscarClientePorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.excluirCliente(id);
	}

	}
	

