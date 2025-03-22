package org.padua.associacaoback.model.dto;

import lombok.Value;
import org.padua.associacaoback.model.entity.EnderecoEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link EnderecoEntity}
 */
@Value
public class EnderecoDTO implements Serializable {
    UUID id;
    Integer cep;
    String estado;
    String cidade;
    String bairro;
    String logradouro;
    String numero;
    String complemento;
}
