package br.com.darm.api.banco.mscliente.dto;

import br.com.darm.api.banco.mscliente.enums.TipoCartao;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CartaoDto {
    @NotBlank
    private String numero;
    @NotBlank
    private String cvc;
    @NotBlank
    private String bandeira;
    @NotBlank
    private String validade;
    @NotBlank
    private TipoCartao tipoCartao;
    @NotBlank
    private String nomeCliente;
    @NotBlank
    private UUID idCliente;
}
