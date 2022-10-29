package com.projeto.cadastro.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cadastro.entities.Cliente;
import com.projeto.cadastro.entities.dtos.ClienteDTO;
import com.projeto.cadastro.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente create(ClienteDTO clienteDTO) throws Exception {
		clienteDTO.setId(null);
		validaEmail(clienteDTO);
		validaCpf(clienteDTO);
		Cliente cliente = new Cliente(clienteDTO);
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Integer id) throws ObjectNotFoundException  {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(()-> new ObjectNotFoundException("não encontrado o Id: " + id));
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO clienteDTO) throws Exception {
		clienteDTO.setId(id);
		Cliente cliente = findById(id);
		validaEmail(clienteDTO);
		validaCpf(clienteDTO);
		cliente = new Cliente(clienteDTO);
		return clienteRepository.save(cliente);
	}
	
	public void delete(Integer id) throws Exception {
		Cliente cliente = findById(id);
		clienteRepository.deleteById(id);
	}

	public void validaEmail(ClienteDTO clienteDTO) throws IllegalArgumentException {
		Optional<Cliente> cliente = clienteRepository.findByEmail(clienteDTO.getEmail());
		if(cliente.isPresent() && cliente.get().getId() != clienteDTO.getId() ) {
			throw new IllegalArgumentException("Email já cadastrado!");
		}
	}
	
	public void validaCpf(ClienteDTO clienteDTO) throws IllegalArgumentException {
		Optional<Cliente> cliente = clienteRepository.findByCpf(clienteDTO.getCpf());
		if(cliente.isPresent() && cliente.get().getId() != clienteDTO.getId() ) {
			throw new IllegalArgumentException("CPF já cadastrado!");
		}
	}
	
}
