package br.com.fiap.suffra.controller;

import br.com.fiap.suffra.controller.DTO.ErroDetalhesDTO;
import br.com.fiap.suffra.exception.CampanhaJaFinalizadaException;
import br.com.fiap.suffra.exception.NaoEncontradoException;
import br.com.fiap.suffra.exception.UsuarioJaExisteException;
import br.com.fiap.suffra.exception.VotoFuturoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErroDetalhesDTO> handleNaoEncontradoException(NaoEncontradoException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CampanhaJaFinalizadaException.class)
    public ResponseEntity<ErroDetalhesDTO> handleCampanhaJaFinalizadaException(CampanhaJaFinalizadaException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UsuarioJaExisteException.class)
    public ResponseEntity<ErroDetalhesDTO> handleUsuarioJaExisteException(UsuarioJaExisteException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(VotoFuturoException.class)
    public ResponseEntity<ErroDetalhesDTO> handleVotoFuturoException(VotoFuturoException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }


}
