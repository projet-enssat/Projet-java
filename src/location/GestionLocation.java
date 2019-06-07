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
	/** Location a gerer. */
	private Location location;

	/**
	 * Constructeur.
	 */
	public GestionLocation(Client client, Vehicule vehicule, String debut, String fin, boolean reduction)
	{
		location = new Location(client, vehicule, debut, fin, reduction);
	}
	
	/**
	 * Ajoute une nouvelle location a l'archive.
	 * 
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void ajouterLocation()
	{
		ListeLocations liste = lireLocations("locations");
		if (liste.contains(location))
		{
			liste.add(location);
			enregistrerLocation(liste, "locations");
		}
	}
	
	/**
	 * Supprime la location du fichier "locations" et l'archive dans le fichier "locations_finies".
	 * 
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void archiverLocation()
	{
		ListeLocations liste1 = lireLocations("locations");
		ListeLocations liste2 = lireLocations("locations_finies");
		liste1.remove(location);
		location.setRendu(true);
		enregistrerLocation(liste1, "locations");
		liste2.add(location);
		enregistrerLocation(liste2, "locations_finies");
	}
	
	public Location rechercheLocation()
	{
		ListeLocations liste = lireLocations("locations");
		Location result = null;
		for (int i=0 ; i<liste.size() ; ++i)
		{
			if (liste.get(i).getClient().equals(location.getClient()) && liste.get(i).getVehicule().getImmatriculation().toLowerCase().equals(location.getVehicule().getImmatriculation().toLowerCase()))
			{
				result = liste.get(i);
			}
		}
		return result;
	}

	/**
	 * Serialise la liste des locations (finies) pour mettre a jour fichier.
	 * 
	 * @param liste Liste a serialiser.
	 * @param fichier Fichier a mettre a jour (doit etre "locations" ou "locations_finies").
	 * @throws IOException, FileNotFoundException
	 */
	private static void enregistrerLocation(ListeLocations liste, String fichier)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(liste);
			fos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Deserialise la liste des locations (finies) a partir du parametre fichier.
	 * 
	 * @param fichier Fichier a lire (doit etre "locations" ou "locations_finies").
	 * @return Liste des locations enregistrees.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	private static ListeLocations lireLocations(String fichier)
	{
		ListeLocations liste = new ListeLocations();

		try
		{
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream in = new ObjectInputStream(fis);
			liste = (ListeLocations) in.readObject();
			fis.close();
		} catch (EOFException eof) {} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return liste;
	}
	
	/**
	 * Renvoie location.
	 * @return Location.
	 */
	public Location getLocation()
	{
		return location;
	}

}