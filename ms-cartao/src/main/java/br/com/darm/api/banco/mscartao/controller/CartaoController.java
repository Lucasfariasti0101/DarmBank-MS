package br.com.darm.api.banco.mscartao.controller;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import br.com.darm.api.banco.mscartao.model.Cartao;
import br.com.darm.api.banco.mscartao.service.CartaoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    CartaoService cartaoService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public Cartao cadastrar(@Valid CartaoDto cartaoDto) {
        return cartaoService.cadastrar(cartaoDto);
    }

    @GetMapping("/listar/{clientId}")
    public List<CartaoDto> listarCartoes(@PathVariable UUID clienteId) {
        List<Cartao> cartoesList = cartaoService.listarCartoes(clienteId);

        return cartoesList.stream()
                .map(cartao -> mapper.map(cartao, CartaoDto.class)).toList();
    }

    @DeleteMapping("/excluir/{clientId}/{cartaoNumero}")
    public void excluir(@PathVariable UUID idCliente, @PathVariable String numeroCartao) {
        cartaoService.excluir(idCliente, numeroCartao);
    }

    @PatchMapping("/atualizar/status/{numeroCartao}")
    public Cartao atualizarStatus(@PathVariable String numeroCartao,
                                  @RequestBody String status,
                                  @RequestBody String mensagem) {

       return cartaoService.atualizarStatus(numeroCartao, status, mensagem);
    }

}
