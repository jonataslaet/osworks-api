package br.com.osworks.controller.exception;

public class ErroDeCampo {

	private String objeto;
	private String campo;
	private Object valorRejeitado;
	private String mensagem;
	
	public ErroDeCampo(String objeto, String campo, Object valorRejeitado, String mensagem) {
		this.objeto = objeto;
		this.campo = campo;
		this.valorRejeitado = valorRejeitado;
		this.mensagem = mensagem;
	}
	
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public Object getValorRejeitado() {
		return valorRejeitado;
	}
	public void setValorRejeitado(Object valorRejeitado) {
		this.valorRejeitado = valorRejeitado;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
