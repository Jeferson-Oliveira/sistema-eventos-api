package com.eventos.model.entity;

public class MensagemResponse {
	
	private Integer codigo;
	
	private String mensagemDesenvolvedor;
	
	private String mensagemUsuario;
	
	public MensagemResponse(String mensagemUsuario) {
		this.codigo = -1;
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = "";
	}
	
	public MensagemResponse(Integer codigo, String mensagemDesenvolvedor, String mensagemUsuario) {
		this.codigo = codigo;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		this.mensagemUsuario = mensagemUsuario;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
	
	public String getMensagemUsuario() {
		return mensagemUsuario;
	}
	
	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
