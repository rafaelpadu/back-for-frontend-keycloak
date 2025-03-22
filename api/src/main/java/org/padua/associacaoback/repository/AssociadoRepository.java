package org.padua.associacaoback.repository;

import org.padua.associacaoback.model.entity.AssociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, UUID> {
}
