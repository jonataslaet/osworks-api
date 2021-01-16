package br.com.osworks.controller.dto;

import javax.validation.constraints.NotNull;

import br.com.osworks.model.Cliente;

public class ClienteIdInput {

	@NotNull
	private Long id;

	public ClienteIdInput() {
		
	}
	
	public ClienteIdInput(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
