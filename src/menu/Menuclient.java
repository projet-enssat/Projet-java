package menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menuclient extends Menu {

	public Menuclient(String nom) {
		
		JFrame fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(4,1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1,2);
		nomPrenom.setLayout(posNomPrenom);
		JPanel champNom = textFieldvide("Nom :");
		nomPrenom.add(champNom);
		nomPrenom.add(textFieldvide("Prenom :"));
		fenetre.add(nomPrenom);
		fenetre.add(textFieldplein("Adresse :","Entrez votre adresse avec code postal et ville"));
		fenetre.add(textFieldvide("Date du permis :"));
		fenetre.add(textFieldvide("Date de fin d'apprentissage :"));
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new Action());
		fenetre.add(enregistrer);
		fenetre.setVisible(true);
		
	}
	
}
