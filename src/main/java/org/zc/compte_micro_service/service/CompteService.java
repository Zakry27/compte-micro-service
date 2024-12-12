package org.zc.compte_micro_service.service;

import org.zc.compte_micro_service.dto.CompteRequestDTO;
import org.zc.compte_micro_service.dto.CompteResponseDTO;
import org.zc.compte_micro_service.entities.Compte;

public interface CompteService {
    CompteResponseDTO addCompte(CompteRequestDTO compteResponseDTO);
}
