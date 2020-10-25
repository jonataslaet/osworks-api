package br.com.osworks.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.osworks.model.Cliente;

@RestController
public class ClienteController {

	@PersistenceContext
	EntityManager em;
	
	@GetMapping("/clientes")
	public List<Cliente> buscarCliente() {
		
		return em.createQuery("from Cliente", Cliente.class).getResultList();
	}
}
