package vehicule;

public abstract class VehiculeAerien extends Vehicule {
	private static final long serialVersionUID = 1L;
	private Float nbHeureVol;
	private int nbMoteur;
	
	public VehiculeAerien() {
		this("inconnue","inconnue",new Float(0),"inconnue","inconnue",0,new Float(0),0);
	}
	
	public VehiculeAerien(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse, Float nbHeureVol, int nbMoteur) {
		super(modele, etat, prixjour, marque, immatriculation, vitesse);
		this.nbHeureVol = nbHeureVol;
		this.nbMoteur = nbMoteur;
	}

	public Float getNbHeureVol() {
		return nbHeureVol;
	}

	public void setNbHeureVol(Float nbHeureVol) {
		this.nbHeureVol = nbHeureVol;
	}

	public int getNbMoteur() {
		return nbMoteur;
	}

	public void setNbMoteur(int nbMoteur) {
		this.nbMoteur = nbMoteur;
	}
	
}
