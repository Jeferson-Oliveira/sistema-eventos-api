package com.eventos.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="TB_LOCALIZACAO_EVENTO")
public class LocalizacaoEvento implements Serializable {

	private static final long serialVersionUID = -459952445100780719L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_LOCALIZACAO_EVENTO")
	private Long idLocalizacaoEvento;
	
	@Column(nullable=false, precision=9, scale=6)
	private BigDecimal latitude;
	
	@Column(nullable=false, precision=9, scale=6)
	private BigDecimal longitude;
	
	@Column(nullable=false, length=500)
	private String descricao;

	public LocalizacaoEvento(Long idLocalizacaoEvento, BigDecimal latitude, BigDecimal longitude, String descricao) {
		this.idLocalizacaoEvento = idLocalizacaoEvento;
		this.latitude = latitude;
		this.longitude = longitude;
		this.descricao = descricao;
	}

	public Long getIdLocalizacaoEvento() {
		return idLocalizacaoEvento;
	}

	public void setIdLocalizacaoEvento(Long idLocalizacaoEvento) {
		this.idLocalizacaoEvento = idLocalizacaoEvento;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
