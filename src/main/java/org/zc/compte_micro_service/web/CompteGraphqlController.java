package org.zc.compte_micro_service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.zc.compte_micro_service.entities.Compte;
import org.zc.compte_micro_service.repositories.CompteRepository;

import java.util.List;

@Controller
public class CompteGraphqlController {
    @Autowired
    private CompteRepository compteRepository;

    @QueryMapping
    public List<Compte> comptesList() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteByID(@Argument String id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte with id %s not found", id)));
    }
}
