package org.padua.associacaoback.model.converters;

import org.padua.associacaoback.model.dto.AssociacaoDTO;
import org.padua.associacaoback.model.entity.AssociacaoEntity;

public class AssociacaoConverter {
    public static AssociacaoEntity toEntity(AssociacaoDTO associacaoDTO) {
        return new AssociacaoEntity(
                associacaoDTO.getId(),
                associacaoDTO.getNome(),
                associacaoDTO.getEnderecoId(),
                associacaoDTO.getCnpj()
        );
    }

    public static AssociacaoDTO toDTO(AssociacaoEntity associacaoEntity) {
        return new AssociacaoDTO(
                associacaoEntity.getId(),
                associacaoEntity.getNome(),
                associacaoEntity.getEnderecoId(),
                associacaoEntity.getCnpj()
        );
    }
}
