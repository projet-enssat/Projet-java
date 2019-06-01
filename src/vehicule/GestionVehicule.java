package vehicule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** Permet la gestion de l'archive contenant les véhicules.
 * @author Dejan Paris
 */
public class GestionVehicule
{
	private Vehicule vehicule;
	
	public GestionVehicule() {}
	
	public GestionVehicule(String classe)
	{
		setTypeVehicule(classe);
	}
	
	public void setTypeVehicule(String classe)
	{
		switch (classe)
		{
			case "Voiture" : vehicule = new Voiture(); break;
			case "Moto" : vehicule = new Moto(); break;
			case "Avion" : vehicule = new Avion(); break;
			default : break;
		}
	}
	
	/** Ajoute une nouvelle voiture à l'archive.
	 * @param voiture	Voiture à enregistrer.
	 */
	public void ajouterVoiture()
	{
		ListeVehicules liste = lireVehicules();
		liste.ajouterVoiture((Voiture) vehicule);
		enregistrerVehicules(liste);
	}
	
	/** Ajoute une nouvelle moto à l'archive.
	 * @param moto	Moto à enregistrer.
	 */
	public void ajouterMoto()
	{
		ListeVehicules liste = lireVehicules();
		liste.ajouterMoto((Moto) vehicule);
		enregistrerVehicules(liste);
	}
	
	/** Ajoute un nouvel avion à l'archive.
	 * @param avion Avion à enregistrer.
	 */
	public void ajouterAvion()
	{
		ListeVehicules liste = lireVehicules();
		liste.ajouterAvion((Avion) vehicule);
		enregistrerVehicules(liste);
	}
	
	/** Sérialise la liste des véhicules pour mettre à jour l'archive "vehicules".
	 * @param liste	 Liste à sérialiser.
	 */
	public void enregistrerVehicules(ListeVehicules liste)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("vehicules");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(liste);
			fos.close();
		} catch (IOException e)
		{ e.printStackTrace(); }
	}

	/** Retire une voiture de l'archive, si elle y est enregistrée.
	 * @param voiture	Voiture à supprimer.
	 */
	public void supprimerVoiture()
	{
		ListeVehicules liste = lireVehicules();
		liste.retirerVoiture((Voiture) vehicule);
		enregistrerVehicules(liste);
	}

	/** Retire une moto de l'archive, si elle y est enregistrée.
	 * @param moto	Moto à supprimer.
	 */
	public void supprimerMoto()
	{
		ListeVehicules liste = lireVehicules();
		liste.retirerMoto((Moto) vehicule);
		enregistrerVehicules(liste);
	}

	/** Retire un avion de l'archive, s'il y est enregistré.
	 * @param avion	 Avion à supprimer.
	 */
	public void supprimerAvion()
	{
		ListeVehicules liste = lireVehicules();
		liste.retirerAvion((Avion) vehicule);
		enregistrerVehicules(liste);
	}

	/** Désérialise la liste des véhicules à partir de l'archive "vehicules".
	 * @return	Liste des véhicules enregistrés.
	 */
	private static ListeVehicules lireVehicules()
	{
		ListeVehicules liste = new ListeVehicules();
		
		try
		{
			FileInputStream fis = new FileInputStream("vehicules");
			ObjectInputStream in = new ObjectInputStream(fis);
			liste = (ListeVehicules) in.readObject();
			fis.close();
		} catch (IOException | ClassNotFoundException e)
		{ e.printStackTrace(); }
		return liste;
	}
}
