package br.com.darm.api.banco.msadmin.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String email;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private String senha;
}
