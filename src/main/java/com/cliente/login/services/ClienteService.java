package com.cliente.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.login.entidades.Cliente;
import com.cliente.login.repositorio.ClienteRepositorio;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public Cliente inserir(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	public Cliente buscarId(Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);	
		return cliente.get();
	}
	
	public List<Cliente> buscarTodos() {
		return clienteRepositorio.findAll();
	}
	
	public void deletar(Long id) {
		clienteRepositorio.deleteById(id);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente cliente_1 = clienteRepositorio.getReferenceById(id);
		atualizacao(cliente_1, cliente);
		return clienteRepositorio.save(cliente_1);
	}
	
	public void atualizacao(Cliente cliente_1, Cliente cliente_2) {
		cliente_1.setName(cliente_2.getName());
		cliente_1.setPass(cliente_2.getPass());
	}

}
