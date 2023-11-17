package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlTrouverEtalVendeur;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!acheteurConnu) {
			System.out.println("je suis desoles "+nomAcheteur+"mais il faut etre habitant de notre village pour commercer ici");
		} 
		
		else {
			
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			int j = 0;
			Gaulois [] vendeurs = controlAcheterProduit.infoEtals(produit);
			if (vendeurs[0]==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			}
			else {
			System.out.println("Chez quel commerçant voulez-vous acheter des "+produit);
			for (int i = 0; i < vendeurs.length; i++) {
				System.out.println(j+" - "+vendeurs[i].getNom());
				j++;
			}
			int numVendeur = scan.nextInt();
			System.out.println(nomAcheteur+" se deplace jusqu'à l'étal du vendeur "+ vendeurs[numVendeur].getNom());
			int nbProduit=Clavier.entrerEntier("Combienn de "+ produit+ "voulez-vous acheter ?");
			Gaulois vendeur = vendeurs[numVendeur];
			int produitDispo = controlAcheterProduit.nombreProduit(vendeur);
			if (nbProduit<=produitDispo) {
				controlAcheterProduit.acheterProduit(vendeur.getNom(), nbProduit);
				System.out.println(nomAcheteur+" achete "+nbProduit+""+produit+"à "+vendeurs[numVendeur].getNom());
			}
			else {
				if (produitDispo!=0) {
					controlAcheterProduit.acheterProduit(produit, nbProduit);
					System.out.println(nomAcheteur+" veut acheter "+ nbProduit +""+produit+", malheuresement "+vendeur.getNom()+"n'en a plus que "+produitDispo);
					
				}
				else {
					System.out.println(nomAcheteur+"Il n'ya plus");
				}
				}
			}
			
			}
		}
	
}
