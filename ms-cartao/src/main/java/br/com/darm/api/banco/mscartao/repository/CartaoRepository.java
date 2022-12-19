package br.com.darm.api.banco.mscartao.repository;

import br.com.darm.api.banco.mscartao.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
    List<Cartao> findAllByClienteId(UUID clienteId);

    @Query(nativeQuery = true, value = "DELETE * FROM cartao " +
            "WHERE numero LIKE (:numero) " +
            "AND cliente_id LIKE (:clienteId)")
    void deleteByNumeroIdCliente(String numero, UUID clienteId);

    Optional<Cartao> findByNumero(String numero);

    @Query(nativeQuery = true, value = "SELECT * FROM cartao " +
            "WHERE status_cartao LIKE (:status) ")
    Page<Cartao> findAllByStatus(String status, Pageable pageable);
}
