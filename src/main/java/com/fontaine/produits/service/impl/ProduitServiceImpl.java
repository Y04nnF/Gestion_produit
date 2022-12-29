package com.fontaine.produits.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fontaine.produits.entities.Categorie;
import com.fontaine.produits.entities.Produit;
import com.fontaine.produits.repository.ProduitRepository;
import com.fontaine.produits.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService{


	@Autowired
	ProduitRepository produitRepository;

	@Override
	public Produit saveProduit(Produit p) {

		return produitRepository.save(p);
	}


	@Override
	public Produit updateProduit(Produit p) {

		return produitRepository.save(p);
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);

	}

	@Override
	public void delteProduit(Produit p) {
		produitRepository.delete(p);
	}

	@Override
	public Produit getProduit(Long id) {

		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> getAllProduits() {
		return produitRepository.findAll();
	}


	@Override
	public List<Produit> findByNomProduit(String nomProduit) {

		return produitRepository.findByNomProduit(nomProduit);
	}


	@Override
	public List<Produit> findByPrixProduit(Double prixProduit) {

		return produitRepository.findByPrixProduit(prixProduit);
	}


	@Override
	public List<Produit> findByNomProduitContains(String nomProduit) {
		return produitRepository.findByNomProduitContains(nomProduit);
	}


	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}


	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}


	@Override
	public List<Produit> findByCategorieIdCategorie(Long id) {
		return produitRepository.findByCategorieIdCategorie(id);
	}


	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}


	@Override
	public List<Produit> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix();
	}

}
