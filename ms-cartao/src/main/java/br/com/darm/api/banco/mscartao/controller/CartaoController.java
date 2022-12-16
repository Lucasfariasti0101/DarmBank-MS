package br.com.darm.api.banco.mscartao.controller;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import br.com.darm.api.banco.mscartao.model.Cartao;
import br.com.darm.api.banco.mscartao.service.CartaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    CartaoService cartaoService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public Cartao cadastrar(CartaoDto cartaoDto) {
       return cartaoService.cadastrar(cartaoDto);
    }

    @GetMapping("/listar/{clientId}")
    public List<CartaoDto> listarCartoes(@PathVariable UUID clienteId) {
       List<Cartao> cartoesList = cartaoService.listarCartoes(clienteId);

        return cartoesList.stream()
                .map(cartao -> mapper.map(cartao, CartaoDto.class)).toList();
    }
}
