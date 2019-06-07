package client;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

/**
 * Permet la gestion de l'archive contenant les clients.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class GestionClient
{
	/**
	 * Client a gerer.
	 */
	private Client client;

	/**
	 * Constructeur.
	 * @deprecated Utiliser de preference GestionClient(String, String, String, String, String).
	 */
	public GestionClient()
	{
		client = new Client();
	}

	/**
	 * Parse une chaine de caracteres representant un client, pour recuperer ses nom, prenom, adresse.
	 * @param client Client a parser.
	 */
	public void select(String client) {
		this.client.setDateApprentissage("");
		this.client.setDatePermis("");
		int espace1 = client.indexOf("#");
		this.client.setNom(client.substring(0, espace1));
		int espace2 = client.indexOf("#", espace1+1);
		this.client.setPrenom(client.substring(espace1+1, espace2));
		this.client.setAdresse(client.substring(espace2+1));
		System.out.println(this.client+"~");
		rechercherClient();
	}

	/**
	 * Recupere les dates de permis et de fin d'apprentissage du client dans l'archive "clients".
	 */
	public void rechercherClient(){
		ListeClients liste = lireClients();
		int i = liste.indexOf(client);
		client = liste.get(i);
	}

	/**
	 * Recherche tous les clients dont le nom commence par les caracteres de test.
	 * @param test Nom ou debut du nom a rechercher.
	 * @return Un modele de JList contenant tous les clients correspondant au critere test.
	 */
	public DefaultListModel<String> rechercherNom(String test){
		
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(tmp.getNom().length()>(test.length()-1)) {
					if(test.toLowerCase().equals(tmp.getNom().substring(0,test.length()).toLowerCase())) {
						searchList.addElement(tmp.getNom()+"#"+tmp.getPrenom()+"#"+tmp.getAdresse());
					}
				}
			}
		}
		return searchList;
	}

	/**
	 * Recherche tous les clients dont le prenom commence par les caracteres de test.
	 * @param test Prenom ou debut du prenom a rechercher.
	 * @return Un modele de JList contenant tous les clients correspondant au critere test.
	 */
	public DefaultListModel<String> rechercherPrenom(String test){
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(tmp.getPrenom().length()>(test.length()-1)) {
					if(test.equals(tmp.getPrenom().substring(0,test.length()))) {
						searchList.addElement(tmp.getNom()+"#"+tmp.getPrenom()+"#"+tmp.getAdresse());
					}
				}
			}
		}
		return searchList;
	}

	/**
	 * Recherche tous les clients dont l'adresse commence par les caracteres de test.
	 * @param test Adresse ou debut de l'adresse a rechercher.
	 * @return Un modele de JList contenant tous les clients correspondant au critere test.
	 */
	public DefaultListModel<String> rechercherAdresse(String test){
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		if(!test.isEmpty()) {
			for(int i=0;i<liste.size();i++) {
				Client tmp = liste.get(i);
				if(tmp.getAdresse().length()>(test.length()-1)) {
					if(test.equals(tmp.getAdresse().substring(0,test.length()))) {
						searchList.addElement(tmp.getNom()+"#"+tmp.getPrenom()+"#"+tmp.getAdresse());
					}
				}
			}
		}
		return searchList;
	}

	/**
	 * Extrait tous les clients de l'archive "clients".
	 * @return Un modele de JList contenant tous les clients enregistres.
	 */
	public DefaultListModel<String> tous(){
		DefaultListModel<String> searchList = new DefaultListModel<String>();
		ListeClients liste = lireClients();
		for(int i=0;i<liste.size();i++) {
			Client tmp = liste.get(i);
			searchList.addElement(tmp.getNom()+"#"+tmp.getPrenom()+"#"+tmp.getAdresse());
		}
		return searchList;
	}

	/**
	 * Constructeur
	 * @param nom Nom du cient a gerer.
	 * @param prenom Prenom du client a gerer.
	 * @param adresse Adresse postale du client a gerer.
	 * @param date1 Fin de periode probatoire du permis.
	 * @param date2 Date d'obtention du permis.
	 */
	public GestionClient(String nom, String prenom, String adresse, String date1, String date2)
	{
		client = new Client(nom, prenom, adresse, date1, date2);
	}

	/**
	 * Remplace client.
	 * @param nom Nom du cient a gerer.
	 * @param prenom Prenom du client a gerer.
	 * @param adresse Adresse postale du client a gerer.
	 * @param date1 Fin de periode probatoire du permis.
	 * @param date2 Date d'obtention du permis.
	 */
	public void setClient(String nom, String prenom, String adresse, String date1, String date2)
	{
		client = new Client(nom, prenom, adresse, date1, date2);
	}

	/**
	 * Ajoute un nouveau client a l'archive, s'il n'est pas encore enregistre.
	 * 
	 * @param client Client a enregistrer.
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
	 * Serialise la liste des clients pour mettre a jour l'archive "clients".
	 * 
	 * @param liste Liste a serialiser.
	 * @throws IOException, FileNotFoundException
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
	 * Retire un client de l'archive, s'il y est enregistre.
	 * 
	 * @param client Client a supprimer.
	 * @throws IOException, FileNotFoundException
	 */
	public void supprimerClient()
	{
		ListeClients liste = lireClients();
		liste.remove(client);
		enregistrerClients(liste);
	}

	/**
	 * Deserialise la liste des clients a partir de l'archive "clients".
	 * 
	 * @return Liste des clients enregistres.
	 * @throws IOException, FileNotFoundException, EOFException
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
	
	public Client getClient() {
		return client;
	}
	
}
