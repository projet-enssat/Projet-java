package vehicule;

/**
 * Represente une moto, distinguee par son immatriculation.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class Moto extends VehiculeTerrestre
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur.
	 * @deprecated Utiliser de preference Moto(String, String, Float, String, String, int, Float, int).
	 */
	public Moto()
	{
		super();
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
	public Moto(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse,
			Float km, int puissance)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse, km, puissance);
	}

	@Override
	public String toString()
	{
		return getMarque() + "#" + getModele() + "#" + getEtat() + "#" + getImmatriculation() + "#" + getPrixJour().toString() + "#" +
				new Integer(getVitesse()).toString() + "#" + getKm().toString() + "#" + new Integer(getPuissance()).toString();
	}
}
