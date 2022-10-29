package com.projeto.cadastro.entities.enuns;

public enum Genero {
	
	F("F"), M("M");
	
	private Integer codigo;
	private String sigla;
	
	Genero( String sigla) {
		this.sigla = sigla;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getSigla() {
		return sigla;
	}
	
	public Genero sexo(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Genero x : Genero.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Genero inválido!");
	}

}
