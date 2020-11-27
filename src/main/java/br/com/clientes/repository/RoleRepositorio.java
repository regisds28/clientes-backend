package br.com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clientes.model.Role;

@Repository
public interface RoleRepositorio extends JpaRepository<Role, Long> {

}
