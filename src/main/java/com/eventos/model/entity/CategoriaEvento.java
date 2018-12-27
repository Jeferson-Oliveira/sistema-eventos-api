package com.eventos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="TB_CATEGORIA_EVENTO")
public class CategoriaEvento implements Serializable {

	private static final long serialVersionUID = 4889679119464666965L;

	@Id
	@Column(name="ID_CATEGORIA_EVENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idCategoriaEvento;
	
	@Column(nullable=false, unique=true)
	private Long codigo;
	
	@Column(nullable=false, length=50)
	private String descricao;
	
	public CategoriaEvento() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoriaEvento(Long idCategoriaEvento, Long codigo, String descricao) {
		this.idCategoriaEvento = idCategoriaEvento;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getIdCategoriaEvento() {
		return idCategoriaEvento;
	}

	public void setIdCategoriaEvento(Long idCategoriaEvento) {
		this.idCategoriaEvento = idCategoriaEvento;
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
