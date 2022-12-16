package br.com.darm.api.banco.mscliente.repository;

import br.com.darm.api.banco.mscliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Cliente, UUID> {
}
