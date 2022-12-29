package com.fontaine.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fontaine.produits.entities.Categorie;
import com.fontaine.produits.entities.Produit;
import com.fontaine.produits.repository.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit() {
		Produit prod= new Produit(0, "PC Dell", 2200.500, new Date(), null);
		produitRepository.save(prod);
	}
	@Test
	public void testFindProduit() {

		Produit p=produitRepository.findById(1L).get();
		System.out.println("Test Find Produit");
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {

		Produit p=produitRepository.findById(1L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {

		produitRepository.deleteById(1L);

	}

	@Test
	public void testFindAllProduit() {

		List<Produit> p=produitRepository.findAll();

		System.out.println(p);
	}
	
	@Test
	public void testFindByNomProduit() {

		List<Produit> p=produitRepository.findByNomProduit("PC Dell");

		System.out.println(p);
	}

	@Test
	public void testFindByPrixProduit() {

		List<Produit> p=produitRepository.findByPrixProduit(2200.5);

		System.out.println(p);
	}
	
	@Test
	public void testFindByNomProduitContains() {

		List<Produit> p=produitRepository.findByNomProduitContains("PC");

		System.out.println(p);
	}
	
	@Test
	public void testFindByNomProduitPrix() {

		List<Produit> p=produitRepository.findByNomPrix("PC Dell",2100.00);

		System.out.println(p);
	}
	
	
	@Test
	public void testFindByCategorie() {
		
		Categorie cat = new Categorie();
		cat.setIdCategorie(1L);

		List<Produit> p=produitRepository.findByCategorie(cat);

		System.out.println(p);
	}
	
	@Test
	public void testFindByCategorieId() {


		List<Produit> p=produitRepository.findByCategorieIdCategorie(1L);

		System.out.println(p);
	}
	
	@Test
	public void testFindByOrderByNomProduit() {


		List<Produit> p=produitRepository.findByOrderByNomProduitAsc();

		System.out.println(p);
	}
	
	@Test
	public void testTrierProduit() {

		List<Produit> p=produitRepository.trierProduitsNomsPrix();

		System.out.println(p);
	}
}  
