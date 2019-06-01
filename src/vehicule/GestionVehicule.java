package vehicule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JComboBox;

/** Permet la gestion de l'archive contenant les véhicules.
 * @author Dejan Paris
 */
public class GestionVehicule
{
	private static Vehicule vehicule;
	private String classe;
	
	public GestionVehicule()
	{
		setClasse("");
	}
	
	public GestionVehicule(String classe, String modele, String etat, Float prixJour, String marque,
						   String immatriculation, int vitesse, Float km, int puissance,
						   int nbPlaces, Float nbHeuresVol, int nbMoteurs)
	{
		setClasse(classe);
		setVehicule(modele, etat, prixJour, marque, immatriculation, vitesse, km,
					puissance, nbPlaces, nbHeuresVol, nbMoteurs);
	}
	
	public void setVehicule(String modele, String etat, Float prixJour, String marque,
							String immatriculation, int vitesse, Float km, int puissance,
							int nbPlaces, Float nbHeuresVol, int nbMoteurs)
	{
		switch (classe)
		{
			case "Voiture" : vehicule = new Voiture(modele, etat, prixJour, marque,
												immatriculation, vitesse, km, puissance, nbPlaces);
							break;
			case "Moto" : vehicule = new Moto(modele, etat, prixJour, marque,
											  immatriculation, vitesse, km, puissance);
							break;
			case "Avion" : vehicule = new Avion(modele, etat, prixJour, marque,
												immatriculation, vitesse, nbHeuresVol, nbMoteurs);
							break;
			default : break;
		}
	}
	
	public void ajouterVehicule()
	{
		switch (classe)
		{
			case "Voiture" : ajouterVoiture(); break;
			case "Moto" : ajouterMoto(); break;
			case "Avion" : ajouterAvion(); break;
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
	
	public JComboBox<String> toutesLesImmats(String marque, String modele)
	{
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(" ");
		ListeVehicules liste = lireVehicules();
		if (classe.equals("") | classe.equals("Voiture"))
		{
			for (int i=0 ; i<liste.getListeV().size() ; ++i)
			{
				Voiture temp = liste.getListeV().get(i);
				if (marque.equals("") | temp.getMarque().equals(marque))
				{
					if (modele.equals("") | temp.getModele().equals(modele))
					{
						comboBox.addItem(temp.getImmatriculation());
					}
				}
			}
		}
		if (classe.equals("") | classe.equals("Moto"))
		{
			for (int i=0 ; i<liste.getListeM().size() ; ++i)
			{
				Moto temp = liste.getListeM().get(i);
				if (marque.equals("") | temp.getMarque().equals(marque))
				{
					if (modele.equals("") | temp.getModele().equals(modele))
					{
						comboBox.addItem(temp.getImmatriculation());
					}
				}
			}
		}
		if (classe.equals("") | classe.equals("Avion"))
		{
			for (int i=0 ; i<liste.getListeA().size() ; ++i)
			{
				Avion temp = liste.getListeA().get(i);
				if (marque.equals("") | temp.getMarque().equals(marque))
				{
					if (modele.equals("") | temp.getModele().equals(modele))
					{
						comboBox.addItem(temp.getImmatriculation());
					}
				}
			}
		}
		return comboBox;
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
	
	public void setClasse(String classe)
	{
		this.classe= classe;
	}
}
