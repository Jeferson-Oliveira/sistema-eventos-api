package com.eventos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.entity.Perfil;
import com.eventos.model.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;

	public List<Perfil> findByCodigo(Long codigo) {
		return repository.findByCodigo(codigo);
	}

	public void setRepository(PerfilRepository repository) {
		this.repository = repository;
	}
	
	public PerfilRepository getRepository() {
		return repository;
	}
}
