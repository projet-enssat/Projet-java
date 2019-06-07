package menu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;
import client.GestionClient;
import location.GestionLocation;
import vehicule.Vehicule;

public class MenuLocation extends Menu {

	private static JTextField debutTF;
	private static JTextField finTF;
	private static JTextField nomTF;
	private static JTextField prenomTF;
	private static JTextField adresseTF;
	private static JTextField marqueTF;
	private static JTextField modeleTF;
	private static JTextField immatTF;
	private static JList<String> choixNom;
	private static JList<String> choixPre;
	private static JList<String> choixAdr;
	private static JList<String> choixMar;
	private static JList<String> choixMod;
	private static JList<String> choixImm;
	private static JButton validation1;
	private static JButton validation2;
	private static JButton validation3;
	private static Client client;
	private static Vehicule vehicule;
	private static JFrame fenetre;
	private static boolean nouveau = true;
	
	public MenuLocation()
	{
		if (validation1 == null)
		{
			validation1 = new JButton("Valider");
			validation1.addActionListener(new ActionLocation(this));
		}
		
		if (validation2 == null)
		{
			validation2 = new JButton("Valider");
			validation2.addActionListener(new ActionLocation(this));
		}
		
		if (validation3 == null)
		{
			validation3 = new JButton("Valider");
			validation3.addActionListener(new ActionLocation(this));
		}
		
		if (debutTF == null)
		{
			debutTF = new JTextField();
		}
		
		if (finTF == null)
		{
			finTF = new JTextField();
		}
		
		if (nomTF == null)
		{
			nomTF = new JTextField();
		}
		
		if (prenomTF == null)
		{
			prenomTF = new JTextField();
		}
		
		if (adresseTF == null)
		{
			adresseTF = new JTextField();
		}
		
		if (marqueTF == null)
		{
			marqueTF = new JTextField();
		}
		
		if (modeleTF == null)
		{
			modeleTF = new JTextField();
		}
		
		if (immatTF == null)
		{
			immatTF = new JTextField();
		}
		
		if (choixNom == null)
		{
			choixNom = new JList<String>();
		}
		
		if (choixPre == null)
		{
			choixPre = new JList<String>();
		}

		if (choixAdr == null)
		{
			choixAdr = new JList<String>();
		}
		
		if (choixMar == null)
		{
			choixMar = new JList<String>();
		}
		
		if (choixMod == null)
		{
			choixMod = new JList<String>();
		}
		
		if (choixImm == null)
		{
			choixImm = new JList<String>();
		}
	}
	
	public void nouvLocation(String nom)
	{
		if (fenetre != null) { fenetre.removeAll(); }
		fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout grillePrincipale = new GridLayout(1,3);
		fenetre.setLayout(grillePrincipale);
		
		
		JPanel panelClient = new JPanel(new GridLayout(4,1));
		JPanel panelVehi = new JPanel(new GridLayout(4,1));
		JPanel panelLoc = new JPanel(new GridLayout(3,1));
		
		JPanel panelNom = new JPanel(new GridLayout(2,1));
		panelNom.add(textFieldLabelAbove(nomTF, "Nom :"));
		panelNom.add(listV(choixNom));
		panelClient.add(panelNom);

		JPanel panelPrenom = new JPanel(new GridLayout(2,1));
		panelPrenom.add(textFieldLabelAbove(prenomTF, "Prénom :"));
		panelPrenom.add(listV(choixPre));
		panelClient.add(panelPrenom);

		JPanel panelAdresse = new JPanel(new GridLayout(2,1));
		panelAdresse.add(textFieldLabelAbove(adresseTF, "Adresse :"));
		panelAdresse.add(listV(choixAdr));
		panelClient.add(panelAdresse);
		
		panelClient.add(bouton(validation1));
		fenetre.add(panelClient);
		
		
		JPanel panelMarque = new JPanel(new GridLayout(2,1));
		marqueTF.setEnabled(false);
		panelMarque.add(textFieldLabelAbove(marqueTF, "Marque :"));
		choixMar.setEnabled(false);
		panelMarque.add(listV(choixMar));
		panelVehi.add(panelMarque);

		JPanel panelModele = new JPanel(new GridLayout(2,1));
		modeleTF.setEnabled(false);
		panelModele.add(textFieldLabelAbove(modeleTF, "Modèle :"));
		choixMod.setEnabled(false);
		panelModele.add(listV(choixMod));
		panelVehi.add(panelModele);

		JPanel panelImmat = new JPanel(new GridLayout(2,1));
		immatTF.setEnabled(false);
		panelImmat.add(textFieldLabelAbove(immatTF, "Immatriculation :"));
		choixImm.setEnabled(false);
		panelImmat.add(listV(choixImm));
		panelVehi.add(panelImmat);
		
		validation2.setEnabled(false);
		panelVehi.add(bouton(validation2));
		fenetre.add(panelVehi);

		
		JPanel panelDates = new JPanel(new GridLayout(3,1));
		debutTF.setEnabled(false);
		panelDates.add(textFieldLabelLeft("Début :", debutTF));
		finTF.setEnabled(false);
		panelDates.add(textFieldLabelLeft("Fin :", finTF));
		validation3.setEnabled(false);
		panelDates.add(bouton(validation3));
		panelLoc.add(vide());
		panelLoc.add(panelDates);
		panelLoc.add(vide());
		fenetre.add(panelLoc);
		
		
		fenetre.setVisible(true);
	}
	
	public void enregistrement(boolean reduction)
	{
		new GestionLocation(client, vehicule, debutTF.getText(), finTF.getText(), reduction).ajouterLocation();
		fenetre.dispose();
	}
	
	public void insererLocation(Client client) {
		
	}
	
	public void setValidation(String nomBouton) {
		
	}
	
}
