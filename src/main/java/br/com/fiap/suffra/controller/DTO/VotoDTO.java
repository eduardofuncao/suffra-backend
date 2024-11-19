package br.com.fiap.suffra.controller.DTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class VotoDTO {

    private long id;

    @NotBlank(message = "Data do voto é obrigatória")
    private LocalDateTime data_voto;

    @NotBlank(message = "peso é obrigatório")
    private double peso = 1;

    private long usuarioId;

    private long regiaoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Data do voto é obrigatória") LocalDateTime getData_voto() {
        return data_voto;
    }

    public void setData_voto(@NotBlank(message = "Data do voto é obrigatória") LocalDateTime data_voto) {
        this.data_voto = data_voto;
    }

    @NotBlank(message = "peso é obrigatório")
    public double getPeso() {
        return peso;
    }

    public void setPeso(@NotBlank(message = "peso é obrigatório") double peso) {
        this.peso = peso;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(long regiaoId) {
        this.regiaoId = regiaoId;
    }
}
