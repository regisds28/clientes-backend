package br.com.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clientes.model.Cliente;
import br.com.clientes.repository.ClienteRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public List<Cliente> listarClientes(){
		
		List<Cliente> list = clienteRepositorio.findAll();
		
		return list;
	}
	
	public Cliente salvar(Cliente cliente) {		
		return clienteRepositorio.save(cliente);
	} 

}
