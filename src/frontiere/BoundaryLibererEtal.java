package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notro marche aujourd'hui !");	
		}

		else {
			String [] donneesEtal= controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donneesEtal[0];
			if (etalOccupe=="true") {
				System.out.println("Vous avez vendu"+ donneesEtal[4]+"sur"+
			donneesEtal[3]+""+ donneesEtal[2]+".");
				System.out.println("En revoir"+nomVendeur+", passez une bonne journée");
			}
		}
	}

}
