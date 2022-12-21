package br.com.darm.api.banco.mscartao.service;

import br.com.darm.api.banco.mscartao.dtos.CartaoDto;
import br.com.darm.api.banco.mscartao.enums.StatusCartao;
import br.com.darm.api.banco.mscartao.model.Cartao;
import br.com.darm.api.banco.mscartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository cartaoRepo;

    public Cartao cadastrar(CartaoDto cartaoDto) {
        Cartao cartaoToSave = Cartao.criarCartao(cartaoDto);
        cartaoToSave.setStatusCartao(StatusCartao.PENDENTE);
        return cartaoRepo.save(cartaoToSave);
    }


    public List<Cartao> listarCartoes(String clienteId) {
        return cartaoRepo.findAllByClienteId(clienteId);
    }

    public void excluir(UUID idCliente, String numeroCartao) {
        cartaoRepo.deleteByNumeroIdCliente(numeroCartao, idCliente);

    }

    public Cartao atualizarStatus(String numeroCartao, String status, String mensagem) {
        Optional<Cartao> cartao = cartaoRepo.findByNumero(numeroCartao);
        cartao.ifPresent(value -> value.setStatusCartao(StatusCartao.valueOf(status.toUpperCase())));
        return cartao.orElseThrow(IllegalArgumentException::new);
    }

    public Page<Cartao> listarTodos(Pageable pageable) {
        return cartaoRepo.findAll(pageable);
    }

    public Page<Cartao> listarPorStatus(String status, Pageable pageable) {
        status = status.toUpperCase();
        if (status.equals(StatusCartao.APROVADO.name())
                || status.equals(StatusCartao.REPROVADO.name())
                || status.equals(StatusCartao.PENDENTE.name())) {

            return cartaoRepo.findAllByStatus(status, pageable);
        }
        throw new IllegalArgumentException("{}"+status);
    }
}
