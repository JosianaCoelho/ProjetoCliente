package com.projeto.cadastro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.cadastro.services.DBService;

@Configuration
@Profile("test")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanciaDB() {
		this.dbService.instanciaDB();
	}
}
