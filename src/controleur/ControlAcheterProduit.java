package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean verifierIdentite(String nomAcheteur) {
		boolean nomAcheteurConnu = controlVerifierIdentite.verifierIdentite(nomAcheteur);
		return nomAcheteurConnu;
	}
	
	public Gaulois[] infoEtals(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String vendeur, int nbProduit) {
		Etal etalvendeur = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		return etalvendeur.acheterProduit(nbProduit);
		
	}
}
