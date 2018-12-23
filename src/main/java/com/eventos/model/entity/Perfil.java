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
	private Integer codigo;
	
	@Column(nullable=false, length=50)
	private String descricao;
	
	public Perfil(Long idPerfil, Integer codigo, String descricao) {
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
