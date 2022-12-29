package com.fontaine.produits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fontaine.produits.entities.Categorie;
import com.fontaine.produits.entities.Produit;

@RepositoryRestResource(path="rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	//Méthodes standard
	List<Produit> findByNomProduit(String nomProduit);
	List<Produit> findByPrixProduit(Double prixProduit);
	
	
	
	//En utilisant des règles de nommage, c'est interprêté par Spring
	List<Produit> findByNomProduitContains(String nomProduit);
	
	// En réalisant du JPQL mais en passant par des ?1, ?2 dans la requête
//	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit >?2")
	//List<Produit> findByNomPrix(String nom, Double prix);
	
	// En réalisant du JPQL mais en passant par des @Param dans la signature de la méthode, et :variable dans la requête (méthode à privilégier)
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit >:prix")
	List<Produit> findByNomPrix(@Param("nom")String nom, @Param("prix") Double prix);
	
	// En réalisant du JPQL mais en passant une entité
	@Query("select p from Produit p where p.categorie=?1")
	List<Produit> findByCategorie (Categorie categorie);
	
	
	//En utilisant des règles de nommage, c'est interprêté par Spring
	//ICI : Par une variable d'une autre entité
	List<Produit> findByCategorieIdCategorie (Long id);
	
	
	//En utilisant des règles de nommage, c'est interprêté par Spring
	//ICI : en ajoutant des critères de filtrage
	List<Produit> findByOrderByNomProduitAsc();
	
	
	// Filtrage en réalisant du JPQL
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix();
}
