package org.padua.associacaoback.model.dto;

import lombok.Value;
import org.padua.associacaoback.model.entity.AssociadoEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * DTO for {@link AssociadoEntity}
 */
@Value
public class AssociadoDTO implements Serializable {
    UUID id;
    String nome;
    String cpf;
    Date dataNascimento;
    String email;
    String telefone;
    UUID enderecoId;
    UUID associacaoId;
}
