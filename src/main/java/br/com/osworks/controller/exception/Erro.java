package br.com.osworks.controller.exception;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Erro {

	private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime instante;
    private String messagem;
    private String debugMessagem;
    private List<ErroDeCampo> errosDeCampo;
    
    public Erro() {
		instante = OffsetDateTime.now();
	}

	public void adicionaErrosDeCampo(List<FieldError> fieldErrors) {
		fieldErrors.forEach(e -> {
			if (errosDeCampo == null) {
				errosDeCampo = new ArrayList<>();
			}
			errosDeCampo.add(new ErroDeCampo(e.getObjectName(), e.getField(), e.getRejectedValue(),
					e.getDefaultMessage()));
		});
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public OffsetDateTime getInstante() {
		return instante;
	}
	public void setInstante(OffsetDateTime instante) {
		this.instante = instante;
	}
	public String getMessagem() {
		return messagem;
	}
	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}
	public String getDebugMessagem() {
		return debugMessagem;
	}
	public void setDebugMessagem(String debugMessagem) {
		this.debugMessagem = debugMessagem;
	}
	public List<ErroDeCampo> getErrosDeCampo() {
		return errosDeCampo;
	}
	public void setErrosDeCampo(List<ErroDeCampo> errosDeCampo) {
		this.errosDeCampo = errosDeCampo;
	}
}
