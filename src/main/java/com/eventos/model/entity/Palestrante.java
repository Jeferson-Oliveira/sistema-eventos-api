package com.eventos.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="TB_PALESTRANTE")
public class Palestrante implements Serializable {

	private static final long serialVersionUID = 5553994221289499873L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PALESTRANTE")
	private Long idPalestrante;
	
	@Column(name="URL_FOTO",length=500)
	private String urlFoto;
	
	@Column(nullable=false, length=250)
	private String nome;
	
	@Column(nullable=false, length=500)
	private String descricao;
	
	@OneToMany(mappedBy="palestrante")
	private List<EventoPalestrante> eventos = new ArrayList<>();
	
	public Palestrante() {
		// TODO Auto-generated constructor stub
	}
	
	public Palestrante(Long idPalestrante, String urlFoto, String nome, String descricao) {
		this.idPalestrante = idPalestrante;
		this.urlFoto = urlFoto;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getIdPalestrante() {
		return idPalestrante;
	}

	public void setIdPalestrante(Long idPalestrante) {
		this.idPalestrante = idPalestrante;
	}
	
	public String getUrlFoto() {
		return urlFoto;
	}
	
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public EventoPalestrante addEvento(EventoPalestrante eventoPalestrante) {
		eventoPalestrante.setPalestrante(this);
		eventos.add(eventoPalestrante);
		return eventoPalestrante;
	}
	
	public List<EventoPalestrante> getEventos() {
		return eventos;
	}
	
}
