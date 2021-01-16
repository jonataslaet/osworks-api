package br.com.osworks.controller.dto;

import java.time.OffsetDateTime;

import br.com.osworks.model.Comentario;

public class ComentarioDTO {

	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
	
	public ComentarioDTO() {
		
	}
	
	public ComentarioDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.descricao = comentario.getDescricao();
		this.dataEnvio = comentario.getDataEnvio();
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
	public OffsetDateTime getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(OffsetDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
}
