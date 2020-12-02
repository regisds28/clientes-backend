package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clientes.model.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	boolean existsByEmail(String email);
	
	java.util.Optional<Cliente> findByUsuario(String usuario);
	
}
