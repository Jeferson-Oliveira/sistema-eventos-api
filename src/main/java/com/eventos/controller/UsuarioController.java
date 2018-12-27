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
import com.eventos.model.entity.MensagemResponse;
import com.eventos.model.entity.Usuario;
import com.eventos.model.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Usuários")
@RestController
@RequestMapping(Constants.BASE_URL+"usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@ApiOperation(
			value="Lista todos os usuários",
			notes="Essa operação lista todos os usuários cadastrados na aplicação",
			response=Usuario.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna uma lista de registros da base de dados", response=Usuario.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos() {
		return new ResponseEntity<>(getService().findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(
			value="Cadastrar Usuário",
			notes="Essa operação salva os dados de um usuario na aplicação",
			response=Usuario.class)
	@ApiResponses(value = {
			@ApiResponse(code=201, message="Retorna o novo registro da base de dados", response=Usuario.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(getService().save(usuario), HttpStatus.CREATED);
	}
	
	@ApiOperation(
			value="Atualizar Usuário",
			notes="Essa operação atualiza os dados de uma entidade na aplicação")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna a entidade com os dados atualizados da base de dados", response=Usuario.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@PutMapping
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(getService().save(usuario), HttpStatus.OK);
	}
	
	@ApiOperation(
			value="Detalhar Usuário",
			notes="Essa operação detalha um usuário da aplicação",
			response=Usuario.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna um usuário", response=Usuario.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> detalhar(@PathVariable Long id) {
		return new ResponseEntity<>(getService().findById(id).get(), HttpStatus.OK);
	}
	
	@ApiOperation(
			value="Remover Usuário",
			notes="Essa operação remove um usuário da aplicação",
			response=Usuario.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Retorna uma mensagem de sucesso", response=MensagemResponse.class),
			@ApiResponse(code=400, message="Uma mensagem de erro ", response=MensagemResponse.class)})
	@DeleteMapping("/{id}")
	public ResponseEntity<MensagemResponse> remover(@PathVariable Long id) {	
		return new ResponseEntity<>(getService().deleteById(id), HttpStatus.OK);
	}
	
	public UsuarioService getService() {
		return service;
	}
	
	public void setService(UsuarioService service) {
		this.service = service;
	}
	
}
