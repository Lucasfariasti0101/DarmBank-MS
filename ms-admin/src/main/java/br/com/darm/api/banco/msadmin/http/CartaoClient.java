package br.com.darm.api.banco.msadmin.http;

import br.com.darm.api.banco.msadmin.dto.CartaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient("cartao-ms")
public interface CartaoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/listar/{clienteId}")
    List<CartaoDTO> listarCartoesClienteId(@PUUID id);

    @RequestMapping(method = RequestMethod.PATCH, value = "/atualizar/status/{numeroCartao}")
    CartaoDTO atualizarStatusCartao(@PathVariable("numeroCartao") String numeroCartao);
}
