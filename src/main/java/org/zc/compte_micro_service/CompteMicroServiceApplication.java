package org.zc.compte_micro_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zc.compte_micro_service.entities.Compte;
import org.zc.compte_micro_service.enums.CompteType;
import org.zc.compte_micro_service.repositories.CompteRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class CompteMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteMicroServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start( CompteRepository compteRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				Compte compte = Compte.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? CompteType.CURRENT_COMPTE:CompteType.SAVINGS_COMPTE)
						.balance(10000+Math.random()*90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				compteRepository.save(compte);
			}
		};
	}

}
