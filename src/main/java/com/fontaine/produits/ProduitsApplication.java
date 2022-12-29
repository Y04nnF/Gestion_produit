package com.fontaine.produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.fontaine.produits.entities.Produit;

@SpringBootApplication
//implements CommandLineRunner pour pouvoir envoyer l'ID dans les réponses

public class ProduitsApplication implements CommandLineRunner {

	@Autowired
	//Ajout de la variable pour envoi de l'ID
	private RepositoryRestConfiguration configuration;
	
	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		configuration.exposeIdsFor(Produit.class);
		
	}
}
