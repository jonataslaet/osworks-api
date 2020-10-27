package br.com.osworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.osworks.model.Cliente;
import br.com.osworks.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cr;
	
	public List<Cliente> buscaClientes(){
		return cr.findAll();
	}
	
	public ResponseEntity<Cliente> buscaCliente(Long id){
		if (cr.existsById(id)) {
			return ResponseEntity.of(cr.findById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	public Cliente cadastraCliente(Cliente cliente){
		return cr.save(cliente);
	}
	
	public ResponseEntity<Cliente>atualizaCliente(Cliente clienteAtual, Long id){
		if (cr.existsById(id)) {
			clienteAtual.setId(id);
			return ResponseEntity.ok(cr.save(clienteAtual));
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Cliente>apagaCliente(Long id){
		if (cr.existsById(id)) {
			cr.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
