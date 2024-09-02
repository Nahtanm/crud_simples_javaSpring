package com.cliente.login.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cliente.login.entidades.Cliente;
import com.cliente.login.repositorio.ClienteRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public void run(String... args) throws Exception{
		Cliente cliente_1 = new Cliente("Nahtanm","nahtanm123");
		Cliente cliente_2 = new Cliente("Jon","jon123");
		Cliente cliente_3 = new Cliente("Mota","mota123");
		
		clienteRepositorio.saveAll(Arrays.asList(cliente_1, cliente_2, cliente_3));
		
	}
}
