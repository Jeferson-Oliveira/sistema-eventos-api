package com.eventos.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.model.entity.MensagemResponse;

@ControllerAdvice(annotations=RestController.class)
@ResponseBody
public class ErrorHandle {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemResponse> handleGenericExeption(Exception ex) {
		MensagemResponse mensagem = new MensagemResponse( -1, ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
	}
}
