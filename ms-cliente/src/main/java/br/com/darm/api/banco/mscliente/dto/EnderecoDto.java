package br.com.darm.api.banco.mscliente.dto;

import br.com.darm.api.banco.mscliente.model.Endereco;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EnderecoDto {

    private String estado;

    private String cidade;

    public Endereco criarEntityEndereco() {
        return new Endereco(estado, cidade);
    }

    public static EnderecoDto criarEntityEnderecoDto(Endereco endereco) {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setCidade(endereco.getCidade());
        enderecoDto.setEstado(endereco.getEstado());
        return enderecoDto;
    }
}
