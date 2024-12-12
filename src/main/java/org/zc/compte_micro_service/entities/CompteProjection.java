package org.zc.compte_micro_service.entities;

import org.springframework.data.rest.core.config.Projection;
import org.zc.compte_micro_service.enums.CompteType;

@Projection(types = Compte.class, name = "p1")
public interface CompteProjection {
    public String getId();
    public CompteType getType();
    public Double getBalance();
}
