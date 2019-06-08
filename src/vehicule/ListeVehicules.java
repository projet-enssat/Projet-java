package vehicule;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Utilisee pour gerer des ArrayList (une par type de vehicule).
 * Intermediaire pour serialiser et enregistrer des vehicules.
 * 
 * @author Dejan Paris
 */
public class ListeVehicules implements Serializable
{
	/***/
	private static final long serialVersionUID = 1L;

	/** Liste des voitures disponibles. */
	private ArrayList<Voiture> listeVoitures = new ArrayList<Voiture>();

	/** Liste des motos disponibles. */
	private ArrayList<Moto> listeMotos = new ArrayList<Moto>();

	/** Liste des avions disponibles. */
	private ArrayList<Avion> listeAvions = new ArrayList<Avion>();

	/**
	 * Renvoie listeVoitures.
	 * @return Liste des voitures enregistrees.
	 */
	public ArrayList<Voiture> getListeV()
	{
		return listeVoitures;
	}

	/**
	 * Renvoie listeMotos.
	 * @return Liste des motos enregistrees.
	 */
	public ArrayList<Moto> getListeM()
	{
		return listeMotos;
	}

	/**
	 * Renvoie listeAvions.
	 * @return Liste des avions enregistrees.
	 */
	public ArrayList<Avion> getListeA()
	{
		return listeAvions;
	}

	/**
	 * Ajoute une voiture a la liste correspondante.
	 * 
	 * @param voiture Voiture a ajouter.
	 */
	public void ajouterVoiture(Voiture voiture)
	{
		listeVoitures.add(voiture);
	}

	/**
	 * Ajoute une moto a la liste correspondante.
	 * 
	 * @param moto Moto a ajouter.
	 */
	public void ajouterMoto(Moto moto)
	{
		listeMotos.add(moto);
	}

	/**
	 * Ajoute un avion a la liste correspondante.
	 * 
	 * @param avion Avion a ajouter.
	 */
	public void ajouterAvion(Avion avion)
	{
		listeAvions.add(avion);
	}

	/**
	 * Retire une voiture de la liste correspondante.
	 * 
	 * @param voiture Voiture a supprimer.
	 */
	public void retirerVoiture(Voiture voiture)
	{
		listeVoitures.remove(voiture);
	}

	/**
	 * Retire une moto de la liste correspondante.
	 * 
	 * @param moto Moto a supprimer.
	 */
	public void retirerMoto(Moto moto)
	{
		listeMotos.remove(moto);
	}

	/**
	 * Retire un avion de la liste correspondante.
	 * 
	 * @param avion Avion a supprimer.
	 */
	public void retirerAvion(Avion avion)
	{
		listeAvions.remove(avion);
	}

	@Override
	public String toString()
	{
		return listeVoitures.toString() + "##" + listeMotos.toString() + "##" + listeAvions.toString();
	}
}
