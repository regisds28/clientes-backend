package br.com.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clientes.repository.TelefoneRepositorio;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepositorio repositorio;

}
