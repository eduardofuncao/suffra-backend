package br.com.fiap.suffra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Voto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Data do voto é obrigatória")
    private LocalDateTime dataVoto;

    @NotNull(message = "peso é obrigatório")
    private long peso = 1;

    @ManyToOne
    private Regiao regiao;

    @ManyToOne
    private Usuario usuario;

    public Voto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "Data do voto é obrigatória") LocalDateTime getDataVoto() {
        return dataVoto;
    }

    public void setDataVoto(@NotNull(message = "Data do voto é obrigatória") LocalDateTime dataVoto) {
        this.dataVoto = dataVoto;
    }

    @NotNull(message = "peso é obrigatório")
    public long getPeso() {
        return peso;
    }

    public void setPeso(@NotNull(message = "peso é obrigatório") long peso) {
        this.peso = peso;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
