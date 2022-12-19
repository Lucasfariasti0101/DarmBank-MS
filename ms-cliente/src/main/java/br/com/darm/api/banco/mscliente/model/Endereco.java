package br.com.darm.api.banco.mscliente.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Endereco {

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;
}
