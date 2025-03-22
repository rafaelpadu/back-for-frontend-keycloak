package org.padua.associacaoback.controller;

import org.padua.associacaoback.model.converters.AssociadoConverter;
import org.padua.associacaoback.model.dto.AssociadoDTO;
import org.padua.associacaoback.service.AssociadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
    private final AssociadoService associadoService;

    public AssociadoController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<AssociadoDTO> createAssociado(@RequestBody AssociadoDTO associadoDTO) {
        var associadoEntity = AssociadoConverter.toEntity(associadoDTO);
        associadoEntity = associadoService.createAssociado(associadoEntity);
        associadoDTO = AssociadoConverter.toDTO(associadoEntity);
        return ResponseEntity.ok(associadoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoDTO> getAssociado(@PathVariable String id) {
        var associadoEntity = associadoService.getAssociadoById(id);
        var associadoDTO = AssociadoConverter.toDTO(associadoEntity);
        return ResponseEntity.ok(associadoDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssociadoDTO>> getAllAssociados(Authentication auth) {
        var associadoEntities = associadoService.getAllAssociados();
        var associadoDTOs = associadoEntities.stream().map(AssociadoConverter::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(associadoDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociadoDTO> updateAssociado(@PathVariable String id, @RequestBody AssociadoDTO associadoDTO) {
        var associadoEntity = AssociadoConverter.toEntity(associadoDTO);
        associadoEntity = associadoService.updateAssociado(id, associadoEntity);
        associadoDTO = AssociadoConverter.toDTO(associadoEntity);
        return ResponseEntity.ok(associadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociado(@PathVariable String id) {
        associadoService.deleteAssociado(id);
        return ResponseEntity.noContent().build();
    }
}
