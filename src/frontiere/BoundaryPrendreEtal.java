package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnnu) {
			System.out.println("Je suis d�sol�e"+nomVendeur+"mais il faut etre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour"+nomVendeur+", je vqis regarder si je peux vous trouver un �tal.");
			boolean etalDispo = controlPrendreEtal.resteEtals();
			if (!etalDispo) {
				System.out.println("D�sol�e"+nomVendeur+"je nai plus d'�tal qui ne soit pas d�j� occup�");
			}
			else {
				installerVendeur(nomVendeur);
			}
			}
		
		
	}

	private void installerVendeur(String nomVendeur) {
			System.out.println("C'est parfait,il me reste un �tal pour vous!");
			System.out.println("Il me faudra quelques renseignements :");
			System.out.println("Quel produit souhaitez-vous en vendre ?");
			String produit = scan.next();
			int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
			int numeroEtal =controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
			if (numeroEtal!=-1) {
				System.out.println("Le venduer"+nomVendeur+"s'est install� � l'�tal n�"+numeroEtal);
			}

	}
}

