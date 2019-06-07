package location;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	public GestionLocation(Client client, Vehicule vehicule, String debut, String fin, boolean reduction)
	{
		location = new Location(client, vehicule, debut, fin, reduction);
	}

	public GestionLocation()
	{
	}
	
	/**
	 * Ajoute une nouvelle location à l'archive.
	 * 
	 * @param location Location à enregistrer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void ajouterLocation()
	{
		ListeLocations liste = lireLocations();
		if (liste.contains(location))
		{
			liste.add(location);
			enregistrerLocation(liste);
		}
	}

	/**
	 * Serialise la liste des locations pour mettre a jour l'archive "locations".
	 * 
	 * @param liste Liste a serialiser.
	 * @throws IOException, FileNotFoundException
	 */
	public void enregistrerLocation(ListeLocations liste)
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
	 * Deserialise la liste des locations a partir de l'archive "locations".
	 * 
	 * @return Liste des locations enregistrees.
	 * @throws IOException, ClassNotFoundException, EOFException
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
		} catch (EOFException eof) {} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return liste;
	}

}