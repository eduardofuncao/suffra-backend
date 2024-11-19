package br.com.fiap.suffra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Voto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Data do voto é obrigatória")
    private LocalDateTime data_voto;

    @NotBlank(message = "peso é obrigatório")
    private double peso = 1;

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

    public @NotBlank(message = "Data do voto é obrigatória") LocalDateTime getData_voto() {
        return data_voto;
    }

    public void setData_voto(@NotBlank(message = "Data do voto é obrigatória") LocalDateTime data_voto) {
        this.data_voto = data_voto;
    }

    @NotBlank(message = "Data do peso é obrigatória")
    public double getPeso() {
        return peso;
    }

    public void setPeso(@NotBlank(message = "Data do peso é obrigatória") double peso) {
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
