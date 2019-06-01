package client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/** Permet la gestion de l'archive contenant les clients.
 * @author Dejan Paris
 */
public class GestionClient
{
	private Client client;
	
	/** Constructeur.
	 */
	public GestionClient()
	{
		client = new Client();
	}
	
	public void setClient(String nom, String prenom, String adresse, Date date1, Date date2)
	{
		client = new Client(nom, prenom, adresse, date1, date2);
	}
	
	/** Ajoute un nouveau client à l'archive, s'il n'est pas encore enregistré.
	 * @param client	Client à enregistrer.
	 */
	public void ajouterClient()
	{
		ListeLocations liste = lireClients();
		if (liste.contains(client))
		{ 
			liste.add(client);
			enregistrerClients(liste);
		}
	}
	
	/** Sérialise la liste des clients pour mettre à jour l'archive "clients".
	 * @param liste	 Liste à sérialiser.
	 */
	public void enregistrerClients(ListeLocations liste)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("clients");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(liste);
			fos.close();
		} catch (IOException e)
		{ e.printStackTrace(); }
	}
	
	/** Retire un client de l'archive, s'il y est enregistré.
	 * @param client	Client à supprimer.
	 */
	public void supprimerClient()
	{
		ListeLocations liste = lireClients();
		liste.remove(client);
		enregistrerClients(liste);
	}
	
	/** Désérialise la liste des clients à partir de l'archive "clients".
	 * @return	Liste des clients enregistrés.
	 */
	private static ListeLocations lireClients()
	{
		ListeLocations liste = new ListeLocations();
		
		try
		{
			FileInputStream fis = new FileInputStream("clients");
			ObjectInputStream in = new ObjectInputStream(fis);
			liste = (ListeLocations) in.readObject();
			fis.close();
		} catch (IOException | ClassNotFoundException e)
		{ e.printStackTrace(); }
		return liste;
	}

}
