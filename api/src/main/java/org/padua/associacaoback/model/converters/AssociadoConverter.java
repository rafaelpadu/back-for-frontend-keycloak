package org.padua.associacaoback.model.converters;

import org.padua.associacaoback.model.dto.AssociadoDTO;
import org.padua.associacaoback.model.entity.AssociadoEntity;

public class AssociadoConverter {
    private AssociadoConverter() {
    }

    public static AssociadoEntity toEntity(AssociadoDTO associadoDTO) {
        return new AssociadoEntity(
                associadoDTO.getId(),
                associadoDTO.getNome(),
                associadoDTO.getCpf(),
                associadoDTO.getDataNascimento(),
                associadoDTO.getEmail(),
                associadoDTO.getTelefone(),
                associadoDTO.getEnderecoId(),
                associadoDTO.getAssociacaoId()
        );
    }

    public static AssociadoDTO toDTO(AssociadoEntity associadoEntity) {
        return new AssociadoDTO(
                associadoEntity.getId(),
                associadoEntity.getNome(),
                associadoEntity.getCpf(),
                associadoEntity.getDataNascimento(),
                associadoEntity.getEmail(),
                associadoEntity.getTelefone(),
                associadoEntity.getEnderecoId(),
                associadoEntity.getAssociacaoId()
        );
    }

}
