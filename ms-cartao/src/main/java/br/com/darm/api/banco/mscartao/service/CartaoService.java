package br.com.darm.api.banco.mscartao.service;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import br.com.darm.api.banco.mscartao.model.Cartao;
import br.com.darm.api.banco.mscartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository cartaoRepo;

    public Cartao cadastrar(CartaoDto cartaoDto) {
        Cartao cartaoToSave = Cartao.criarCartao(cartaoDto);
        return cartaoRepo.save(cartaoToSave);
    }


    public List<Cartao> listarCartoes(UUID clienteId) {
       return cartaoRepo.findAllByClienteId(clienteId);
    }
}
