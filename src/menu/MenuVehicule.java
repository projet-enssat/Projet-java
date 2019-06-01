package menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.GestionClient;
import vehicule.GestionVehicule;

public class MenuVehicule extends Menu
{
	private static JTextField modele = new JTextField();
	private static JTextField etat = new JTextField();
	private static JTextField prixJour = new JTextField();
	private static JTextField marque = new JTextField();
	private static JTextField immat = new JTextField();
	private static JTextField vitesse = new JTextField();
	private static JTextField nbHeuresVol = new JTextField();
	private static JTextField nbMoteurs = new JTextField();
	private static JTextField km = new JTextField();
	private static JTextField puissance = new JTextField();
	private static JTextField nbPlaces = new JTextField();
	private static JButton enregistrer = new JButton("Enregistrer");
	private static JButton ok = new JButton("OK");
	private static String vehicule[] = {"","Voiture","Moto","Avion"};
	private static JComboBox<String> choixV = new JComboBox<String>(vehicule);
	private static JFrame fenetre = new JFrame("");
	
	public void nouveauVehicule() {
		fenetre = new JFrame("Nouveau véhicule");
		fenetre.setBounds(800,400,200,100);
		FlowLayout layout = new FlowLayout();
		fenetre.setLayout(layout);

		choixV.addActionListener(new ActionVehicule(this));
		fenetre.add(comboBoxV(choixV));
		ok.setEnabled(false);
		ok.addActionListener(new ActionVehicule(this));
		fenetre.add(bouton(ok));
		fenetre.setVisible(true);
	}
	
	public void resetBox() {
		choixV.setSelectedIndex(0);
	}
	
	public void nouvelleVoiture()
	{
		fenetre = new JFrame("Nouvelle voiture");
		fenetre.setBounds(400,200,1100,500);
		GridLayout grillePrincipale = new GridLayout(4,1);
		fenetre.setLayout(grillePrincipale);
		
		addGeneralTextFields();
		fenetre.add(textField("Compteur", km));
		fenetre.add(textField("Puissance", puissance));
		fenetre.add(textField("Places", nbPlaces));
		fenetre.add(bouton(enregistrer));
		fenetre.setVisible(true);
	}
	
	public void nouvelleMoto()
	{
		fenetre = new JFrame("Nouvelle moto");
		fenetre.setBounds(400,200,1100,500);
		GridLayout grillePrincipale = new GridLayout(4,1);
		fenetre.setLayout(grillePrincipale);
		
		addGeneralTextFields();
		fenetre.add(textField("Compteur", km));
		fenetre.add(textField("Puissance", puissance));
		fenetre.add(bouton(enregistrer));
		fenetre.setVisible(true);
	}
	
	public void nouvelAvion()
	{
		fenetre = new JFrame("Nouvel avion");
		fenetre.setBounds(400,200,1100,500);
		GridLayout grillePrincipale = new GridLayout(4,1);
		fenetre.setLayout(grillePrincipale);
		
		addGeneralTextFields();
		fenetre.add(textField("Heures de vol", nbHeuresVol));
		fenetre.add(textField("Nombre de moteurs", nbMoteurs));
		fenetre.add(bouton(enregistrer));
		fenetre.setVisible(true);
	}
	
	public void addGeneralTextFields()
	{
		fenetre.add(textField("Modèle", modele));
		fenetre.add(textField("Etat", etat));
		fenetre.add(textField("Prix par jour", prixJour));
		fenetre.add(textField("Marque", marque));
		fenetre.add(textField("Immatriculation", immat));
		fenetre.add(textField("Vitesse", vitesse));
	}
	
	public void enregistrement(String classe)
	{
		new GestionVehicule
			(	classe,
				modele.getText(), etat.getText(),  new Float(prixJour.getText()),
				marque.getText(), immat.getText(), new Integer(vitesse.getText()),
				new Float(km.getText()), 		   new Integer(puissance.getText()),
				new Integer(nbPlaces.getText()),   new Float(nbHeuresVol.getText()),
				new Integer(nbMoteurs.getText())
			).ajouterVehicule();
	}

	public JFrame getFenetre()
	{
		return fenetre;
	}
	
	public JComboBox<String> getChoixV()
	{
		return choixV;
	}
	
	public JButton getEnregistrer()
	{
		return enregistrer;
	}
	
	public JButton getOK()
	{
		return ok;
	}
}
