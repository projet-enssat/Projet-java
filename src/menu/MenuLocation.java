package menu;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import client.Client;
import client.GestionClient;
import location.GestionLocation;
import vehicule.GestionVehicule;

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
	private static GestionClient gestionClient = new GestionClient();
	private static GestionVehicule gestionVehicule = new GestionVehicule();
	private static JFrame fenetre;
	private static JCheckBox reduction = new JCheckBox("Réduction");
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
			debutTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (finTF == null)
		{
			finTF = new JTextField();
			finTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (nomTF == null)
		{
			nomTF = new JTextField();
			nomTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (prenomTF == null)
		{
			prenomTF = new JTextField();
			prenomTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (adresseTF == null)
		{
			adresseTF = new JTextField();
			adresseTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (marqueTF == null)
		{
			marqueTF = new JTextField();
			marqueTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (modeleTF == null)
		{
			modeleTF = new JTextField();
			modeleTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (immatTF == null)
		{
			immatTF = new JTextField();
			immatTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (choixNom == null)
		{
			choixNom = new JList<String>();
			choixNom.addListSelectionListener(new ActionLocation(this));
		}
		
		if (choixPre == null)
		{
			choixPre = new JList<String>();
			choixPre.addListSelectionListener(new ActionLocation(this));
		}

		if (choixAdr == null)
		{
			choixAdr = new JList<String>();
			choixAdr.addListSelectionListener(new ActionLocation(this));
		}
		
		if (choixMar == null)
		{
			choixMar = new JList<String>();
			choixMar.addListSelectionListener(new ActionLocation(this));
		}
		
		if (choixMod == null)
		{
			choixMod = new JList<String>();
			choixMod.addListSelectionListener(new ActionLocation(this));
		}
		
		if (choixImm == null)
		{
			choixImm = new JList<String>();
			choixImm.addListSelectionListener(new ActionLocation(this));
		}
	}public void nouvLocation(String nom)
	{
		if (fenetre != null) { fenetre.removeAll(); }
		fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout grillePrincipale = new GridLayout(1,3);
		fenetre.setLayout(grillePrincipale);
		
		JPanel panelClient = new JPanel(new GridLayout(4,1));
		
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

		JPanel panelVehi = new JPanel(new GridLayout(4,1));
		
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
		
		panelVehi.add(bouton(validation2));
		fenetre.add(panelVehi);

		JPanel panelLoc = new JPanel(new GridLayout(4,1));
		
		JPanel panelDebut = new JPanel();
		panelDebut.add(textFieldLabelAbove(finTF, "Date de Début :"));
		panelLoc.add(panelDebut);
		
		JPanel panelFin = new JPanel();
		panelFin.add(textFieldLabelAbove(debutTF, "Date de Fin : "));
		panelLoc.add(panelFin);
		
		JPanel panelReduction = new JPanel();
		reduction.setEnabled(false);
		panelReduction.add(reduction);
		panelLoc.add(panelReduction);
		
		validation3.setEnabled(false);
		panelLoc.add(bouton(validation3));
		
		fenetre.add(panelLoc);
		
		fenetre.setVisible(true);
	}
	
	public void enregistrement(boolean reduction)
	{
		new GestionLocation(gestionClient.getClient(), gestionVehicule.getVehicule(), debutTF.getText(), finTF.getText(), reduction).ajouterLocation();
		fenetre.dispose();
	}
	
	public void setValidation(String nomBouton) {
		
	}
	
	public void refreshAdresse() {
		choixAdr.setModel(gestionClient.rechercherAdresse(adresseTF.getText()));
	}
	
	public void refreshNom() {
		choixNom.setModel(gestionClient.rechercherNom(nomTF.getText()));
	}
	
	public void refreshPrenom() {
		choixPre.setModel(gestionClient.rechercherPrenom(prenomTF.getText()));
	}
	
	public void refreshImmat() {
		choixImm.setModel(gestionVehicule.toutesLesImmats(null, null, immatTF.getText()));
	}
	
	public void refreshModele() {
		choixMod.setModel(gestionVehicule.tousLesModeles(null, modeleTF.getText()));
	}
	
	public void refreshMarque() {
		choixMar.setModel(gestionVehicule.toutesLesMarques(marqueTF.getText()));
	}
	
	public Document getDebutTFDocument() {
		return debutTF.getDocument();
	}

	public Document getFinTFDocument() {
		return finTF.getDocument();
	}

	public Document getNomTFDocument() {
		return nomTF.getDocument();
	}

	public Document getPrenomTFDocument() {
		return prenomTF.getDocument();
	}

	public Document getAdresseTFDocument() {
		return adresseTF.getDocument();
	}

	public Document getMarqueTFDocument() {
		return marqueTF.getDocument();
	}

	public Document getModeleTFDocument() {
		return modeleTF.getDocument();
	}

	public Document getImmatTFDocument() {
		return immatTF.getDocument();
	}
	
}
