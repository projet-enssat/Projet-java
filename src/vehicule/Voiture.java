package vehicule;

/**
 * Represente une voiture, distinguee par son immatriculation.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class Voiture extends VehiculeTerrestre
{
	/***/
	private static final long serialVersionUID = 1L;
	/** Nombre de places disponibles. */
	private int nbPlace;

	/**
	 * Constructeur.
	 * @deprecated Utiliser de preference Voiture(String, String, Float, String, String, int, Float, int, int).
	 */
	public Voiture()
	{
		this("inconnue", "inconnue", new Float(0), "inconnue", "inconnue", 0, new Float(0), 0, 0);
	}

	/**
	 * 
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixjour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param km Compteur kilometrique du vehicule.
	 * @param puissance Puissance du vehicule.
	 * @param nbPlace Nombre de places disponibles.
	 */
	public Voiture(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse,
			Float km, int puissance, int nbPlace)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse, km, puissance);
		this.nbPlace = nbPlace;
	}

	/**
	 * Renvoie nbPlace.
	 * @return Nombre de places disponibles.
	 */
	public int getNbPlace()
	{
		return nbPlace;
	}

	/**
	 * Remplace nbPlace.
	 * @param nbPlace Nombre de places disponibles
	 */
	public void setNbPlace(int nbPlace)
	{
		this.nbPlace = nbPlace;
	}

	
	@Override
	public String toString()
	{
		return getMarque() + "#" + getModele() + "#" + getEtat() + "#" + getImmatriculation() + "#" + getPrixJour().toString() + "#" +
				new Integer(getVitesse()).toString() + "#" + getKm().toString() + "#" + new Integer(getPuissance()).toString() + "#" +
				new Integer(nbPlace).toString();
	}
}
