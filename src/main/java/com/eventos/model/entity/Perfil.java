package com.eventos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="TB_PERFIL")
public class Perfil implements Serializable {

	private static final long serialVersionUID = -5461934473814793896L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_PERFIL")
	private Long idPerfil;
	
	@Column(nullable=false, unique=true)
	private Long codigo;
	
	@Column(nullable=false, length=50)
	private String descricao;
	
	public Perfil() {
		// TODO Auto-generated constructor stub
	}
	
	public Perfil(Long idPerfil, Long codigo, String descricao) {
		this.idPerfil = idPerfil;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
