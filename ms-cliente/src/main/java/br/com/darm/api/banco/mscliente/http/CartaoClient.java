package br.com.darm.api.banco.mscliente.http;

import br.com.darm.api.banco.mscliente.dto.CartaoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient("cartao-ms")
public interface CartaoClient {
    @RequestMapping(method = RequestMethod.POST, value = "/cartao")
    CartaoDto cadastrar(CartaoDto cartaoDto);

    @RequestMapping(method = RequestMethod.GET, value = "/listar/{clienteId}")
    List<CartaoDto> listarCartoes(UUID id);

}
