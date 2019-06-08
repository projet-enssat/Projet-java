package vehicule;

import java.io.Serializable;

/**
 * Classe abstraite representant un vehicule, distingue par son immatriculation.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public abstract class Vehicule implements Serializable
{
	/***/
	private static final long serialVersionUID = 1L;
	/** Modele du vehicule. */
	private String modele;
	/** Etat du vehicule. */
	private String etat;
	/** Prix par jour de location du vehicule. */
	private Float prixJour;
	/** Marque du vehicule. */
	private String marque;
	/** Immatriculation du vehicule. */
	private String immatriculation;
	/** Vitesse maximum du vehicule. */
	private int vitesse;

	/**
	 * Constructeur.
	 * @deprecated Utiliser de preference Vehicule(String, String, Float, String, String, int).
	 */
	public Vehicule()
	{
		this("inconnue", "inconnue", new Float(0), "inconnue", "inconnue", 0);
	}

	/**
	 * Constructeur.
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixJour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 */
	public Vehicule(String modele, String etat, Float prixJour, String marque, String immatriculation, int vitesse)
	{
		super();
		this.modele = modele;
		this.etat = etat;
		this.prixJour = prixJour;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.vitesse = vitesse;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((immatriculation == null) ? 0 : immatriculation.hashCode());
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime * result + ((modele == null) ? 0 : modele.hashCode());
		result = prime * result + ((prixJour == null) ? 0 : prixJour.hashCode());
		result = prime * result + vitesse;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicule other = (Vehicule) obj;
		if (immatriculation == null)
		{
			if (other.immatriculation != null)
				return false;
		} else if (!immatriculation.equals(other.immatriculation))
			return false;
		return true;
	}

	/**
	 * Renvoie prixJour.
	 * @return Prix par jour de location du vehicule.
	 */
	public Float getPrixJour()
	{
		return prixJour;
	}

	/**
	 * Remplace prixJour.
	 * @param prixJour Prix par jour de locaiton du vehicule.
	 */
	public void setPrixJour(Float prixJour)
	{
		this.prixJour = prixJour;
	}

	/**
	 * Renvoie vitesse.
	 * @return Vitesse maximum du vehicule.
	 */
	public int getVitesse()
	{
		return vitesse;
	}

	/**
	 * Remplace vitesse.
	 * @param vitesse Vitesse maximum du vehicule.
	 */
	public void setVitesse(int vitesse)
	{
		this.vitesse = vitesse;
	}

	/**
	 * Renvoie modele.
	 * @return Modele du vehicule.
	 */
	public String getModele()
	{
		return modele;
	}

	/**
	 * Remplace modele.
	 * @param modele Modele du vehicule.
	 */
	public void setModele(String modele)
	{
		this.modele = modele;
	}

	/**
	 * Renvoie etat.
	 * @return Etat du vehicule.
	 */
	public String getEtat()
	{
		return etat;
	}

	/**
	 * Remplace etat.
	 * @param etat Etat du vehicule.
	 */
	public void setEtat(String etat)
	{
		this.etat = etat;
	}

	/**
	 * Renvoie marque.
	 * @return Marque du vehicule.
	 */
	public String getMarque()
	{
		return marque;
	}

	/**
	 * Remplace marque.
	 * @param marque Marque du vehicule.
	 */
	public void setMarque(String marque)
	{
		this.marque = marque;
	}

	/**
	 * Renvoie immatriculation.
	 * @return Immatriculation du vehicule.
	 */
	public String getImmatriculation()
	{
		return immatriculation;
	}

	/**
	 * Remplace immatriculation.
	 * @param immatriculation Immatriculation du vehicule.
	 */
	public void setImmatriculation(String immatriculation)
	{
		this.immatriculation = immatriculation;
	}

}
