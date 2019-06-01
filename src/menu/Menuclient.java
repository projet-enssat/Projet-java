package menu;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;

public class Menuclient extends Menu {
	JTextField adresse = new JTextField("Entrez votre adresse avec code postal et ville");
	JTextField prenom = new JTextField();
	JTextField nomclient = new JTextField();
	JTextField datepermis = new JTextField();
	JTextField dateapprentissage = new JTextField();
	
	public Menuclient() {
		
	}
	
	public void enregistrement() {
		String nom = nomclient.getText();
		System.out.println(nom);
		String prenom = this.prenom.getText();
		String adresse = this.adresse.getText();
		Date date1 = new Date(this.dateapprentissage.getText());
		Date date2 = new Date();
		date2.parse(this.datepermis.getText());
		
		Client client = new Client(nom,prenom,adresse,date1,date2);
	}
	
	public void AffMenu(String nom) {
		
		JFrame fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(5,1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1,2);
		nomPrenom.setLayout(posNomPrenom);
		JPanel champNom = textFieldvide("Nom :",nomclient);
		nomPrenom.add(champNom);
		nomPrenom.add(textFieldvide("Prenom :",prenom));
		fenetre.add(nomPrenom);
		fenetre.add(textFieldplein("Adresse :",adresse));
		fenetre.add(textFieldvide("Date du permis :",datepermis));
		fenetre.add(textFieldvide("Date de fin d'apprentissage :",dateapprentissage));
		fenetre.add(boutonclient("enregistrer"));
		fenetre.setVisible(true);
		
	}
	
}
