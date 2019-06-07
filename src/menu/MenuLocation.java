package menu;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

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
			debutTF.addActionListener(new ActionLocation(this));
		}
		
		if (finTF == null)
		{
			finTF = new JTextField();
			finTF.addActionListener(new ActionLocation(this));
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
		
		if (choixImm == null)
		{
			choixImm = new JList<String>();
			choixImm.addListSelectionListener(new ActionLocation(this));
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
		panelMarque.add(textFieldLabelAbove(marqueTF, "Marque :"));
		marqueTF.setEnabled(false);
		panelVehi.add(panelMarque);

		JPanel panelModele = new JPanel(new GridLayout(2,1));
		panelModele.add(textFieldLabelAbove(modeleTF, "Modèle :"));
		modeleTF.setEnabled(false);
		panelVehi.add(panelModele);

		JPanel panelImmat = new JPanel(new GridLayout(2,1));
		panelImmat.add(textFieldLabelAbove(immatTF, "Immatriculation :"));
		panelImmat.add(listV(choixImm));
		panelVehi.add(panelImmat);
		
		panelVehi.add(bouton(validation2));
		fenetre.add(panelVehi);

		JPanel panelLoc = new JPanel(new GridLayout(4,1));

		panelLoc.add(textFieldLabelAbove(debutTF, "Date de Début :"));
		panelLoc.add(textFieldLabelAbove(finTF, "Date de Fin : "));
		
		JPanel panelReduction = new JPanel();
		reduction.setEnabled(false);
		panelReduction.add(reduction);
		panelLoc.add(panelReduction);
		
		validation3.setEnabled(false);
		panelLoc.add(bouton(validation3));
		
		fenetre.add(panelLoc);
		
		fenetre.setVisible(true);
	}
	
	public void validerClient() {
		validation1.setEnabled(false);
		if(!validation2.isEnabled()) {
			validation3.setEnabled(true);
		}
	}
	
	public void validerVehicule() {
		validation2.setEnabled(false);
		if(!validation1.isEnabled()) {
			validation3.setEnabled(true);
		}
	}
	
	public void setEnregistrement()
	{
		boolean red=false;
		if(reduction.isEnabled() && reduction.isSelected()) {
			red=true;
		}
		enregistrement(red);
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
	
	public JList<String> getListAdresse() {
		return choixAdr;
	}
	
	public void refreshNom() {
		choixNom.setModel(gestionClient.rechercherNom(nomTF.getText()));
	}
	
	public JList<String> getListNom() {
		return choixNom;
	}
	
	public void refreshPrenom() {
		choixPre.setModel(gestionClient.rechercherPrenom(prenomTF.getText()));
	}
	
	public JList<String> getListPrenom() {
		return choixPre;
	}
	
	public void autoCompClient(String client) {
		if(client.contains("#")) {
			gestionClient.select(client);
		}
		nomTF.setText(gestionClient.getClient().getNom());
		prenomTF.setText(gestionClient.getClient().getPrenom());
		adresseTF.setText(gestionClient.getClient().getAdresse());
	}
	
	public void autoCompVehicule(String vehicule) {
		gestionVehicule.rechercheVehicule(vehicule);
		immatTF.setText(gestionVehicule.getVehicule().getImmatriculation());
		modeleTF.setText(gestionVehicule.getVehicule().getModele());
		marqueTF.setText(gestionVehicule.getVehicule().getMarque());
		validation2.setEnabled(true);
	}
	
	public JButton getValidation1() {
		return validation1;
	}
	
	public JButton getValidation2() {
		return validation2;
	}
	
	public JButton getValidation3() {
		return validation3;
	}
	
	
	public void refreshImmat() {
		choixImm.setModel(gestionVehicule.toutesLesImmats(null, null, immatTF.getText()));
	}
	
	public JList<String> getListImmat() {
		return choixImm;
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
	
	public void verifDate() {
		Calendar dateDebut = null;
		Calendar dateFin = null;
		String debut = debutTF.getText();
		String fin = finTF.getText();
		String jour,mois,annee;
		int tJour,tMois;
		boolean debutCorrect=false;
		boolean finCorrect=false;
		
		if(debut.contains("/")) {
			tJour=debut.indexOf("/");
			jour=debut.substring(0,tJour);
			if(debut.substring(tJour).contains("/")) {
				tMois=tJour+debut.substring(tJour+1).indexOf("/")+1;
				mois=debut.substring(tJour+1,tMois);
				annee=debut.substring(tMois+1);
				debutCorrect=true;
				dateDebut = new GregorianCalendar(new Integer(annee).parseInt(annee),new Integer(mois).parseInt(mois),new Integer(jour).parseInt(jour));
			}
		}
		if(fin.contains("/")) {
			tJour=fin.indexOf("/");
			jour=fin.substring(0,tJour);
			if(fin.substring(tJour).contains("/")) {
				tMois=tJour+debut.substring(tJour+1).indexOf("/")+1;
				mois=fin.substring(tJour+1,tMois);
				annee=fin.substring(tMois+1);
				finCorrect=true;
				dateFin = new GregorianCalendar(new Integer(annee).parseInt(annee),new Integer(mois).parseInt(mois),new Integer(jour).parseInt(jour));
			}
		}
		if(debutCorrect && finCorrect) {
			long difference = dateFin.getTimeInMillis() - dateDebut.getTimeInMillis();
			System.out.println(difference);
			Calendar diff = new GregorianCalendar();
			diff.setTimeInMillis(difference);
			System.out.println(diff.get(Calendar.MONTH));
			if(diff.get(Calendar.DAY_OF_MONTH)>7 || diff.get(Calendar.MONTH)>1) {
				reduction.setEnabled(true);
			}else {
				reduction.setEnabled(false);
			}
		}else if(debutCorrect){
			reduction.setEnabled(false);
			finTF.setText("Format : jj/mm/aaaa");
		}else if(finCorrect){
			reduction.setEnabled(false);
			debutTF.setText("Format : jj/mm/aaaa");
		}else {
			reduction.setEnabled(false);
			debutTF.setText("Format : jj/mm/aaaa");
			finTF.setText("Format : jj/mm/aaaa");
		}
	}
	
}
