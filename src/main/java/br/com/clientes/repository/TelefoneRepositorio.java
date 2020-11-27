package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clientes.model.Telefone;

@Repository
public interface TelefoneRepositorio extends JpaRepository<Telefone, Long>{

}
