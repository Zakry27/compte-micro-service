package org.zc.compte_micro_service.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.zc.compte_micro_service.dto.CompteResponseDTO;
import org.zc.compte_micro_service.entities.Compte;

@Component
public class CompteMapper {
    public CompteResponseDTO fromCompte(Compte compte) {
        CompteResponseDTO compteResponseDTO = new CompteResponseDTO();
        BeanUtils.copyProperties(compte, compteResponseDTO);
        return compteResponseDTO;
    }
}
