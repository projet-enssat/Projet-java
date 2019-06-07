package vehicule;

/**
 * Represente un avion, distingue par son immatriculation.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class Avion extends VehiculeAerien
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @deprecated Utiliser de preference Avion(String, String, Float, String, String, int, Float, int).
	 */
	public Avion()
	{
		super();
	}

	/**
	 * Constructeur
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixjour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param nbHeureVol Nombre d'heures de vol du vehicule.
	 * @param nbMoteur Nombre de moteurs du vehicule.
	 */
	public Avion(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse,
			Float nbHeureVol, int nbMoteur)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse, nbHeureVol, nbMoteur);
	}

	@Override
	public String toString()
	{
		return getMarque() + "#" + getModele() + "#" + getEtat() + "#" + getImmatriculation() + "#" + getPrixJour().toString() + "#" +
				new Integer(getVitesse()).toString() + "#" + getNbHeureVol().toString() + "#" + new Integer(getNbMoteur()).toString();
	}
}
