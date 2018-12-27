package com.eventos.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eventos.model.entity.MensagemResponse;
import com.eventos.model.entity.Perfil;
import com.eventos.model.entity.Usuario;
import com.eventos.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired 
	private PerfilService perfilService;
	
	
	public <S extends Usuario> S save(S entity) {
		
		if(entity.getPerfil() == null) {
			throw new IllegalArgumentException("O Atributo perfil não pode ser nulo");
		}
		
		List<Perfil> perfisEncontrados = getPerfilService().findByCodigo(entity.getPerfil().getCodigo());
		
		if (perfisEncontrados.isEmpty()) {
			throw new IllegalArgumentException("Código de perfil não encontrado");
		}
		
		entity.setPerfil(perfisEncontrados.get(0));
		
		return repository.save(entity);
	}

	public Page<Usuario> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public MensagemResponse deleteById(Long id) {
		if(this.existsById(id)) {
			repository.deleteById(id);
			return new MensagemResponse("Usuário Excluido com sucesso");
		} else {
			throw new IllegalArgumentException("Usuário Inexistente");
		}
	}

	public PerfilService getPerfilService() {
		return perfilService;
	}
	
	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}
	
	public UsuarioRepository getRepository() {
		return repository;
	}
	
	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}
}
