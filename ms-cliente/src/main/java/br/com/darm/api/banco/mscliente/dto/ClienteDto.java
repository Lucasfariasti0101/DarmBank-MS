package br.com.darm.api.banco.mscliente.dto;

import br.com.darm.api.banco.mscliente.model.Cliente;
import br.com.darm.api.banco.mscliente.model.Endereco;
import br.com.darm.api.banco.mscliente.enums.TipoConta;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class ClienteDto {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String telefone;

    @NotBlank
    private Endereco endereco;

    @NotBlank
    private TipoConta tipoConta;

    @NotBlank
    private String senha;

    public Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        cliente.setTipoConta(tipoConta);
        cliente.setSenha(senha);
        return cliente;
    }

    public ClienteDto criaClientDTO(Cliente cliente) {
        ClienteDto clienteDto =  new ClienteDto();

        clienteDto.setCpf(cliente.getCpf());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setSenha(cliente.getSenha());
        clienteDto.setTelefone(cliente.getTelefone());
        clienteDto.setTipoConta(cliente.getTipoConta());
        clienteDto.setEndereco(cliente.getEndereco());

        return clienteDto;
    }
}
