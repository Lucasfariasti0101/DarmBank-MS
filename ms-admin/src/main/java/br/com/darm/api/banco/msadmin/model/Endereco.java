package br.com.darm.api.banco.msadmin.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;
}
