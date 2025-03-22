package org.padua.associacaoback.model.converters;

import org.padua.associacaoback.model.dto.EnderecoDTO;
import org.padua.associacaoback.model.entity.EnderecoEntity;

public class EnderecoConverter {

    public static EnderecoEntity toEntity(EnderecoDTO enderecoDTO) {
        return new EnderecoEntity(
                enderecoDTO.getId(),
                enderecoDTO.getCep(),
                enderecoDTO.getEstado(),
                enderecoDTO.getCidade(),
                enderecoDTO.getBairro(),
                enderecoDTO.getLogradouro(),
                enderecoDTO.getNumero(),
                enderecoDTO.getComplemento()
        );
    }

    public static EnderecoDTO toDTO(EnderecoEntity enderecoEntity) {
        return new EnderecoDTO(
                enderecoEntity.getId(),
                enderecoEntity.getCep(),
                enderecoEntity.getEstado(),
                enderecoEntity.getCidade(),
                enderecoEntity.getBairro(),
                enderecoEntity.getLogradouro(),
                enderecoEntity.getNumero(),
                enderecoEntity.getComplemento()
        );
    }
}
