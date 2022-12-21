package br.com.darm.api.banco.mscliente.dto;

import br.com.darm.api.banco.mscliente.enums.TipoConta;
import br.com.darm.api.banco.mscliente.model.Cliente;
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
    private EnderecoDto endereco;

    @NotBlank
    private String tipoConta;

    @NotBlank
    private String senha;

    public Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setEndereco(endereco.criarEntityEndereco());
        cliente.setTelefone(telefone);
        cliente.setTipoConta(TipoConta.valueOf(tipoConta.toUpperCase()));
        cliente.setSenha(senha);
        return cliente;
    }

    public ClienteDto criaClientDTO(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setCpf(cliente.getCpf());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setSenha(cliente.getSenha());
        clienteDto.setTelefone(cliente.getTelefone());
        clienteDto.setTipoConta(cliente.getTipoConta().name());
        clienteDto.setEndereco(EnderecoDto.criarEntityEnderecoDto(cliente.getEndereco()));

        return clienteDto;
    }
}
