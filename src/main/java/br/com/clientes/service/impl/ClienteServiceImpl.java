package br.com.clientes.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.clientes.exception.ResourceNotFoundException;
import br.com.clientes.model.Cliente;
import br.com.clientes.repository.ClienteRepositorio;
import br.com.clientes.service.ClienteService;

@Service
public class ClienteServiceImpl extends ClienteService{
	
	private ClienteRepositorio repositorio;

	public ClienteServiceImpl(ClienteRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
}
