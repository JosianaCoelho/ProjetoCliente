package com.projeto.cadastro.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.projeto.cadastro.entities.Cliente;
import com.projeto.cadastro.entities.dtos.ClienteDTO;
import com.projeto.cadastro.repositories.ClienteRepository;

class ClienteServiceTest {
	
	private ClienteRepository clienteRepository;

	ClienteService clienteService = new ClienteService();
	
	@Test
	@DisplayName("Quando email for null, retorna o NullPointerException")
	void validaEmailExceptionNullPointer() {
		Assertions.assertThrows(NullPointerException.class, () -> clienteService.validaEmail(null));
	}

	@Test
	@DisplayName("Ver se o email já está cadastrado")
	void validaEmailJaCadastrado() throws Exception {
		ClienteDTO cliDto = new ClienteDTO();
		clienteService.validaEmail(cliDto);
		String expectativa = new String("josianacoelho@gmail.com");
		Optional<Cliente> resultado = clienteRepository.findByEmail(expectativa);
		Assertions.assertEquals(expectativa, resultado);
	}
	
}
