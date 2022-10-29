package com.projeto.cadastro.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.cadastro.entities.dtos.ClienteDTO;
import com.projeto.cadastro.entities.enuns.Genero;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Genero sexo;
	@Column(unique = true)
	private String email;
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();
	
	public Cliente(Integer id, String nome, Genero sexo, String email, String cpf, LocalDate dataCriacao) {
		
	}

	public Cliente() {
	}

	public Cliente(ClienteDTO clienteDTO) {
		this.id = clienteDTO.getId();
		this.nome = clienteDTO.getNome();
		this.sexo = clienteDTO.getSexo();
		this.email = clienteDTO.getEmail();
		this.cpf = clienteDTO.getCpf();
		this.dataCriacao = clienteDTO.getDataCriacao();
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
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
}
