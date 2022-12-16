package br.com.darm.api.banco.mscartao.model;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
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

    private UUID clienteId;

    public static Cartao criarCartao(CartaoDto dto) {
        Cartao cartao = new Cartao();
        cartao.setNumero(dto.getNumero());
        cartao.setCvc(dto.getCvc());
        cartao.setBandeira(dto.getBandeira());
        cartao.setDataValidade(dto.getDataValidade());
        cartao.setNomeCliente(dto.getNomeCliente());
        return cartao;
    }

}
