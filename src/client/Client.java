package client;

import java.io.Serializable;

/**
 * Represente un client, distingue par ses nom, prenom et adresse.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class Client implements Serializable
{
	/***/
	private static final long serialVersionUID = 1L;
	/** Nom de famille. */
	private String nom;
	/** Premier prenom. */
	private String prenom;
	/** Adresse postale. */
	private String adresse;
	/** Date de fin de la periode probatoire du permis */
	private String dateApprentissage;
	/** Date d'obtention du permis. */
	private String datePermis;

	/**
	 * Constructeur.
	 */
	public Client()
	{
		this("", "", "", "", "");
	}

	/**
	 * Constructeur.
	 * @param nom Nom du client.
	 * @param prenom Prenom du client.
	 * @param adresse Adresse du client.
	 * @param date1 Fin de periode probatoire.
	 * @param date2 Date d'obtention du permis.
	 */
	public Client(String nom, String prenom, String adresse, String date1, String date2)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateApprentissage = date1;
		this.datePermis = date2;
	}

	/**
	 * Renvoie nom.
	 * @return Nom du client.
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Remplace nom.
	 * @param nom Nom du client.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Renvoie prenom.
	 * @return Prenom du client.
	 */
	public String getPrenom()
	{
		return prenom;
	}
	
	/**
	 * Remplace prenom.
	 * @param prenom Prenom du client.
	 */
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Renvoie adresse.
	 * @return Adresse postale du client.
	 */
	public String getAdresse()
	{
		return adresse;
	}

	/**
	 * Remplace adresse.
	 * @param adresse Adresse postale du client.
	 */
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}

	/**
	 * Renvoie dateApprentissage.
	 * @return Fin de periode probatoire du permis.
	 */
	public String getDateApprentissage()
	{
		return dateApprentissage;
	}
	
	/**
	 * Remplace dateApprentissage.
	 * @param dateApprentissage Fin de periode probatoire du permis.
	 */
	public void setDateApprentissage(String dateApprentissage)
	{
		this.dateApprentissage = dateApprentissage;
	}

	/**
	 * Renvoie datePermis.
	 * @return Date d'obtention du permis.
	 */
	public String getDatePermis()
	{
		return datePermis;
	}
	
	/**
	 * Remplace nom.
	 * @param datePermis Date d'obtention du permis.
	 */
	public void setDatePermis(String datePermis)
	{
		this.datePermis = datePermis;
	}

	@Override
	public String toString()
	{
		return nom + "#" + prenom + "#" + adresse + "#" + dateApprentissage + "#" + datePermis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

}
