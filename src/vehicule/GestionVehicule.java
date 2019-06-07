package vehicule;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Permet la gestion de l'archive contenant les vehicules.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class GestionVehicule
{
	/** Vehicule a gerer. */
	private static Vehicule vehicule;
	/** Type de vehicule (voiture, moto, avion...). */
	private String classe;

	/**
	 * Constructeur vide, utile pour certains appels de fonctions.
	 */
	public GestionVehicule()
	{
		setClasse("");
	}

	/**
	 * Constructeur n'initialisant que classe, utile pour certains appels de fonctions.
	 * @param classe Classe du vehicule a gerer.
	 */
	public GestionVehicule(String classe)
	{
		setClasse(classe);
	}

	/**
	 * Constructeur pour les voitures.
	 * @param classe Classe du vehicule.
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixJour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param km Compteur kilometrique du vehicule.
	 * @param puissance Puissance du vehicule.
	 * @param nbPlaces Nombre de places du vehicule.
	 */
	public GestionVehicule(String classe, String modele, String etat, Float prixJour, String marque,
			String immatriculation, int vitesse, Float km, int puissance, int nbPlaces)
	{
		setClasse(classe);
		setVehicule(modele, etat, prixJour, marque, immatriculation, vitesse, km, puissance, nbPlaces, new Float(0), 0);
	}

	/**
	 * Constructeur pour les avions.
	 * @param classe Classe du vehicule.
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixJour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param nbHeureVol Nombres d'heures de vol du vehicule.
	 * @param nbMoteurs Nombre de moteurs du vehicule.
	 */
	public GestionVehicule(String classe, String modele, String etat, Float prixJour, String marque,
			String immatriculation, int vitesse, Float nbHeuresVol, int nbMoteurs)
	{
		setClasse(classe);
		setVehicule(modele, etat, prixJour, marque, immatriculation, vitesse, new Float(0), 0, 0, nbHeuresVol,
				nbMoteurs);
	}

	/**
	 * Constructeur pour les motos.
	 * @param classe Classe du vehicule.
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixJour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param puissance Puissance du vehicule.
	 * @param km Compteur kilometrique du vehicule.
	 */
	public GestionVehicule(String classe, String modele, String etat, Float prixJour, String marque,
			String immatriculation, int vitesse, int puissance, Float km)
	{
		setClasse(classe);
		setVehicule(modele, etat, prixJour, marque, immatriculation, vitesse, km, puissance, 0, new Float(0), 0);
	}

	/**
	 * Initialise le vehicule en fonction de sa classe.
	 * @param modele Modele du vehicule.
	 * @param etat Etat du vehicule.
	 * @param prixJour Prix par jour de location du vehicule.
	 * @param marque Marque du vehicule.
	 * @param immatriculation Immatriculation du vehicule.
	 * @param vitesse Vitesse maximum du vehicule.
	 * @param km Compteur kilometrique du vehicule.
	 * @param puissance Puissance du vehicule.
	 * @param nbPlaces Nombre de places du vehicule.
	 * @param nbHeureVol Nombres d'heures de vol du vehicule.
	 * @param nbMoteurs Nombre de moteurs du vehicule.
	 */
	public void setVehicule(String modele, String etat, Float prixJour, String marque, String immatriculation,
			int vitesse, Float km, int puissance, int nbPlaces, Float nbHeuresVol, int nbMoteurs)
	{
		switch (classe)
		{
			case "Voiture":
				vehicule = new Voiture(modele, etat, prixJour, marque, immatriculation, vitesse, km, puissance,
						nbPlaces);
				break;
			case "Moto":
				vehicule = new Moto(modele, etat, prixJour, marque, immatriculation, vitesse, km, puissance);
				break;
			case "Avion":
				vehicule = new Avion(modele, etat, prixJour, marque, immatriculation, vitesse, nbHeuresVol, nbMoteurs);
				break;
			default:
				break;
		}
	}

	/**
	 * Ajoute un vehicule au fichier d'archive "vehicules".
	 * @throws IOException, FileNotFoundException, ClassNotFoundException, EOFException
	 */
	public void ajouterVehicule()
	{
		switch (classe)
		{
			case "Voiture":
				ajouterVoiture();
				break;
			case "Moto":
				ajouterMoto();
				break;
			case "Avion":
				ajouterAvion();
				break;
			default:
				break;
		}
	}
	
	/**
	 * Recherche le vehicule dont l'immatriculation est immat dans l'archive "vehicules". Cette methode remplace les donnees de la variable vehicule.
	 * @param immat Immatriculation a rechercher.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void rechercheVehicule(String immat)
	{
		ListeVehicules liste = lireVehicules();
		if (classe.equals("") || classe.equals("Voiture"))
		{
			for (int i=0 ; i<liste.getListeV().size() ; ++i)
			{
				if (liste.getListeV().get(i).getImmatriculation().equals(immat))
				{
					vehicule = liste.getListeV().get(i);
				}
			}
		}
		if (classe.equals("") || classe.equals("Moto"))
		{
			for (int i=0 ; i<liste.getListeM().size() ; ++i)
			{
				if (liste.getListeM().get(i).getImmatriculation().equals(immat))
				{
					vehicule = liste.getListeM().get(i);
				}
			}
		}
		if (classe.equals("") || classe.equals("Avion"))
		{
			for (int i=0 ; i<liste.getListeA().size() ; ++i)
			{
				if (liste.getListeA().get(i).getImmatriculation().equals(immat))
				{
					vehicule = liste.getListeA().get(i);
				}
			}
		}
	}
	
	/**
	 * Supprime vehicule dans l'archive "vehicules", s'il s'y trouve.
	 * 
	 * @throws IOException, FileNotFoundException, ClassNotFoundException, EOFException
	 */
	public void supprimerVehicule()
	{
		if(classe == "") {
			classe = (vehicule.getClass()).toString();
			classe = classe.substring(classe.indexOf(".")+1);
		}
		switch (classe)
		{
			case "Voiture":
				supprimerVoiture();
				break;
			case "Moto":
				supprimerMoto();
				break;
			case "Avion":
				supprimerAvion();
				break;
			default:
				break;
		}
	}

	/**
	 * Ajoute une nouvelle voiture a l'archive.
	 * 
	 * @param voiture Voiture a enregistrer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void ajouterVoiture()
	{
		ListeVehicules liste = lireVehicules();
		liste.ajouterVoiture((Voiture) vehicule);
		enregistrerVehicules(liste);
	}

	/**
	 * Ajoute une nouvelle moto a l'archive.
	 * 
	 * @param moto Moto a enregistrer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void ajouterMoto()
	{
		ListeVehicules liste = lireVehicules();
		liste.ajouterMoto((Moto) vehicule);
		enregistrerVehicules(liste);
	}

	/**
	 * Ajoute un nouvel avion a l'archive.
	 * 
	 * @param avion Avion a enregistrer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void ajouterAvion()
	{
		ListeVehicules liste = lireVehicules();
		liste.ajouterAvion((Avion) vehicule);
		enregistrerVehicules(liste);
	}

	/**
	 * Serialise la liste des vehicules pour mettre a jour l'archive "vehicules".
	 * 
	 * @param liste Liste a serialiser.
	 * @throws IOException, FileNotFoundException
	 */
	private static void enregistrerVehicules(ListeVehicules liste)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("vehicules");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(liste);
			fos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Retire une voiture de l'archive, si elle y est enregistree.
	 * 
	 * @param voiture Voiture a supprimer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void supprimerVoiture()
	{
		ListeVehicules liste = lireVehicules();
		liste.retirerVoiture((Voiture) vehicule);
		enregistrerVehicules(liste);
	}

	/**
	 * Retire une moto de l'archive, si elle y est enregistree.
	 * 
	 * @param moto Moto a supprimer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void supprimerMoto()
	{
		ListeVehicules liste = lireVehicules();
		liste.retirerMoto((Moto) vehicule);
		enregistrerVehicules(liste);
	}

	/**
	 * Retire un avion de l'archive, s'il y est enregistre.
	 * 
	 * @param avion Avion a supprimer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void supprimerAvion()
	{
		ListeVehicules liste = lireVehicules();
		liste.retirerAvion((Avion) vehicule);
		enregistrerVehicules(liste);
	}

	/**
	 * Recherche toutes les marques de vehicule dont les premiers caracteres sont ceux de dejaEcrit.
	 * Le champ est reductible en changeant classe pour "Voiture", "Moto" ou "Avion".
	 * @param dejaEcrit Chaine de caractere a rechercher.
	 * @return Un modele de JList qui contient toutes les marques correspondant au critere dejaEcrit.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public DefaultListModel<String> toutesLesMarques(String dejaEcrit)
	{
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeVehicules liste = lireVehicules();
		if (classe.equals("") || classe.equals("Voiture"))
		{
			for (int i = 0; i < liste.getListeV().size(); ++i)
			{
				Voiture temp = liste.getListeV().get(i);
				if (dejaEcrit.length() <= temp.getMarque().length())
				{
					if (dejaEcrit.equals(temp.getMarque().substring(0, dejaEcrit.length())) && !searchList.contains(temp.getMarque()))
					{
						searchList.addElement(temp.getMarque());
					}
				}
			}
		}
		if (classe.equals("") || classe.equals("Moto"))
		{
			for (int i = 0; i < liste.getListeM().size(); ++i)
			{
				Moto temp = liste.getListeM().get(i);
				if (dejaEcrit.length() <= temp.getMarque().length())
				{
					if (dejaEcrit.equals(temp.getMarque().substring(0, dejaEcrit.length())) && !searchList.contains(temp.getMarque()))
					{
						searchList.addElement(temp.getMarque());
					}
				}
			}
		}
		if (classe.equals("") || classe.equals("Avion"))
		{
			for (int i = 0; i < liste.getListeA().size(); ++i)
			{
				Avion temp = liste.getListeA().get(i);
				if (dejaEcrit.length() <= temp.getMarque().length())
				{
					if (dejaEcrit.equals(temp.getMarque().substring(0, dejaEcrit.length())) && !searchList.contains(temp.getMarque()))
					{
						searchList.addElement(temp.getMarque());
					}
				}
			}
		}
		return searchList;
	}

	/**
	 * Recherche tous les modeles de vehicule dont les premiers caracteres sont ceux de dejaEcrit.
	 * Le champ est reductible en changeant classe pour "Voiture", "Moto" ou "Avion" / en passant une chaine non vide en tant que marque.
	 * @param dejaEcrit Chaine de caractere a rechercher.
	 * @param marque Reduit la recherche a la marque specifiee (laisser vide pour une recherche exhaustive).
	 * @return Un modele de JList qui contient tous les modeles correspondant aux criteres dejaEcrit et marque.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public DefaultListModel<String> tousLesModeles(String marque, String dejaEcrit)
	{
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeVehicules liste = lireVehicules();
		if (classe.equals("") || classe.equals("Voiture"))
		{
			for (int i = 0; i < liste.getListeV().size(); ++i)
			{
				Voiture temp = liste.getListeV().get(i);
				if (marque == null || temp.getMarque().equals(marque))
				{
					if (dejaEcrit.length() <= temp.getModele().length())
					{
						if (dejaEcrit.equals(temp.getModele().substring(0, dejaEcrit.length())) && !searchList.contains(temp.getModele()))
						{
							searchList.addElement(temp.getModele());
						}
					}
				}
			}
		}
		if (classe.equals("") || classe.equals("Moto"))
		{
			for (int i = 0; i < liste.getListeM().size(); ++i)
			{
				Moto temp = liste.getListeM().get(i);
				if (marque == null || temp.getMarque().equals(marque))
				{
					if (dejaEcrit.length() <= temp.getModele().length())
					{
						if (dejaEcrit.equals(temp.getModele().substring(0, dejaEcrit.length())) && !searchList.contains(temp.getModele()))
						{
							searchList.addElement(temp.getModele());
						}
					}
				}
			}
		}
		if (classe.equals("") | classe.equals("Avion"))
		{
			for (int i = 0; i < liste.getListeA().size(); ++i)
			{
				Avion temp = liste.getListeA().get(i);
				if (marque == null || temp.getMarque().equals(marque))
				{
					if (dejaEcrit.length() <= temp.getModele().length())
					{
						if (dejaEcrit.equals(temp.getModele().substring(0, dejaEcrit.length())) && !searchList.contains(temp.getModele()))
						{
							searchList.addElement(temp.getModele());
						}
					}
				}
			}
		}
		return searchList;
	}

	/**
	 * Recherche toutes les immatriculations de vehicule dont les premiers caracteres sont ceux de dejaEcrit.
	 * Le champ est reductible en changeant classe pour "Voiture", "Moto" ou "Avion" / en passant une chaine non vide en tant que marque/modele.
	 * @param dejaEcrit Chaine de caractere a rechercher.
	 * @param marque Reduit la recherche a la marque specifiee (laisser vide pour une recherche exhaustive).
	 * @param modele Reduit la recherche au modele specifie (laisser vide pour une recherche exhaustive).
	 * @return Un modele de JList qui contient toutes les immatriculations correspondant aux criteres dejaEcrit, marque et modele.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public DefaultListModel<String> toutesLesImmats(String marque, String modele, String dejaEcrit)
	{
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeVehicules liste = lireVehicules();
		if (classe.equals("") || classe.equals("Voiture"))
		{
			for (int i = 0; i < liste.getListeV().size(); ++i)
			{
				Voiture temp = liste.getListeV().get(i);
				if (marque == null || temp.getMarque().equals(marque))
				{
					if (modele == null || temp.getModele().equals(modele))
					{
						if (dejaEcrit.length() <= temp.getImmatriculation().length())
						{
							if (dejaEcrit.equals(temp.getImmatriculation().substring(0, dejaEcrit.length())))
							{
								searchList.addElement(temp.getImmatriculation());
							}
						}
					}
				}
			}
		}
		if (classe.equals("") | classe.equals("Moto"))
		{
			for (int i = 0; i < liste.getListeM().size(); ++i)
			{
				Moto temp = liste.getListeM().get(i);
				if (marque == null || temp.getMarque().equals(marque))
				{
					if (modele == null || temp.getModele().equals(modele))
					{
						if (dejaEcrit.length() <= temp.getImmatriculation().length())
						{
							if (dejaEcrit.equals(temp.getImmatriculation().substring(0, dejaEcrit.length())))
							{
								searchList.addElement(temp.getImmatriculation());
							}
						}
					}
				}
			}
		}
		if (classe.equals("") | classe.equals("Avion"))
		{
			for (int i = 0; i < liste.getListeA().size(); ++i)
			{
				Avion temp = liste.getListeA().get(i);
				if (marque == null || temp.getMarque().equals(marque))
				{
					if (modele == null || temp.getModele().equals(modele))
					{
						if (dejaEcrit.length() <= temp.getImmatriculation().length())
						{
							if (dejaEcrit.equals(temp.getImmatriculation().substring(0, dejaEcrit.length())))
							{
								searchList.addElement(temp.getImmatriculation());
							}
						}
					}
				}
			}
		}
		return searchList;
	}

	/**
	 * Deserialise la liste des vehicules a partir de l'archive "vehicules".
	 * 
	 * @return Liste des vehicules enregistres.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException
	 */
	private static ListeVehicules lireVehicules()
	{
		ListeVehicules liste = new ListeVehicules();

		try
		{
			try
			{
				FileInputStream fis = new FileInputStream("vehicules");
				ObjectInputStream in = new ObjectInputStream(fis);
				liste = (ListeVehicules) in.readObject();
				fis.close();
			} catch (EOFException e) {}
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return liste;
	}

	/**
	 * Remplace classe.
	 * @param classe Classe du vehicule.
	 */
	public void setClasse(String classe)
	{
		this.classe = classe;
	}
	
	/**
	 * Renvoie vehicule.
	 * @return Le vehicule a gerer.
	 */
	public Vehicule getVehicule()
	{
		return vehicule;
	}

	/**
	 * Remplace vehicule.
	 * @param vehicule Vehicule a ecrire.
	 */
	public void setVehicule(Vehicule vehicule)
	{
		this.vehicule = vehicule;
	}
}
