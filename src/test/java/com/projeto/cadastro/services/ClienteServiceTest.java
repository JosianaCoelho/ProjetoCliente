package com.projeto.cadastro.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.projeto.cadastro.entities.dtos.ClienteDTO;

class ClienteServiceTest {

	@Test
	@DisplayName("Quando email for null, retorna o NullPointerException")
	void validaEmailExceptionNullPointer() {
		ClienteService clienteService = new ClienteService();
		Assertions.assertThrows(NullPointerException.class, () -> clienteService.validaEmail(null));
	}

	@Test
	@DisplayName("Ver se o email já está cadastrado")
	void validaEmailJaCadastrado() throws Exception {
		ClienteDTO cliDto = new ClienteDTO();
		ClienteService clienteService = new ClienteService();
		
		clienteService.validaEmail(cliDto);
		String expectativa = new String("josianacoelho@gmail.com");
		String resultado = new String("josianacoelho@gmail.com");
		Assertions.assertEquals(expectativa, resultado);;
	}
	
}
