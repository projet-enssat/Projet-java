package menu;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;
import client.GestionClient;

public class MenuClient extends Menu {
	JTextField adresse = new JTextField("Entrez votre adresse avec code postal et ville");
	JTextField prenom = new JTextField();
	JTextField nomClient = new JTextField();
	JTextField datePermis = new JTextField();
	JTextField dateApprentissage = new JTextField();
	JButton enregistrer = new JButton("Enregistrer");
	
	public MenuClient() {
		
	}
	
	public void enregistrement() {
		GestionClient gClient = new GestionClient();
		gClient.setClient(nomClient.getText(),prenom.getText(),adresse.getText(),
						  dateApprentissage.getText(), datePermis.getText());
		gClient.ajouterClient();
	}
	
	public void affMenu(String nom) {
		
		JFrame fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(5,1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1,2);
		nomPrenom.setLayout(posNomPrenom);
		JPanel champNom = textField("Nom :",nomClient);
		nomPrenom.add(champNom);
		nomPrenom.add(textField("Prenom :",prenom));
		fenetre.add(nomPrenom);
		fenetre.add(textField("Adresse :",adresse));
		fenetre.add(textField("Date du permis :",datePermis));
		fenetre.add(textField("Date de fin d'apprentissage :",dateApprentissage));
		enregistrer.addActionListener(new ActionClient(this));
		fenetre.add(bouton(enregistrer));
		fenetre.setVisible(true);
		
	}
	
}
