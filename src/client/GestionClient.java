package client;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

<<<<<<< HEAD
import javax.swing.JList;

/** Permet la gestion de l'archive contenant les clients.
=======
/**
 * Permet la gestion de l'archive contenant les clients.
 * 
>>>>>>> branch 'master' of https://github.com/projet-enssat/Projet-java
 * @author Dejan Paris
 */
public class GestionClient
{
	private Client client;

	/**
	 * Constructeur.
	 */
	public GestionClient()
	{
		client = new Client();
	}
<<<<<<< HEAD
	
	public JList<String> rechercherNom(String test){
		
		String[] searchList = new String [50];
		int index=0;
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(test.equals(tmp.getNom().substring(0,test.length()))) {
					searchList[index]=tmp.getNom();
					index++;
				}
			}
		}
		JList<String> listNom = new JList<String>(searchList);
		return listNom;
	}
	
	public JList<String> rechercherPrenom(String test){
		String[] searchList = new String [50];
		int index=0;
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(test.equals(tmp.getPrenom().substring(0,test.length()))) {
					searchList[index]=tmp.getPrenom();
					index++;
				}
			}
		}
		JList<String> listPrenom = new JList<String>(searchList);
		return listPrenom;
	}
	
	public JList<String> rechercherAdresse(String test){
		String[] searchList = new String [50];
		int index=0;
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(test.equals(tmp.getAdresse().substring(0,test.length()))) {
					searchList[index]=tmp.getAdresse();
					index++;
				}
			}
		}
		JList<String> listAdresse = new JList<String>(searchList);
		return listAdresse;
	}
	
=======

>>>>>>> branch 'master' of https://github.com/projet-enssat/Projet-java
	public GestionClient(String nom, String prenom, String adresse, String date1, String date2)
	{
		client = new Client(nom, prenom, adresse, date1, date2);
	}

	public void setClient(String nom, String prenom, String adresse, String date1, String date2)
	{
		client = new Client(nom, prenom, adresse, date1, date2);
	}

	/**
	 * Ajoute un nouveau client à l'archive, s'il n'est pas encore enregistré.
	 * 
	 * @param client Client à enregistrer.
	 */
	public void ajouterClient()
	{
		ListeClients liste = lireClients();
		if (!liste.contains(client))
		{
			liste.add(client);
			enregistrerClients(liste);
		}
	}

	/**
	 * Sérialise la liste des clients pour mettre à jour l'archive "clients".
	 * 
	 * @param liste Liste à sérialiser.
	 */
	public void enregistrerClients(ListeClients liste)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("clients");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(liste);
			fos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Retire un client de l'archive, s'il y est enregistré.
	 * 
	 * @param client Client à supprimer.
	 */
	public void supprimerClient()
	{
		ListeClients liste = lireClients();
		liste.remove(client);
		enregistrerClients(liste);
	}

	/**
	 * Désérialise la liste des clients à partir de l'archive "clients".
	 * 
	 * @return Liste des clients enregistrés.
	 */
	public ListeClients lireClients()
	{
		ListeClients liste = new ListeClients();

		try
		{
			try
			{
				FileInputStream fis = new FileInputStream("clients");
				ObjectInputStream in = new ObjectInputStream(fis);
				liste = (ListeClients) in.readObject();
				fis.close();
			} catch (EOFException e)
			{
			}
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return liste;
	}
}
