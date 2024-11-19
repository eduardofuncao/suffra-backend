package br.com.fiap.suffra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome da campanha é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @NotBlank(message = "Categoria é obrigatória")
    @Size(min = 3, max = 50, message = "A categoria deve ter entre 3 e 50 caracteres")
    private String categoria;

    @NotBlank(message = "Endpoint é obrigatório")
    @Size(min = 3, max = 100, message = "O endpoint deve ter entre 3 e 100 caracteres")
    private String endpoint;

    @NotNull(message = "Data de início é obrigatória")
    @Future(message = "A data de início deve ser futura")
    private LocalDateTime dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    @Future(message = "A data de fim deve ser futura")
    private LocalDateTime dataFim;

    @NotBlank(message = "o campo Variável contabilizada é obrigatória")
    @Size(min = 3, max = 50, message = "A variável contabilizada deve ter entre 3 e 50 caracteres")
    private String variavelContabilizada;

    private long idRegiaoVencedora;

    @NotBlank(message = "O campo Benefício concedido é obrigatório")
    @Size(min = 3, max = 100, message = "O benefício concedido deve ter entre 3 e 100 caracteres")
    private String beneficio_concedido;

    @OneToMany(mappedBy = "campanha")
    private List<Regiao> regioes;

    public Campanha() {
    }

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

    public @NotBlank(message = "Categoria é obrigatória") @Size(min = 3, max = 50, message = "A categoria deve ter entre 3 e 50 caracteres") String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotBlank(message = "Categoria é obrigatória") @Size(min = 3, max = 50, message = "A categoria deve ter entre 3 e 50 caracteres") String categoria) {
        this.categoria = categoria;
    }

    public @NotBlank(message = "Endpoint é obrigatório") @Size(min = 3, max = 100, message = "O endpoint deve ter entre 3 e 100 caracteres") String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(@NotBlank(message = "Endpoint é obrigatório") @Size(min = 3, max = 100, message = "O endpoint deve ter entre 3 e 100 caracteres") String endpoint) {
        this.endpoint = endpoint;
    }

    public @NotNull(message = "Data de fim é obrigatória") @Future(message = "A data de fim deve ser futura") LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(@NotNull(message = "Data de fim é obrigatória") @Future(message = "A data de fim deve ser futura") LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public @NotNull(message = "Data de início é obrigatória") @Future(message = "A data de início deve ser futura") LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(@NotNull(message = "Data de início é obrigatória") @Future(message = "A data de início deve ser futura") LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public @NotBlank(message = "o campo Variável contabilizada é obrigatória") @Size(min = 3, max = 50, message = "A variável contabilizada deve ter entre 3 e 50 caracteres") String getVariavelContabilizada() {
        return variavelContabilizada;
    }

    public void setVariavelContabilizada(@NotBlank(message = "o campo Variável contabilizada é obrigatória") @Size(min = 3, max = 50, message = "A variável contabilizada deve ter entre 3 e 50 caracteres") String variavelContabilizada) {
        this.variavelContabilizada = variavelContabilizada;
    }

    public long getIdRegiaoVencedora() {
        return idRegiaoVencedora;
    }

    public void setIdRegiaoVencedora(long idRegiaoVencedora) {
        this.idRegiaoVencedora = idRegiaoVencedora;
    }

    public @NotBlank(message = "O campo Benefício concedido é obrigatório") @Size(min = 3, max = 100, message = "O benefício concedido deve ter entre 3 e 100 caracteres") String getBeneficio_concedido() {
        return beneficio_concedido;
    }

    public void setBeneficio_concedido(@NotBlank(message = "O campo Benefício concedido é obrigatório") @Size(min = 3, max = 100, message = "O benefício concedido deve ter entre 3 e 100 caracteres") String beneficio_concedido) {
        this.beneficio_concedido = beneficio_concedido;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public void setRegioes(List<Regiao> regioes) {
        this.regioes = regioes;
    }
}
