package com.eventos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.entity.CategoriaEvento;

@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Long> {

}
