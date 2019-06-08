package vehicule;

/**
 * Classe abstraite representant un vehicule roulant, distingue par son immatriculation.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public abstract class VehiculeTerrestre extends Vehicule
{
	/***/
	private static final long serialVersionUID = 1L;
	/** Compteur kilometrique en kilometres. */
	private Float km;
	/** Puissance en chevaux. */
	private int puissance;

	/**
	 * Constructeur.
	 * @deprecated Utiliser de preference VehiculeTerrestre(String, String, Float, String, String, int, Float, int).
	 */
	public VehiculeTerrestre()
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
	 * @param km Compteur kilometrique du vehicule.
	 * @param puissance Puissance du vehicule.
	 */
	public VehiculeTerrestre(String modele, String etat, Float prixjour, String marque, String immatriculation,
			int vitesse, Float km, int puissance)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse);
		this.km = km;
		this.puissance = puissance;
	}

	/**
	 * Renvoie km.
	 * @return Compteur kilometrique en kilometres.
	 */
	public Float getKm()
	{
		return km;
	}

	/**
	 * Remplace km.
	 * @param km Compteur kilometrique en kilometres.
	 */
	public void setKm(Float km)
	{
		this.km = km;
	}

	/**
	 * Renvoie puissance.
	 * @return Puissance en chevaux.
	 */
	public int getPuissance()
	{
		return puissance;
	}

	/**
	 * Remplace puissance.
	 * @param puissance Puissance en chevaux.
	 */
	public void setPuissance(int puissance)
	{
		this.puissance = puissance;
	}

}
