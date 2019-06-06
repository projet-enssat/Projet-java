package client;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

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

	public void select(String client) {
		int espace1 = client.indexOf(" ");
		this.client.setNom(client.substring(0, espace1));
		int espace2 = client.indexOf(" ", espace1+1);
		this.client.setPrenom(client.substring(espace1+1, espace2));
		this.client.setAdresse(client.substring(espace2+1));
		rechercherClient();
	}
	
	public void rechercherClient(){
		ListeClients liste = lireClients();
		int i = liste.indexOf(client);
		System.out.println(client.toString());
		client= liste.get(i);
		System.out.println(client.toString()+"test");
	}
	
	public void validerSuppression(String nomClient) {
		ListeClients liste = lireClients();
		String clientCourant="";
		int i=0;
		Client tmp =null;
		while(i<liste.size() && nomClient!=clientCourant) {
			tmp = liste.get(i);
			clientCourant = tmp.getNom()+" "+tmp.getPrenom()+" "+tmp.getAdresse();
			i++;
		}
		if (i!=liste.size()) {
			client = tmp;
		}
	}
	
	public DefaultListModel<String> rechercherNom(String test){
		
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(tmp.getNom().length()>(test.length()-1)) {
					if(test.toLowerCase().equals(tmp.getNom().substring(0,test.length()).toLowerCase())) {
						searchList.addElement(tmp.getNom()+" "+tmp.getPrenom()+" "+tmp.getAdresse());
					}
				}
			}
		}
		return searchList;
	}
	
	public DefaultListModel<String> rechercherPrenom(String test){
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(tmp.getPrenom().length()>(test.length()-1)) {
					if(test.equals(tmp.getPrenom().substring(0,test.length()))) {
						searchList.addElement(tmp.getNom()+" "+tmp.getPrenom()+" "+tmp.getAdresse());
					}
				}
			}
		}
		return searchList;
	}
	
	public DefaultListModel<String> rechercherAdresse(String test){
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(tmp.getAdresse().length()>(test.length()-1)) {
					if(test.equals(tmp.getAdresse().substring(0,test.length()))) {
						searchList.addElement(tmp.getNom()+" "+tmp.getPrenom()+" "+tmp.getAdresse());
					}
				}
			}
		}
		return searchList;
	}
	
	public DefaultListModel<String> tous(){
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		for(int i=0;i<liste.size();i++) {
			Client tmp = liste.get(i);
			searchList.addElement(tmp.getNom()+" "+tmp.getPrenom()+" "+tmp.getAdresse());
		}
		return searchList;
	}
	
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
