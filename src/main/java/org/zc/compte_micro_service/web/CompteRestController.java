package org.zc.compte_micro_service.web;

import org.springframework.web.bind.annotation.*;
import org.zc.compte_micro_service.dto.CompteRequestDTO;
import org.zc.compte_micro_service.dto.CompteResponseDTO;
import org.zc.compte_micro_service.entities.Compte;
import org.zc.compte_micro_service.mappers.CompteMapper;
import org.zc.compte_micro_service.repositories.CompteRepository;
import org.zc.compte_micro_service.service.CompteService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteRepository compteRepository;
    private CompteService compteService;
    private CompteMapper compteMapper;

    public CompteRestController(CompteRepository compteRepository, CompteService compteService, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteService = compteService;
        this.compteMapper = compteMapper;
    }

    @GetMapping("/comptes")
    public List<Compte> compte() {
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id) {
        return compteRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Compte with id %s not found", id)));
    }

    @PostMapping("/comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO requestDTO) {
        return compteService.addCompte(requestDTO);
    }

    @PutMapping ("/comptes/{id}")
    public Compte update(@PathVariable String id, @RequestBody Compte compte) {
        Compte moncompte = compteRepository.findById(id).orElseThrow();
        if (compte.getBalance() != null) moncompte.setBalance(compte.getBalance());
        if (compte.getCreatedAt() != null) moncompte.setCreatedAt(new Date());
        if (compte.getType() != null) moncompte.setType(compte.getType());
        if (compte.getCurrency() != null) moncompte.setCurrency(compte.getCurrency());
        return compteRepository.save(moncompte);
    }

    @DeleteMapping ("/comptes/{id}")
    public void deleteCompte(@PathVariable String id) {
        compteRepository.deleteById(id);
    }
}
