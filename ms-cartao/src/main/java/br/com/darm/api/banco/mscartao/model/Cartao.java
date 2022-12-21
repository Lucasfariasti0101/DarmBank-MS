package br.com.darm.api.banco.mscartao.model;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import br.com.darm.api.banco.mscartao.enums.StatusCartao;
import br.com.darm.api.banco.mscartao.enums.TipoCartao;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 16, nullable = false, unique = true)
    private String numero;

    @Column(length = 3)
    private String cvc;

    private String bandeira;

    private String dataValidade;

    @Enumerated(value = EnumType.STRING)
    private StatusCartao statusCartao;

    @Enumerated(value = EnumType.STRING)
    private TipoCartao tipoCartao;

    private String nomeCliente;

    @Column(nullable = false)
    private UUID clienteId;

    public static Cartao criarCartao(CartaoDto dto) {
        Cartao cartao = new Cartao();
        cartao.setNumero(dto.getNumero());
        cartao.setCvc(dto.getCvc());
        cartao.setBandeira(dto.getBandeira());
        cartao.setDataValidade(dto.getDataValidade());
        cartao.setNomeCliente(dto.getNomeCliente());
        cartao.setClienteId(UUID.fromString(dto.getIdCliente()));
        cartao.setTipoCartao(TipoCartao.valueOf(dto.getTipoCartao()));
        return cartao;
    }

}
