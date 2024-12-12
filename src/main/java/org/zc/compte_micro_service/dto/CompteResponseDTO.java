package org.zc.compte_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zc.compte_micro_service.enums.CompteType;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private CompteType type;
}
