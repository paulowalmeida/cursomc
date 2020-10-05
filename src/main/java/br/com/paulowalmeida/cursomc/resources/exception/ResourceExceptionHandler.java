package br.com.paulowalmeida.cursomc.resources.exception;

import br.com.paulowalmeida.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe filtro responsável por capturar erros na classe Resource e trata-los.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Filtra as requisições que retornarem erro na pesquisa de um recurso que não existe.
     * */
    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objetNotFound(ObjectNotFoundException exception, HttpServletRequest request){
	    StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
