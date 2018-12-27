package com.eventos.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -648879829501787646L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_USUARIO")
	private Long idUsuario;
	
	@ManyToOne
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;
	
	@Column(nullable=false, unique=true, length=250)
	private String email;
	
	@Column(nullable=false, length=500)
	private String senha;
	
	@OneToMany(mappedBy="usuario")
	private List<DispositivoUsuario> dispositivos = new ArrayList<>();

	@OneToMany(mappedBy="usuario")
	private List<TokenUsuario> tokens = new ArrayList<>();
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Long idUsuario, Perfil perfil, String email, String senha) {
		this.idUsuario = idUsuario;
		this.perfil = perfil;
		this.email = email;
		this.senha = senha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public DispositivoUsuario addDispositivo(DispositivoUsuario dispositivoUsuario) {
		dispositivoUsuario.setUsuario(this);
		dispositivos.add(dispositivoUsuario);
		return dispositivoUsuario;
	}
	
	public List<DispositivoUsuario> getDispositivos() {
		return dispositivos;
	}
	
	public TokenUsuario addToken(TokenUsuario tokenUsuario) {
		tokenUsuario.setUsuario(this);
		tokens.add(tokenUsuario);
		return tokenUsuario;
	}
	
	public List<TokenUsuario> getTokens() {
		return tokens;
	}
	
	
}
