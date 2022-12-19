package br.com.darm.api.banco.msadmin.service;

import br.com.darm.api.banco.msadmin.dto.AdminDTO;
import br.com.darm.api.banco.msadmin.dto.CartaoDTO;
import br.com.darm.api.banco.msadmin.http.CartaoClient;
import br.com.darm.api.banco.msadmin.model.Admin;
import br.com.darm.api.banco.msadmin.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepo;

    @Autowired
    CartaoClient cartaoClient;

    @Autowired
    ModelMapper mapper;

    public Admin cadastrar(AdminDTO dto) {
        Admin adminToSave = mapper.map(dto, Admin.class);
        return adminRepo.save(adminToSave);
    }

    public List<CartaoDTO> listarCartoesClienteId(UUID clienteId) {
        //TODO: Implement circuit breaker with resilience4j
        return cartaoClient.listarCartoesClienteId(clienteId);
    }

    public CartaoDTO atualizarStatusCartao(String numeroCartao, String status, String mensagem) {
        //TODO: Implement circuit breaker with resilience4j
        return cartaoClient.atualizarStatusCartao(numeroCartao);
    }

}
