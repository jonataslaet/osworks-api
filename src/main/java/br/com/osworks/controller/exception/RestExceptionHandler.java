package br.com.osworks.controller.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Erro erro = new Erro();
		erro.setStatus(status);
		erro.setDebugMessagem(ex.getLocalizedMessage());
		erro.setMessagem("Campo inválido");
		erro.adicionaErrosDeCampo(ex.getBindingResult().getFieldErrors());
		
		return construtorDaEntidadeResposta(erro);
	}
	
	
	@ExceptionHandler(ObjectNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(ObjectNotFoundException ex) {
		String erro = "Objeto não encontrado";
		Erro apiError = new Erro();
		apiError.setStatus(HttpStatus.NOT_FOUND);
		apiError.setMessagem(erro);
		apiError.setDebugMessagem(ex.getLocalizedMessage());
		
		return construtorDaEntidadeResposta(apiError);
	}
	
	@ExceptionHandler(NegocioException.class)
	protected ResponseEntity<Object> handleAlreadyExistentObject(NegocioException ex) {
		String erro = "Objeto já existente";
		Erro apiError = new Erro();
		apiError.setStatus(HttpStatus.NOT_ACCEPTABLE);
		apiError.setMessagem(erro);
		apiError.setDebugMessagem(ex.getLocalizedMessage());
		
		return construtorDaEntidadeResposta(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagemAmigavel = "Requisição JSON malformada";
		
		Erro erro = new Erro();
		erro.setStatus(status);
		erro.setMessagem(mensagemAmigavel);
		erro.setDebugMessagem(ex.getLocalizedMessage());
		
		return construtorDaEntidadeResposta(erro);
	}
	
	private ResponseEntity<Object> construtorDaEntidadeResposta(Erro ErroDeApi) {
		return new ResponseEntity<>(ErroDeApi, ErroDeApi.getStatus());
	}
}
