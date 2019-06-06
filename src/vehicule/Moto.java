package vehicule;

public class Moto extends VehiculeTerrestre
{

	private static final long serialVersionUID = 1L;

	public Moto()
	{
		super();
	}

	public Moto(String modele, String etat, Float prixjour, String marque, String immatriculation, int vitesse,
			Float km, int puissance)
	{
		super(modele, etat, prixjour, marque, immatriculation, vitesse, km, puissance);
	}

	public String toString()
	{
		return getMarque() + "#" + getModele() + "#" + getEtat() + "#" + getImmatriculation() + "#" + getPrixJour().toString() + "#" +
				new Integer(getVitesse()).toString() + "#" + getKm().toString() + "#" + new Integer(getPuissance()).toString();
	}
}
