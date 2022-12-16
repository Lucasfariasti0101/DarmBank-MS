package br.com.darm.api.banco.mscartao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String numero;

    private String cvc;

    private String bandeira;

    private String dataValidade;

    private String nomeCliente;

}
