package br.com.darm.api.banco.msadmin.controller;

import br.com.darm.api.banco.msadmin.dto.AdminDTO;
import br.com.darm.api.banco.msadmin.model.Admin;
import br.com.darm.api.banco.msadmin.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/cadastro")
    public ResponseEntity<Admin> cadastrar(@RequestBody @Valid AdminDTO adminDTO) {
        Admin adminSalvo = adminService.cadastrar(adminDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/admin/cadastro")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(uri).body(adminSalvo);
    }



}
