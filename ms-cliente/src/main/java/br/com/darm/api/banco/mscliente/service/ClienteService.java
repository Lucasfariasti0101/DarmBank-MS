package br.com.darm.api.banco.mscliente.service;

import br.com.darm.api.banco.mscliente.dto.CartaoDto;
import br.com.darm.api.banco.mscliente.dto.ClienteDto;
import br.com.darm.api.banco.mscliente.http.CartaoClient;
import br.com.darm.api.banco.mscliente.model.Cliente;
import br.com.darm.api.banco.mscliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    ClientRepository clienteRepo;

    @Autowired
    CartaoClient cartaoClient;

    public ClienteDto cadastrar(ClienteDto dto) {
        Cliente cliente = dto.criarCliente();
        clienteRepo.save(cliente);

        ClienteDto clienteDto = new ClienteDto();
        return clienteDto.criaClientDTO(cliente);
    }

    public CartaoDto cadastrarCartao(CartaoDto cartaoDto) {
        return cartaoClient.cadastrar(cartaoDto);
    }


    public List<CartaoDto> listarCartoes(UUID clienteId) {
       return cartaoClient.listarCartoes(clienteId);

    }
}
