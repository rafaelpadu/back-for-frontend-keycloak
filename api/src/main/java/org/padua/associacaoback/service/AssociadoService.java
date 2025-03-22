package org.padua.associacaoback.service;

import org.padua.associacaoback.model.dto.AssociadoDTO;
import org.padua.associacaoback.model.entity.AssociadoEntity;
import org.padua.associacaoback.repository.AssociadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssociadoService {
    private static final Logger log = LoggerFactory.getLogger(AssociadoService.class);
    private final AssociadoRepository associadoRepository;

    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public AssociadoEntity createAssociado(AssociadoEntity associadoEntity) {
        log.info("Associado criado com sucesso!");
        return associadoRepository.save(associadoEntity);
    }


    public AssociadoEntity getAssociadoById(String id) {
        var uuid = UUID.fromString(id);
        return associadoRepository.findById(uuid).orElse(null);
    }

    public AssociadoEntity updateAssociado(String id, AssociadoEntity associadoEntity) {
        var uuid = UUID.fromString(id);
        var associado = associadoRepository.findById(uuid).orElse(null);
        if (associado != null) {
            associado.setDataNascimento(associadoEntity.getDataNascimento());
            associado.setEmail(associadoEntity.getEmail());
            associado.setNome(associadoEntity.getNome());
            associado.setTelefone(associadoEntity.getTelefone());
            log.info("Associado atualizado com sucesso!");
            return associadoRepository.save(associado);
        }
        return null;
    }

    public void deleteAssociado(String id) {
        var uuid = UUID.fromString(id);
        associadoRepository.deleteById(uuid);
        log.info("Associado deletado com sucesso!");
    }

    public List<AssociadoEntity> getAllAssociados() {
        return associadoRepository.findAll();
    }
}
