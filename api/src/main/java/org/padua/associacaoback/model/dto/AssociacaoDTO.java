package org.padua.associacaoback.model.dto;

import lombok.Value;
import org.padua.associacaoback.model.entity.AssociacaoEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link AssociacaoEntity}
 */
@Value
public class AssociacaoDTO implements Serializable {
    UUID id;
    String nome;
    UUID enderecoId;
    String cnpj;
}
