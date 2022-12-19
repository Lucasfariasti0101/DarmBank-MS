package br.com.darm.api.banco.msadmin.dto;

import br.com.darm.api.banco.msadmin.model.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public class AdminDTO {

    @NotBlank
    private String nome;

    @Email
    private String email;
    @CPF
    private String cpf;

    @NotBlank
    private Endereco endereco;

    @NotBlank
    private String senha;
}
