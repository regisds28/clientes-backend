package br.com.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.clientes.exception.ResourceNotFoundException;
import br.com.clientes.model.Cliente;
import br.com.clientes.repository.ClienteRepositorio;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepo;

	public List<Cliente> listarClientes() {
		List<Cliente> list = clienteRepo.findAll();
		return list;
	}

	public Optional<Cliente> getClienteById(Long clienteId) {
		return clienteRepo.findById(clienteId);
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	public ResponseEntity<Object> deleteClienteId(long clienteId) {

		clienteRepo.deleteById(clienteId);

		return ResponseEntity.ok().build();

	}

	public Cliente autenticar(String usuario, String senha) {
		
		Optional<Cliente> cliente = clienteRepo.findByUsuario(usuario);
		if(!cliente.isPresent()) {
			throw new ResourceNotFoundException("Usuário não encontrado!");
		}
		if(!cliente.get().getSenha().equals(senha)) {
			throw new ResourceNotFoundException("Senha inválida!");
		}
		
		return cliente.get();
	}

}
