package br.com.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.clientes.model.Cliente;
import br.com.clientes.model.Telefone;
import br.com.clientes.service.ClienteService;
import br.com.clientes.service.TelefoneService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TelefoneService service;

	@GetMapping(value = "/", produces = "application/json")
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}

	@PostMapping(value = "/", produces = "application/json")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {	
		
		return clienteService.salvar(cliente);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Optional<Cliente> getClienteId(@PathVariable(value = "clienteId") Long clienteId) {
        return clienteService.getClienteById(clienteId);
    } 

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Object> deleteClienteId(@PathVariable(value = "id") Long clienteId) {
        return clienteService.deleteClienteId(clienteId);
    }
	
	@GetMapping(value = "/{id}/telefone", produces = "application/json")
	public Optional<Telefone> getAllTelefoneByCliente(@PathVariable(value = "id") Long clienteId) {
		return service.listarTelefonesId(clienteId);
	}
	
	@PostMapping(value = "/{clientId}/telefone", produces = "application/json")
	public Telefone salvarTelefone(@PathVariable(value = "clientId") Long clienteId, @RequestBody Telefone telefone) {
        return service.createTelefone(clienteId, telefone);
    }
}
