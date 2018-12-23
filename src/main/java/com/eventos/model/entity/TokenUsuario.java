package com.eventos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="TB_TOKEN_USUARIO")
public class TokenUsuario implements Serializable {

	private static final long serialVersionUID = 5569183052687298205L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_TOKEN_USUARIO")
	private Long idTokenUsuario;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@Column(nullable=false, length=750)
	private String token;
	
	@Column(nullable=false)
	private Long expirity;

	public TokenUsuario(Long idTokenUsuario, Usuario usuario, String token, Long expirity) {
		this.idTokenUsuario = idTokenUsuario;
		this.usuario = usuario;
		this.token = token;
		this.expirity = expirity;
	}

	public Long getIdTokenUsuario() {
		return idTokenUsuario;
	}

	public void setIdTokenUsuario(Long idTokenUsuario) {
		this.idTokenUsuario = idTokenUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpirity() {
		return expirity;
	}

	public void setExpirity(Long expirity) {
		this.expirity = expirity;
	}
	
	
}
