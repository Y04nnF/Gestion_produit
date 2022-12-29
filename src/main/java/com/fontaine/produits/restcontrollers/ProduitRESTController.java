package com.fontaine.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fontaine.produits.service.ProduitService;
import com.fontaine.produits.entities.Produit;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
	
	
	// via l'interface et non via l'implémentation pour permettre les eventuel nouvelle d'implementation 
	@Autowired
	ProduitService produitService;
	
	
	//En ne passant pas de paramètre
	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits(){
		return produitService.getAllProduits();
	}
	
	//En passant un paramètre dans l'url, nécessite @PathVariable
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}
	
	//En passant un produit dans le body dans la requête, nécessite @RequestBody
	@RequestMapping(method = RequestMethod.POST)
	public Produit createProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}", method = RequestMethod.GET)
	public List<Produit> getProduitsByCatID(@PathVariable("idCat") Long idCat){
		return produitService.findByCategorieIdCategorie(idCat);
	}
}
