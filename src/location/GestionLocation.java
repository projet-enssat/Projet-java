package location;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import client.Client;
import vehicule.Vehicule;

/**
 * Permet la gestion de l'archive contenant les locations.
 * 
 * @author Dejan Paris
 */
public class GestionLocation
{
	private Location location;

	/**
	 * Constructeur.
	 */
	public GestionLocation(Client client, Vehicule vehicule, Calendar debut, Calendar fin, boolean reduction)
	{
		location = new Location(client, vehicule, debut, fin, reduction);
	}

	/**
	 * Ajoute une nouvelle location à l'archive.
	 * 
	 * @param location Location à enregistrer.
	 */
	public void ajouterLocation()
	{
		ListeLocations liste = lireLocations();
		if (liste.contains(location))
		{
			liste.add(location);
			enregistrerClients(liste);
		}
	}

	/**
	 * Sérialise la liste des locations pour mettre à jour l'archive "locations".
	 * 
	 * @param liste Liste à sérialiser.
	 */
	public void enregistrerClients(ListeLocations liste)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("locations");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(liste);
			fos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Désérialise la liste des locations à partir de l'archive "locations".
	 * 
	 * @return Liste des locations enregistrées.
	 */
	private static ListeLocations lireLocations()
	{
		ListeLocations liste = new ListeLocations();

		try
		{
			FileInputStream fis = new FileInputStream("locations");
			ObjectInputStream in = new ObjectInputStream(fis);
			liste = (ListeLocations) in.readObject();
			fis.close();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return liste;
	}

}