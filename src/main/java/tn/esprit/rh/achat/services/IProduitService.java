package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit p);

	Optional<Produit> retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

}
