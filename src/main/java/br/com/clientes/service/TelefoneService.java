package br.com.clientes.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clientes.exception.ResourceNotFoundException;
import br.com.clientes.model.Cliente;
import br.com.clientes.model.Telefone;
import br.com.clientes.repository.ClienteRepositorio;
import br.com.clientes.repository.TelefoneRepositorio;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepositorio repositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepo;
	
	public Optional<Telefone> listarTelefonesId(Long id) {
		return repositorio.findById(id);
	}
	
	
	public Telefone createTelefone(Long clienteId, Telefone Telefone) {
        Set<Telefone> telefones = new HashSet<>();
        Cliente cliente1 = new Cliente();

        Optional<Cliente> byId = clienteRepo.findById(clienteId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Book with id " + clienteId + " not found");
        }
        
        Cliente Cliente = byId.get();

        Telefone.setCliente(Cliente);
        Telefone telefone1 = repositorio.save(Telefone);
        telefones.add(telefone1);
        cliente1.setTelefone(telefones);

        return telefone1;

    }
	

}
