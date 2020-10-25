package br.com.osworks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.osworks.model.Cliente;
import br.com.osworks.service.ClienteService;

@RequestMapping(value="/clientes")
@RestController
public class ClienteController {

	
	@Autowired
	private ClienteService cs;
	
	@GetMapping("")
	public List<Cliente> buscaClientes() {
		return cs.buscaClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaCliente(@PathVariable Long id){
		return cs.buscaCliente(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastraCliente(@Valid @RequestBody Cliente cliente){
		return cs.cadastraCliente(cliente);
	}
	
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Cliente>atualizaCliente(@Valid @RequestBody Cliente clienteAtual, @PathVariable Long id){
		return cs.atualizaCliente(clienteAtual, id);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Cliente>apagaCliente(@PathVariable Long id){
		return cs.apagaCliente(id);
	}
}
