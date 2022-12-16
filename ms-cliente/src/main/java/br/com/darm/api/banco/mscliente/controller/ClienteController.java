package br.com.darm.api.banco.mscliente.controller;

import br.com.darm.api.banco.mscliente.dto.CartaoDto;
import br.com.darm.api.banco.mscliente.dto.ClienteDto;
import br.com.darm.api.banco.mscliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cadastro")
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteDto clienteDto) {
        ClienteDto clienteSalvo = clienteService.cadastrar(clienteDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/cadastro")
                .buildAndExpand(clienteSalvo)
                .toUri();
        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @PostMapping("/cadastrar-cartao")
    public ResponseEntity<CartaoDto> cadastrarCartao(CartaoDto dto) {
        clienteService.cadastrarCartao(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/cadastrar-cartao")
                .buildAndExpand(dto)
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/cartoes/{id}")
    public ResponseEntity<List<CartaoDto>> listarCartoes(@PathVariable UUID clientId) {

        List<CartaoDto> cartoes = clienteService.listarCartoes(clientId);

        return ResponseEntity.ok(cartoes);
    }

}
