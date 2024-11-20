package br.com.fiap.suffra.controller.DTO;

import jakarta.validation.constraints.Positive;

public class ContadorRegiaoDTO {
    private Long id;

    private Long contador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public ContadorRegiaoDTO() {
    }

    public ContadorRegiaoDTO(Long id, Long contador) {
        this.id = id;
        this.contador = contador;
    }
}
