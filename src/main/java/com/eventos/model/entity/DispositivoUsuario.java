package com.eventos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="TB_DISPOSITIVO_USUARIO")
public class DispositivoUsuario implements Serializable {

	private static final long serialVersionUID = 8365114386956439197L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_DISPOSITIVO_USUARIO")
	private Long idDispositivoUsuario;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@Column(name="TOKEN_DISPOSITIVO", nullable=false, length=500)
	private String tokenDispositivo;

	
	public DispositivoUsuario(Long idDispositivoUsuario, Usuario usuario, String tokenDispositivo) {
		this.idDispositivoUsuario = idDispositivoUsuario;
		this.usuario = usuario;
		this.tokenDispositivo = tokenDispositivo;
	}

	public void setIdDispositivoUsuario(Long idDispositivoUsuario) {
		this.idDispositivoUsuario = idDispositivoUsuario;
	}
	
	public Long getIdDispositivoUsuario() {
		return idDispositivoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTokenDispositivo() {
		return tokenDispositivo;
	}

	public void setTokenDispositivo(String tokenDispositivo) {
		this.tokenDispositivo = tokenDispositivo;
	}
	
}
