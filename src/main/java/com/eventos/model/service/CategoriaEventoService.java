package com.eventos.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eventos.model.entity.CategoriaEvento;
import com.eventos.model.entity.MensagemResponse;
import com.eventos.model.repository.CategoriaEventoRepository;

@Service
public class CategoriaEventoService {

	@Autowired
	private CategoriaEventoRepository repository;
	
	
	public MensagemResponse deleteById(Long id) {
		if(this.existsById(id)) {
			repository.deleteById(id);
			return new MensagemResponse("Categoria Excluida com sucesso");
		} else {
			throw new IllegalArgumentException("Categoria Inexistente");
		}
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public List<CategoriaEvento> findAll() {
		return repository.findAll();
	}

	public Page<CategoriaEvento> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<CategoriaEvento> findById(Long id) {
		return repository.findById(id);
	}

	public <S extends CategoriaEvento> S save(S model) {
		return repository.save(model);
	}
	
	public CategoriaEventoRepository getRepository() {
		return repository;
	}
	
	public void setRepository(CategoriaEventoRepository repository) {
		this.repository = repository;
	}
}
