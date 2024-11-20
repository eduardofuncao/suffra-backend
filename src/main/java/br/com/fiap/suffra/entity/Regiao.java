package br.com.fiap.suffra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome da campanha é obrigatório")
    @Size(min = 4, max = 100, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres")
    private String descricao;

    private long contador;

    @ManyToOne
    private Campanha campanha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres") String descricao) {
        this.descricao = descricao;
    }

    public @NotBlank(message = "Nome da campanha é obrigatório") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 50 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome da campanha é obrigatório") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 50 caracteres") String nome) {
        this.nome = nome;
    }

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public Regiao() {
    }
}
