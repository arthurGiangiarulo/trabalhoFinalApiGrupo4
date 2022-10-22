package com.trabalhofinal.trabalho.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	//tratamento para erros gerais
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		List<String> detalhes = new ArrayList<>();
		
		//pega o nome técnico do erro e coloca em "detalhes"
		detalhes.add(ex.getLocalizedMessage());
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ErrorResponse error = new ErrorResponse(httpStatus.value(), "Erro ao processar a requisição", detalhes);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	//tratamento excluvivo para NoSuchElementFoundException
	@ExceptionHandler(NoSuchElementFoundException.class)
	public final ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementFoundException ex, WebRequest request){
		List<String> detalhes = new ArrayList<>();
		
		detalhes.add(ex.getLocalizedMessage());
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorResponse error = new ErrorResponse(httpStatus.value(), "Registro não encontrado", detalhes);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
