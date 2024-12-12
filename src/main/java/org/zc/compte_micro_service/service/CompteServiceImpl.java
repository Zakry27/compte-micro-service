package org.zc.compte_micro_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zc.compte_micro_service.dto.CompteRequestDTO;
import org.zc.compte_micro_service.dto.CompteResponseDTO;
import org.zc.compte_micro_service.entities.Compte;
import org.zc.compte_micro_service.enums.CompteType;
import org.zc.compte_micro_service.mappers.CompteMapper;
import org.zc.compte_micro_service.repositories.CompteRepository;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteMapper compteMapper;
    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteDTO) {
        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(compteDTO.getBalance())
                .type(compteDTO.getType())
                .currency(compteDTO.getCurrency())
                .build();
        Compte savedCompte = compteRepository.save(compte);
        CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(savedCompte);
        return compteResponseDTO;
    }
}
