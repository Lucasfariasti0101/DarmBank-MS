package br.com.darm.api.banco.mscliente.dto;

import br.com.darm.api.banco.mscliente.enums.TipoCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class CartaoDto {
    @NotBlank
    @Size(max = 16, min = 16)
    private String numero;
    @NotBlank
    @Size(max = 3, min = 3)
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
