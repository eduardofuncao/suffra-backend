package br.com.fiap.suffra.exception;

public class UsuarioJaExisteException extends RuntimeException{
    public UsuarioJaExisteException(String message){super(message);}
}
