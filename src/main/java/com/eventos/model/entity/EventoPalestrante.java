package com.eventos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="TB_EVENTO_PALESTRANTE")
public class EventoPalestrante implements Serializable {

	private static final long serialVersionUID = -6749099114533317731L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_EVENTO_PALESTRANTE")
	private Long idEventoPalestrante;

	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="ID_PALESTRANTE")
	private Palestrante palestrante;

	public EventoPalestrante(Long idEventoPalestrante, Evento evento, Palestrante palestrante) {
		this.idEventoPalestrante = idEventoPalestrante;
		this.evento = evento;
		this.palestrante = palestrante;
	}

	public Long getIdEventoPalestrante() {
		return idEventoPalestrante;
	}

	public void setIdEventoPalestrante(Long idEventoPalestrante) {
		this.idEventoPalestrante = idEventoPalestrante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}
	
	public Palestrante getPalestrante() {
		return palestrante;
	}
}
