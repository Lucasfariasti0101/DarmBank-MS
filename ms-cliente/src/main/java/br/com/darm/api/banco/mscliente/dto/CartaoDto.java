package br.com.darm.api.banco.mscliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
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
    private String dataValidade;
    @NotBlank
    private String tipoCartao;
    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String idCliente;
}
