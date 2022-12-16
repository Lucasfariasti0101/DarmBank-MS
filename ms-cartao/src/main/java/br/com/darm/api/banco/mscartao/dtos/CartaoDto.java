package br.com.darm.api.banco.mscartao.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CartaoDto {
    @NotBlank
    @Size(min = 16, max = 16)
    private String numero;

    @NotBlank
    @Size(min = 3, max = 3)
    private String cvc;

    @NotBlank
    private String bandeira;

    @NotBlank
    private String dataValidade;

    @NotBlank
    private String nomeCliente;
}
