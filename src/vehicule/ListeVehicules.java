package vehicule;

import java.io.Serializable;
import java.util.ArrayList;

/** Utilisée pour gérer des ArrayList (une par type de véhicule).
 * Intermédiaire pour sérialiser et enregistrer des véhicules.
 * @author Dejan Paris
 */
public class ListeVehicules implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** Liste des voitures disponibles. */
	private ArrayList<Voiture> listeVoitures = new ArrayList<Voiture>();
	
	/** Liste des motos disponibles. */
	private ArrayList<Moto> listeMotos = new ArrayList<Moto>();
	
	/** Liste des avions disponibles. */
	private ArrayList<Avion> listeAvions = new ArrayList<Avion>();

	/** Ajoute une voiture à la liste correspondante.
	 * @param voiture Voiture à ajouter. */
	public void ajouterVoiture(Voiture voiture)
	{
		listeVoitures.add(voiture);
	}
	/** Ajoute une moto à la liste correspondante.
	 * @param moto Moto à ajouter. */
	public void ajouterMoto(Moto moto)
	{
		listeMotos.add(moto);
	}
	/** Ajoute un avion à la liste correspondante.
	 * @param avion Avion à ajouter. */
	public void ajouterAvion(Avion avion)
	{
		listeAvions.add(avion);
	}
	/** Retire une voiture de la liste correspondante.
	 * @param voiture Voiture à supprimer. */
	public void retirerVoiture(Voiture voiture)
	{
		listeVoitures.remove(voiture);
	}
	/** Retire une moto de la liste correspondante.
	 * @param moto Moto à supprimer. */
	public void retirerMoto(Moto moto)
	{
		listeMotos.remove(moto);
	}
	/** Retire un avion de la liste correspondante.
	 * @param avion Avion à supprimer. */
	public void retirerAvion(Avion avion)
	{
		listeAvions.remove(avion);
	}
}
