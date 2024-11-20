package br.com.fiap.suffra.controller.DTO;

import jakarta.validation.constraints.Positive;

public class ContadorRegiaoDTO {
    private Long idRegiao;

    private Long contador;

    public long getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(long idRegiao) {
        this.idRegiao = idRegiao;
    }

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public ContadorRegiaoDTO() {
    }

    public ContadorRegiaoDTO(Long idRegiao, Long contador) {
        this.idRegiao = idRegiao;
        this.contador = contador;
    }
}
