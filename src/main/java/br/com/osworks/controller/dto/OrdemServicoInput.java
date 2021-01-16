package br.com.osworks.controller.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.osworks.model.OrdemServico;

public class OrdemServicoInput {

	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@Valid	
	@NotNull
	private ClienteIdInput cliente;
	
	public OrdemServicoInput() {
		
	}
	
	
	public OrdemServicoInput(OrdemServico os) {
		this.descricao = os.getDescricao();
		this.preco = os.getPreco();
		this.cliente = new ClienteIdInput(os.getCliente());
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public ClienteIdInput getCliente() {
		return cliente;
	}
	public void setCliente(ClienteIdInput cliente) {
		this.cliente = cliente;
	}
	
}
