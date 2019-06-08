package location;

import java.io.Serializable;

import client.Client;
import vehicule.Vehicule;

/**
 * Represente une location, d'un vehicule par un client.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class Location implements Serializable
{
	/***/
	private static final long serialVersionUID = 1L;
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((vehicule == null) ? 0 : vehicule.hashCode());
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
		Location other = (Location) obj;
		if (client == null)
		{
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (vehicule == null)
		{
			if (other.vehicule != null)
				return false;
		} else if (!vehicule.equals(other.vehicule))
			return false;
		return true;
	}

	/** Client concerne. */
	private Client client;
	/** Vehicule concerne. */
	private Vehicule vehicule;
	/** Date de debut. */
	private String debut;
	/** Date de fin. */
	private String fin;
	/** Indique si la reduction s'applique a cette location. */
	private boolean reduction;
	/** Indique si le vehicule a ete rendu. */
	private boolean rendu;

	/**
	 * Constructeur.
	 * @param client Client concerne.
	 * @param vehicule Vehicule concerne.
	 * @param debut Date de debut.
	 * @param fin Date de fin.
	 * @param reduction true si la reduction est applicable, false sinon.
	 */
	public Location(Client client, Vehicule vehicule, String debut, String fin, boolean reduction)
	{
		super();
		this.client = client;
		this.vehicule = vehicule;
		this.debut = debut;
		this.fin = fin;
		this.reduction = reduction;
		this.rendu = false;
	}

	/**
	 * Renvoie client.
	 * @return Le client locataire.
	 */
	public Client getClient()
	{
		return client;
	}

	/**
	 * Remplace client.
	 * @param Le client locataire.
	 */
	public void setClient(Client client)
	{
		this.client = client;
	}

	/**
	 * Renvoie vehicule.
	 * @return Le vehicule loue.
	 */
	public Vehicule getVehicule()
	{
		return vehicule;
	}

	/**
	 * Remplace vehicule.
	 * @param Le vehicule loue.
	 */
	public void setVehicule(Vehicule vehicule)
	{
		this.vehicule = vehicule;
	}

	/**
	 * Renvoie debut.
	 * @return Date de debut.
	 */
	public String getDebut()
	{
		return debut;
	}

	/**
	 * Remplace debut.
	 * @param debut Date de debut.
	 */
	public void setDebut(String debut)
	{
		this.debut = debut;
	}

	/**
	 * Renvoie debfin.ut
	 * @return Date de fin.
	 */
	public String getFin()
	{
		return fin;
	}

	/**
	 * Remplace fin.
	 * @param debut Date de fin.
	 */
	public void setFin(String fin)
	{
		this.fin = fin;
	}

	/**
	 * Renvoie reduction.
	 * @return boolean indiquant si la reduction est applicable ou non.
	 */
	public boolean isReduction()
	{
		return reduction;
	}

	/**
	 * Remplace reduction.
	 * @param reduction boolean indiquant si la reduction est applicable ou non.
	 */
	public void setReduction(boolean reduction)
	{
		this.reduction = reduction;
	}

	/**
	 * Renvoie rendu.
	 * @return boolean indiquant si le vehicule a ete rendu ou non.
	 */
	public boolean isRendu()
	{
		return rendu;
	}

	/**
	 * Remplace rendu.
	 * @param rendu boolean indiquant si le vehicule a ete rendu ou non.
	 */
	public void setRendu(boolean rendu)
	{
		this.rendu = rendu;
	}

	@Override
	public String toString()
	{
		return client.toString() + "   " + vehicule.toString() + "   " + debut + " " + fin + " " + reduction + " " + reduction;
	}
}
