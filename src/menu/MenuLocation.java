package menu;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.Client;
import client.GestionClient;

public class MenuLocation {

public MenuLocation() {
		
	}
	
	public void enregistrement() {
		
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
	
	public void insererclient(Client client) {
		
	}
	
	public void setValidation(String nomBouton) {
		
	}
	
}
