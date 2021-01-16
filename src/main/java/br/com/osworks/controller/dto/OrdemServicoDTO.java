package br.com.osworks.controller.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.osworks.model.OrdemServico;
import br.com.osworks.model.StatusOrdemServico;

public class OrdemServicoDTO {

	private Long id;
	private ClienteDTO clienteDTO;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;
	
	public OrdemServicoDTO() {
		
	}
	
	public OrdemServicoDTO(OrdemServico ordemServico) {
		this.id = ordemServico.getId();
		this.clienteDTO = new ClienteDTO(ordemServico.getCliente());
		this.descricao = ordemServico.getDescricao();
		this.preco = ordemServico.getPreco();
		this.status = ordemServico.getStatus();
		this.dataAbertura = ordemServico.getDataAbertura();
		this.dataFinalizacao = ordemServico.getDataFinalizacao();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}	
}
