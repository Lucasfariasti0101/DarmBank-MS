package br.com.darm.api.banco.mscliente.model;

import br.com.darm.api.banco.mscliente.enums.TipoConta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;

    @Enumerated(value = EnumType.STRING)
    private TipoConta tipoConta;

    private String senha;
}
