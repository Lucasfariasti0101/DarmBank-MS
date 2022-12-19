package br.com.darm.api.banco.msadmin.dto;

import br.com.darm.api.banco.msadmin.enums.StatusCartao;

import java.util.UUID;


public class CartaoDTO {

    private UUID id;

    private String numero;

    private String cvc;

    private String bandeira;

    private String dataValidade;

    private StatusCartao statusCartao;

    private String nomeCliente;

    private UUID clienteId;

}
