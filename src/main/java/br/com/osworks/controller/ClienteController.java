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
import br.com.osworks.repository.ClienteRepository;

@RequestMapping(value="/clientes")
@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository cr;
	
	@GetMapping("")
	public List<Cliente> buscarClientes() {
		return cr.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaCliente(@PathVariable Long id){
		if (cr.existsById(id)) {
			return ResponseEntity.of(cr.findById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastraCliente(@Valid @RequestBody Cliente cliente){
		return cr.save(cliente);
	}
	
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Cliente>atualizaCliente(@Valid @RequestBody Cliente clienteAtual, @PathVariable Long id){
		if (cr.existsById(id)) {
			clienteAtual.setId(id);
			return ResponseEntity.ok(cr.save(clienteAtual));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Cliente>apagaCliente(@PathVariable Long id){
		if (cr.existsById(id)) {
			cr.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
