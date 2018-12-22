package com.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.config.Constants;
import com.eventos.model.entity.CategoriaEvento;
import com.eventos.model.entity.MensagemResponse;
import com.eventos.model.service.CategoriaEventoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(Constants.BASE_URL+"categoria-evento")
public class CategoriaEventoController {

	@Autowired
	private CategoriaEventoService service;
	
	
	@ApiOperation(
			value="Lista todas as Categorias",
			notes="Essa operação lista todas as categorias cadastradas na aplicação",
			response=CategoriaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna uma lista de registros da base de dados", response=CategoriaEvento.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@GetMapping
	public ResponseEntity<List<CategoriaEvento>> listarTodos() {
		return new ResponseEntity<>(getService().findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(
			value="Cadastrar Categoria",
			notes="Essa operação salva os dados de uma categoria na aplicação",
			response=CategoriaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code=201, message="Retorna o novo registro da base de dados", response=CategoriaEvento.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@PostMapping
	public ResponseEntity<CategoriaEvento> salvar(@RequestBody CategoriaEvento categoriaEvento) {
		return new ResponseEntity<>(getService().save(categoriaEvento), HttpStatus.CREATED);
	}
	
	@ApiOperation(
			value="Atualizar Categoria",
			notes="Essa operação atualiza os dados de uma categoria na aplicação",
			response=CategoriaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna a categoria com os dados atualizados da base de dados", response=CategoriaEvento.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@PutMapping
	public ResponseEntity<CategoriaEvento> atualizar(@RequestBody CategoriaEvento categoriaEvento) {
		return new ResponseEntity<>(getService().save(categoriaEvento), HttpStatus.OK);
	}
	
	@ApiOperation(
			value="Detalhar Categoria",
			notes="Essa operação detalha uma categoria da aplicação",
			response=CategoriaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna uma categoria", response=CategoriaEvento.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaEvento> detalhar(@PathVariable Long id) {
		return new ResponseEntity<>(getService().findById(id).get(), HttpStatus.OK);
	}
	
	@ApiOperation(
			value="Remover Categoria",
			notes="Essa operação remove uma categoria da aplicação",
			response=CategoriaEvento.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna uma mensagem de sucesso", response=MensagemResponse.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@DeleteMapping("/{id}")
	public ResponseEntity<MensagemResponse> remover(@PathVariable Long id) {	
		return new ResponseEntity<>(getService().deleteById(id), HttpStatus.OK);
	}
	
	public CategoriaEventoService getService() {
		return service;
	}
	
	public void setService(CategoriaEventoService service) {
		this.service = service;
	}
}
