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

public class MenuVehicule extends Menu {
	
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
	private static JButton validation = new JButton("Enregistrer");
	private static JButton ok = new JButton("OK");
	private static JComboBox<String> choixV = new JComboBox<String>();
	private static JFrame fenetre;
	private static JFrame fenetre2;
	private static JPanel infoVehicule = new JPanel();
	private static boolean nouveau = true;
	
	public MenuVehicule() {
		resetBox();
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
	
	public void affMenu(String nom) {
		fenetre = null;
		infoVehicule = null;
		fenetre = new JFrame(nom);
		fenetre.setBounds(400,200,1100,500);
		GridLayout grillePrincipale = new GridLayout(2,1);
		fenetre.setLayout(grillePrincipale);
		GridLayout grilleInfo = new GridLayout(3,3);
		infoVehicule = new JPanel();
		infoVehicule.setLayout(grilleInfo);
		addGeneralTextFields();
	}
	
	public void nouveauVehicule() {
		fenetre2 = new JFrame("Nouveau véhicule");
		fenetre2.setBounds(800,400,400,100);
		FlowLayout layout = new FlowLayout();
		fenetre2.setLayout(layout);

		choixV.addActionListener(new ActionVehicule(this));
		fenetre2.add(comboBoxV(choixV));
		ok.setEnabled(false);
		ok.setText("OK");
		ok.addActionListener(new ActionVehicule(this));
		fenetre2.add(bouton(ok));
		fenetre2.setVisible(true);
		nouveau = true;
	}
	
	public void supprimerVehicule() {
		fenetre2 = new JFrame("Supprimer véhicule");
		fenetre2.setBounds(800,400,400,100);
		FlowLayout layout = new FlowLayout();
		fenetre2.setLayout(layout);

		choixV.addActionListener(new ActionVehicule(this));
		fenetre2.add(comboBoxV(choixV));
		ok.setEnabled(false);
		ok.addActionListener(new ActionVehicule(this));
		ok.setText("rechercher");
		fenetre2.add(bouton(ok));
		fenetre2.setVisible(true);
		nouveau=false;
	}
	
	public void resetBox() {
		choixV.removeAllItems();
		choixV.addItem("");
		choixV.addItem("Voiture");
		choixV.addItem("Moto");
		choixV.addItem("Avion");
	}
	
	public void Voiture(String nom)
	{
		affMenu(nom);
		
		infoVehicule.add(textField("Compteur", km));
		infoVehicule.add(textField("Puissance", puissance));
		infoVehicule.add(textField("Places", nbPlaces));
		fenetre.add(infoVehicule);
		if(fenetre.getTitle()=="Nouvelle Voiture") {
			validation.setText("enregistrer");
		}else {
			validation.setText("rechercher");
		}
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}
	
	public void Moto(String nom)
	{
		affMenu(nom);
		
		infoVehicule.add(textField("Compteur", km));
		infoVehicule.add(textField("Puissance", puissance));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		if(fenetre.getTitle()=="Nouvelle Moto") {
			validation.setText("enregistrer");
		}else {
			validation.setText("rechercher");
		}
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}
	
	public void Avion(String nom)
	{
		affMenu(nom);
		
		infoVehicule.add(textField("Heures de vol", nbHeuresVol));
		infoVehicule.add(textField("Nombre de moteurs", nbMoteurs));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		if(fenetre.getTitle()=="Nouvel Avion") {
			validation.setText("enregistrer");
		}else {
			validation.setText("rechercher");
		}
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}
	
	public void addGeneralTextFields()
	{
		infoVehicule.add(textField("Modèle", modele));
		infoVehicule.add(textField("Etat", etat));
		infoVehicule.add(textField("Prix par jour", prixJour));
		infoVehicule.add(textField("Marque", marque));
		infoVehicule.add(textField("Immatriculation", immat));
		infoVehicule.add(textField("Vitesse", vitesse));
	}

	public JFrame getFenetre()
	{
		return fenetre;
	}
	
	public JFrame getFenetreChoix()
	{
		return fenetre2;
	}
	
	public JComboBox<String> getChoixV()
	{
		return choixV;
	}
	
	public boolean isnouveau() {
		return nouveau;
	}
	
	public JButton getEnregistrer()
	{
		return validation;
	}
	
	public JButton getOK()
	{
		return ok;
	}
}
