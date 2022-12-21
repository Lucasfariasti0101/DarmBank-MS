package br.com.darm.api.banco.mscartao.dtos;

import br.com.darm.api.banco.mscartao.enums.TipoCartao;
import br.com.darm.api.banco.mscartao.model.Cartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
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
    private String tipoCartao;

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String idCliente;
    public static CartaoDto criarCartaoDto(Cartao cartao) {
        CartaoDto cartaoDto = new CartaoDto();

        cartaoDto.setBandeira(cartao.getBandeira());
        cartaoDto.setCvc(cartao.getCvc());
        cartaoDto.setNumero(cartao.getNumero());
        cartaoDto.setDataValidade(cartao.getDataValidade());
        cartaoDto.setNomeCliente(cartao.getNomeCliente());
        cartaoDto.setIdCliente(cartao.getClienteId().toString());
        cartaoDto.setTipoCartao(cartao.getTipoCartao().toString());
        return cartaoDto;
    }
}
