package com.fontaine.produits.service;

import java.util.List;

import com.fontaine.produits.entities.Categorie;
import com.fontaine.produits.entities.Produit;

public interface ProduitService {

	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduitById(Long id);
	void delteProduit(Produit p);
	Produit getProduit(Long id);
	List<Produit> getAllProduits();
	
	
	List<Produit> findByNomProduit(String nomProduit);
	List<Produit> findByPrixProduit(Double prixProduit);
	List<Produit> findByNomProduitContains(String nomProduit);
	List<Produit> findByNomPrix(String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCategorie (Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();

}
