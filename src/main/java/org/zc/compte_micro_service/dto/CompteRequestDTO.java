package org.zc.compte_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zc.compte_micro_service.enums.CompteType;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteRequestDTO {
    private Double balance;
    private String currency;
    private CompteType type;
}
