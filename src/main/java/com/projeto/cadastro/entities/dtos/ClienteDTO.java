package com.projeto.cadastro.entities.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.cadastro.entities.Cliente;
import com.projeto.cadastro.entities.enuns.Genero;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Obrigatório")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Genero sexo;
	
	@Column(unique = true)
	@NotNull(message = "Obrigatório")
	private String email;
	@NotNull(message = "Obrigatório")
	@CPF
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();
	
	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sexo = cliente.getSexo();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.dataCriacao = cliente.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
