package br.com.fiap.suffra.controller;

import br.com.fiap.suffra.controller.DTO.ErroDetalhesDTO;
import br.com.fiap.suffra.exception.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErroDetalhesDTO> handleDataPassadaException(NaoEncontradoException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }
}
