package br.com.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clientes.model.Cliente;
import br.com.clientes.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/", produces = "application/json")
	public List<Cliente> listClientes() {
		return clienteService.listarClientes();
	}

	@PostMapping(value = "/", produces = "application/json")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}

}
