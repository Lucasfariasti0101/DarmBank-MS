package br.com.darm.api.banco.msadmin.repository;

import br.com.darm.api.banco.msadmin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
