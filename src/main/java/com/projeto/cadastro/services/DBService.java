package com.projeto.cadastro.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cadastro.entities.Cliente;
import com.projeto.cadastro.repositories.ClienteRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void instanciaDB() {

		Cliente cliente = new Cliente();
		clienteRepository.saveAll(Arrays.asList(cliente));
		
	}
}
