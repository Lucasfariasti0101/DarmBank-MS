package br.com.darm.api.banco.mscartao.repository;

import br.com.darm.api.banco.mscartao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
    List<Cartao> findAllByClienteId(UUID clienteId);
}
