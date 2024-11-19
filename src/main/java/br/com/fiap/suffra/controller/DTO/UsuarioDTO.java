package br.com.fiap.suffra.controller.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public class UsuarioDTO {

    private long id;

    private String nome;

    @CPF
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @Email
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$|^\\+(?:[0-9] ?){6,14}[0-9]$",
            message = "Formato inválido de número de telefone")
    private String telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public @CPF @NotBlank(message = "CPF é obrigatório") String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF @NotBlank(message = "CPF é obrigatório") String cpf) {
        this.cpf = cpf;
    }

    public @Email @NotBlank(message = "Email é obrigatório") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "Email é obrigatório") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$|^\\+(?:[0-9] ?){6,14}[0-9]$",
            message = "Formato inválido de número de telefone") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$|^\\+(?:[0-9] ?){6,14}[0-9]$",
            message = "Formato inválido de número de telefone") String telefone) {
        this.telefone = telefone;
    }
}
