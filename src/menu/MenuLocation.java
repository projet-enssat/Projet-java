package menu;

import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;
import client.GestionClient;
import location.GestionLocation;
import vehicule.Vehicule;

public class MenuLocation extends Menu {

	private static JTextField debut = new JTextField();
	private static JTextField fin = new JTextField();
	private static Client client;
	private static Vehicule vehicule;
	private static JFrame fenetre;
	
	public MenuLocation() {
		
	}
	
	public void recherche() {
		if(client==null) {
			MenuClient rechClient = new MenuClient();
			rechClient.recherche();
		}else if(vehicule==null) {
			MenuVehicule rechVehicule = new MenuVehicule();
		}
	}
	
	public void enregistrement(boolean reduction) {
		new GestionLocation(client, vehicule, debut.getText(), fin.getText(), reduction).ajouterLocation();
		fenetre.dispose();
	}
	
	public void affMenu(String nom) {
		
		JFrame fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(5,1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1,2);
		nomPrenom.setLayout(posNomPrenom);
		
		/*JPanel champNom = textField("Nom :",nomClient);
		nomPrenom.add(champNom);
		nomPrenom.add(textField("Prenom :",prenom));
		fenetre.add(nomPrenom);
		fenetre.add(textField("Adresse :",adresse));
		fenetre.add(textField("Date du permis :",datePermis));
		fenetre.add(textField("Date de fin d'apprentissage :",dateApprentissage));
		validation.addActionListener(new ActionClient(this));
		fenetre.add(bouton(validation));*/
		fenetre.setVisible(true);
		
	}
	
	public void insererLocation(Client client) {
		
	}
	
	public void setValidation(String nomBouton) {
		
	}
	
}
