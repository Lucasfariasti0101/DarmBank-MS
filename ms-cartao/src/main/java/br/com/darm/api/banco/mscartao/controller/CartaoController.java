package br.com.darm.api.banco.mscartao.controller;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import br.com.darm.api.banco.mscartao.model.Cartao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @PostMapping
    public Cartao cadastrar(CartaoDto cartaoDto) {

    }
}
