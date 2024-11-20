package br.com.fiap.suffra.controller.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

public class VotoDTO extends RepresentationModel<VotoDTO> {

    private long id;

    @NotNull(message = "Data do voto obrigatória")
    private LocalDateTime dataVoto;

    @NotNull(message = "peso é obrigatório")
    private long peso = 1;

    private long usuarioId;

    private long regiaoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "Data do voto obrigatória") LocalDateTime getDataVoto() {
        return dataVoto;
    }

    public void setDataVoto(@NotNull(message = "Data do voto obrigatória") LocalDateTime dataVoto) {
        this.dataVoto = dataVoto;
    }

    @NotNull(message = "peso é obrigatório")
    public long getPeso() {
        return peso;
    }

    public void setPeso(@NotNull(message = "peso é obrigatório") long peso) {
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
