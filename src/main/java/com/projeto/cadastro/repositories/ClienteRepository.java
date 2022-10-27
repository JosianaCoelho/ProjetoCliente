package com.projeto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cadastro.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
