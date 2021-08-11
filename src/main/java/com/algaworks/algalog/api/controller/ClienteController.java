package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	//@PersistenceContext
	//private EntityManager manager;
	
	@Autowired // ou então gerar um construtor
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
		//manager.createQuery("from Cliente", Cliente.class)
		//.getResultList();   //JPQL consulta do javax na tabela cliente	
	}
	
	@GetMapping("/clientes/nome")
	public List<Cliente> listarNome() {
		return clienteRepository.findByNome("João da Silva");	
	}
	
	@GetMapping("/clientes/contem")
	public List<Cliente> listarNomeContain() {
		return clienteRepository.findByNomeContaining("João");	
	}
	
}
