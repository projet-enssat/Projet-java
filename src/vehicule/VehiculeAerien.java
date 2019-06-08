package vehicule;

/**
 * Classe abstraite representant un vehicule volant, distingue par son immatriculation.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public abstract class VehiculeAerien extends Vehicule
{
	/***/
	private static final long serialVersionUID = 1L;
	/** Nombre d'heures de vol effectuees. */
	private Float nbHeureVol;
	/** Nombre de moteurs. */
	private int nbMoteur;

	/**
	 * Constructeur.
	 * @deprecated Utiliser de preference VehiculeAerien(String, String, Float, String, String, int, Float, int).
	 */
	public VehiculeAerien()
	{
		this("inconnue", "inconnue", new Float(0), "inconnue", "inconnue", 0, new Float(0), 0);
	}

	/**
	 * Constructeur.
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixjour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param nbHeureVol Nombre d'heures de vol du vehicule.
	 * @param nbMoteur Nombre de moteurs du vehicule.
	 */
	public VehiculeAerien(String modele, String etat, Float prixjour, String marque, String immatriculation,
			int vitesse, Float nbHeureVol, int nbMoteur)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse);
		this.nbHeureVol = nbHeureVol;
		this.nbMoteur = nbMoteur;
	}

	/**
	 * Renvoie nbHeureVol.
	 * @return Nombre d'heures de vol effectuees.
	 */
	public Float getNbHeureVol()
	{
		return nbHeureVol;
	}

	/**
	 * Remplace nbHeureVol
	 * @param nbHeureVol Nombre d'heures de vol effectuees.
	 */
	public void setNbHeureVol(Float nbHeureVol)
	{
		this.nbHeureVol = nbHeureVol;
	}

	/**
	 * Renvoie nbMoteur.
	 * @return Nombre de moteurs.
	 */
	public int getNbMoteur()
	{
		return nbMoteur;
	}

	/**
	 * Remplace nbMoteur.
	 * @param nbMoteur Nombre de moteurs.
	 */
	public void setNbMoteur(int nbMoteur)
	{
		this.nbMoteur = nbMoteur;
	}

}
