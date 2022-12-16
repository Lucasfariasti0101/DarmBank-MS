package br.com.darm.api.banco.mscliente.model;

import jakarta.validation.constraints.NotBlank;

public class Endereco {

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;
}
