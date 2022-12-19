package br.com.darm.api.banco.mscliente.repository;

import br.com.darm.api.banco.mscliente.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Cliente, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM cliente " +
            "WHERE estado LIKE (:estado) ")
    Page<Cliente> findAllByEstado(String estado, Pageable pageable);
}
