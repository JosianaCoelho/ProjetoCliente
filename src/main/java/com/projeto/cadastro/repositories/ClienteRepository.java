package com.projeto.cadastro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cadastro.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
       Optional<Cliente> findByEmail(String email);
       Optional<Cliente> findByCpf(String cpf);
	
}
