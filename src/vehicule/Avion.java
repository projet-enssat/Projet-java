package vehicule;

public class Avion extends VehiculeAerien {

	public Avion() {
		super();
	}

	public Avion(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse,
			Float nbHeureVol, int nbMoteur) {
		super(modele, etat, prixjour, marque, immatriculation, vitesse, nbHeureVol, nbMoteur);
	}
	
}
