package com.eventos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.entity.Perfil;
import java.lang.Long;
import java.util.List;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
		
	List<Perfil> findByCodigo(Long codigo);

}
