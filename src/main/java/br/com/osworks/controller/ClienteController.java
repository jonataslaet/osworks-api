package br.com.osworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.osworks.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> buscarCliente() {
		var cli1 = new Cliente();
		cli1.setId(1L);
		cli1.setNome("Jonatas Laet");
		cli1.setTelefone("86 9 88894625");
		cli1.setEmail("jonataslaet@gmail.com");
		
		var cli2 = new Cliente();
		cli2.setId(2L);
		cli2.setNome("Jonatas Blendo");
		cli2.setTelefone("86 9 94643741");
		cli2.setEmail("jonatas@gmail.com");
		
		return Arrays.asList(cli1, cli2);
	}
}
