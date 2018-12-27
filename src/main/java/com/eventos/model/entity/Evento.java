package com.eventos.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="TB_EVENTO")
public class Evento implements Serializable {

	private static final long serialVersionUID = 5250063726064066411L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_EVENTO")
	private Long idEvento;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private CategoriaEvento categoria;
	
	@OneToOne
	@JoinColumn(name="ID_LOCALIZACAO")
	private LocalizacaoEvento localizacao;
	
	@Column(nullable=false, length=250)
	private String titulo;
	
	@Column(nullable=false, length=500)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_INICIO", nullable=false)
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_FIM", nullable=false)
	private Date dataFim;

	@OneToMany(mappedBy="palestrante")
	private List<EventoPalestrante> palestrantes = new ArrayList<>();
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}
	
	public Evento(Long idEvento, CategoriaEvento categoria, LocalizacaoEvento localizacao, String titulo,
			String descricao, Date dataInicio, Date dataFim) {
		this.idEvento = idEvento;
		this.categoria = categoria;
		this.localizacao = localizacao;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public CategoriaEvento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEvento categoria) {
		this.categoria = categoria;
	}

	public LocalizacaoEvento getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoEvento localizacao) {
		this.localizacao = localizacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public EventoPalestrante addPalestrante(EventoPalestrante eventoPalestrante){
		eventoPalestrante.setEvento(this);
		palestrantes.add(eventoPalestrante);
		return eventoPalestrante;
	}
	
	public List<EventoPalestrante> getPalestrantes() {
		return palestrantes;
	}

}
