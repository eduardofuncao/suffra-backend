package br.com.fiap.suffra.controller.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RegiaoDTO {

    private long id;

    @NotBlank(message = "Nome da campanha é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres")
    private String descricao;

    @Positive
    private long contador;

    private long campanhaId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome da campanha é obrigatório") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 50 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome da campanha é obrigatório") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 50 caracteres") String nome) {
        this.nome = nome;
    }

    @Positive
    public long getContador() {
        return contador;
    }

    public void setContador(@Positive long contador) {
        this.contador = contador;
    }

    public @Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres") String descricao) {
        this.descricao = descricao;
    }

    public long getCampanhaId() {
        return campanhaId;
    }

    public void setCampanhaId(long campanhaId) {
        this.campanhaId = campanhaId;
    }
}
