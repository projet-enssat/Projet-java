package vehicule;

public class Voiture extends VehiculeTerrestre
{
	private static final long serialVersionUID = 1L;
	private int nbPlace;

	public Voiture()
	{
		this("inconnue", "inconnue", new Float(0), "inconnue", "inconnue", 0, new Float(0), 0, 0);
	}

	public Voiture(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse,
			Float km, int puissance, int nbPlace)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse, km, puissance);
		this.nbPlace = nbPlace;
	}

	public int getNbPlace()
	{
		return nbPlace;
	}

	public void setNbPlace(int nbPlace)
	{
		this.nbPlace = nbPlace;
	}

}
