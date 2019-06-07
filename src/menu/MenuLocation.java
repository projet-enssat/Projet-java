package menu;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import action.ActionClient;
import action.ActionLocation;
import client.GestionClient;
import location.GestionLocation;
import vehicule.GestionVehicule;

public class MenuLocation extends Menu {

	/** Element graphique */
	private static JTextField debutTF;
	/** Element graphique */
	private static JTextField finTF;
	/** Element graphique */
	private static JTextField nomTF;
	/** Element graphique */
	private static JTextField prenomTF;
	/** Element graphique */
	private static JTextField adresseTF;
	/** Element graphique */
	private static JTextField marqueTF;
	/** Element graphique */
	private static JTextField modeleTF;
	/** Element graphique */
	private static JTextField immatTF;
	/** Element graphique */
	private static JList<String> choixNom;
	/** Element graphique */
	private static JList<String> choixPre;
	/** Element graphique */
	private static JList<String> choixAdr;
	/** Element graphique */
	private static JList<String> choixImm;
	/** Element graphique */
	private static JButton validation1;
	/** Element graphique */
	private static JButton validation2;
	/** Element graphique */
	private static JButton validation3;
	/** Element graphique */
	private static JFrame fenetre;
	/** Element graphique */
	private static JFrame fenetre2;
	/** Element graphique */
	private static JCheckBox reduction = new JCheckBox("Réduction");

	/** Acces a l'archive "clients". */
	private static GestionClient gestionClient = new GestionClient();
	/** Acces a l'archive "vehicules". */
	private static GestionVehicule gestionVehicule = new GestionVehicule();
	
	/** Indique quelle fenetre est ouverte. */
	private static boolean nouveau = true;
	
	/**
	 * Constructeur et initialisateur des elements Swing.
	 */
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
		}
		
		if (modeleTF == null)
		{
			modeleTF = new JTextField();
		}
		
		if (immatTF == null)
		{
			immatTF = new JTextField();
			immatTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		
		if (choixNom == null)
		{
			choixNom = new JList<String>();
			choixNom.setPreferredSize(new Dimension(200,150));
			choixNom.setModel(gestionClient.rechercherNom(""));
			choixNom.addListSelectionListener(new ActionLocation(this));
		}
		
		if (choixPre == null)
		{
			choixPre = new JList<String>();
			choixPre.setPreferredSize(new Dimension(200,150));
			choixPre.setModel(gestionClient.rechercherPrenom(""));
			choixPre.addListSelectionListener(new ActionLocation(this));
		}

		if (choixAdr == null)
		{
			choixAdr = new JList<String>();
			choixAdr.setPreferredSize(new Dimension(200,150));
			choixAdr.setModel(gestionClient.rechercherAdresse(""));
			choixAdr.addListSelectionListener(new ActionLocation(this));
		}
		
		if (choixImm == null)
		{
			choixImm = new JList<String>();
			choixImm.setPreferredSize(new Dimension(200,150));
			choixImm.setModel(gestionVehicule.toutesLesImmats(null, null, ""));
			choixImm.addListSelectionListener(new ActionLocation(this));
		}
	}
	
	/**
	 * Affiche la fenetre d'enregistrement de location.
	 * @param nom Titre de la fenetre.
	 */
	public void nouvLocation(String nom)
	{
		nouveau = true;
		
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

		validation1.setEnabled(true);
		panelClient.add(bouton(validation1));
		fenetre.add(panelClient);

		JPanel panelVehi = new JPanel(new GridLayout(4,1));
		
		JPanel panelMarque = new JPanel(new GridLayout(2,1));
		panelMarque.add(textFieldLabelAbove(marqueTF, "Marque :"));
		marqueTF.setEnabled(false);
		panelVehi.add(panelMarque);

		JPanel panelModele = new JPanel(new GridLayout(2,1));
		panelModele.add(textFieldLabelAbove(modeleTF, "Modéle :"));
		modeleTF.setEnabled(false);
		panelVehi.add(panelModele);

		JPanel panelImmat = new JPanel(new GridLayout(2,1));
		panelImmat.add(textFieldLabelAbove(immatTF, "Immatriculation :"));
		panelImmat.add(listV(choixImm));
		panelVehi.add(panelImmat);
		
		validation2.setEnabled(true);
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
	
	public void finLocation1()
	{
		nouveau = false;
		if (fenetre2 != null) { fenetre2.removeAll(); }
		fenetre2 = new JFrame("Supprimer une location");
		fenetre2.setBounds(400, 400, 1100, 200);
		fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre2.setLayout(new GridLayout(2, 4));

		fenetre2.add(textFieldLabelAbove(nomTF, "Nom :"));
		fenetre2.add(textFieldLabelAbove(prenomTF, "Prénom :"));
		fenetre2.add(textFieldLabelAbove(adresseTF, "Adresse :"));
		fenetre2.add(bouton(validation1));
		fenetre2.add(listV(choixNom));
		fenetre2.add(listV(choixPre));
		fenetre2.add(listV(choixAdr));
		fenetre2.setVisible(true);
	}
	
	public void finLocation2()
	{
		nouveau = false;
		if (fenetre2 != null) { fenetre2.removeAll(); }
		fenetre2 = new JFrame("Supprimer une location");
		fenetre2.setBounds(400, 400, 1100, 200);
		fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre2.setLayout(new GridLayout(2, 4));

		marqueTF.setEnabled(false);
		fenetre2.add(textFieldLabelAbove(marqueTF, "Marque :"));
		modeleTF.setEnabled(false);
		fenetre2.add(textFieldLabelAbove(modeleTF, "Modéle :"));
		fenetre2.add(textFieldLabelAbove(immatTF, "Immatriculation :"));
		fenetre2.add(bouton(validation2));
		fenetre2.add(vide());
		fenetre2.add(vide());
		fenetre2.add(listV(choixImm));
		fenetre2.setVisible(true);
	}
	
	public void finLocation3()
	{
		nouveau = false;
		if (fenetre2 != null) { fenetre2.removeAll(); }
		fenetre2 = new JFrame("Supprimer une location");
		fenetre2.setBounds(400, 400, 1100, 200);
		fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre2.setLayout(new GridLayout(2, 4));

		marqueTF.setEnabled(false);
		fenetre2.add(textFieldLabelAbove(marqueTF, "Marque :"));
		modeleTF.setEnabled(false);
		fenetre2.add(textFieldLabelAbove(modeleTF, "Modéle :"));
		fenetre2.add(textFieldLabelAbove(immatTF, "Immatriculation :"));
		fenetre2.add(bouton(validation2));
		fenetre2.add(vide());
		fenetre2.add(vide());
		fenetre2.add(listV(choixImm));
		fenetre2.setVisible(true);
	}
	
	/**
	 * Change le statut des boutons de validation si un client est correctement selectionne. Utilise lors d'une validation.
	 */
	public void validerClient() {
		if(gestionClient.EstClient()) {
			validation1.setEnabled(false);
			if(!validation2.isEnabled()) {
				validation3.setEnabled(true);
			}
		}else {
			Erreur("Erreur de selection Client","Le Client que vous avez selectionne n'existe pas", "Fermez la fenetre puis recommencer");
		}
	}
	
	/**
	 * Remplit les attributs de gestionClient avec ceux entres.
	 */
	public void verifClient()
	{
		gestionClient.getClient().setNom(nomTF.getText());
		gestionClient.getClient().setPrenom(prenomTF.getText());
		gestionClient.getClient().setAdresse(adresseTF.getText());
	}

	/**
	 * Change le statut des boutons de validation si un vehicule est corectement selectionner. Utilise lors d'une validation.
	 */
	public void validerVehicule() {
		validation2.setEnabled(false);
		if(!validation1.isEnabled()) {
			validation3.setEnabled(true);
		}
	}
	
	/**
	 * Enregistre une location dans l'archive "locations".
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void enregistrement()
	{
		boolean red=false;
		if(reduction.isEnabled() && reduction.isSelected()) {
			red=true;
		}
		new GestionLocation(gestionClient.getClient(), gestionVehicule.getVehicule(), debutTF.getText(), finTF.getText(), red).ajouterLocation();
		fenetre.dispose();
	}
	
	/**
	 * Renvoie choixAdr.
	 * @return JList contenant les adresses.
	 */
	public JList<String> getListAdresse() {
		return choixAdr;
	}
	
	/**
	 * Renvoie choixNom.
	 * @return JList contenant les noms.
	 */
	public JList<String> getListNom() {
		return choixNom;
	}
	
	/**
	 * Renvoie choixPre.
	 * @return JList contenant les prenoms.
	 */
	public JList<String> getListPrenom() {
		return choixPre;
	}
	
	/**
	 * Remplit les champs nomTF, prenomTF et adresseTF avec les attributs du client (sous forme de chaine de caracteres).
	 * @param client Client a inserer.
	 */
	public void autoCompletionClient()
	{
		((ActionLocation) choixNom.getListSelectionListeners()[0]).toggle();
		((ActionLocation) choixPre.getListSelectionListeners()[0]).toggle();
		((ActionLocation) choixAdr.getListSelectionListeners()[0]).toggle();
		
		choixNom.setModel(gestionClient.rechercherNom(nomTF.getText()));
		choixPre.setModel(gestionClient.rechercherPrenom(prenomTF.getText()));
		choixAdr.setModel(gestionClient.rechercherAdresse(adresseTF.getText()));
		
		((ActionLocation) choixNom.getListSelectionListeners()[0]).toggle();
		((ActionLocation) choixPre.getListSelectionListeners()[0]).toggle();
		((ActionLocation) choixAdr.getListSelectionListeners()[0]).toggle();
	}

	/**
	 * Remplit les champs marqueTF, modeleTF et immatTF avec les attributs du vehicule (sous forme de chaine de caracteres).
	 * @param vehicule Vehicule a inserer.
	 */
	public void autoCompletionVehicule()
	{
		((ActionLocation) choixImm.getListSelectionListeners()[0]).toggle();
		gestionVehicule.rechercheVehicule(immatTF.getText());
		choixImm.setModel(gestionVehicule.toutesLesImmats(null, null, immatTF.getText()));
		marqueTF.setText(gestionVehicule.getVehicule().getMarque());
		modeleTF.setText(gestionVehicule.getVehicule().getModele());
		validation2.setEnabled(true);
		((ActionLocation) choixImm.getListSelectionListeners()[0]).toggle();
	}
	
	/**
	 * Renvoie validation1.
	 * @return JButton de validation client.
	 */
	public JButton getValidation1() {
		return validation1;
	}
	
	/**
	 * Renvoie validation2.
	 * @return JButton de validation vehicule.
	 */
	public JButton getValidation2() {
		return validation2;
	}
	
	/**
	 * Renvoie validation3.
	 * @return JButton de validaiton location.
	 */
	public JButton getValidation3() {
		return validation3;
	}
	
	/**
	 * Renvoie choixImm.
	 * @return JList des immatriculations.
	 */
	public JList<String> getListImmat() {
		return choixImm;
	}

	/**
	 * Renvoie debutTF.
	 * @return JTextField de saisie de date de debut.
	 */
	public JTextField getDebutTF() {
		return debutTF;
	}

	/**
	 * Renvoie finTF.
	 * @return JTextField de saisie de date de fin.
	 */
	public JTextField getFinTF() {
		return finTF;
	}

	/**
	 * Renvoie nomTF.
	 * @return JTextField de saisie de nom.
	 */
	public JTextField getNomTF() {
		return nomTF;
	}

	/**
	 * Renvoie prenomTF.
	 * @return JTextField de saisie de prenom.
	 */
	public JTextField getPrenomTF() {
		return prenomTF;
	}

	/**
	 * Renvoie adresseTF.
	 * @return JTextField de saisie d'adresse.
	 */
	public JTextField getAdresseTF() {
		return adresseTF;
	}

	/**
	 * Renvoie marqueTF.
	 * @return JTextField de saisie de marque.
	 */
	public JTextField getMarqueTF() {
		return marqueTF;
	}

	/**
	 * Renvoie modeleTF.
	 * @return JTextField de saisie de modele.
	 */
	public JTextField getModeleTF() {
		return modeleTF;
	}

	/**
	 * Renvoie immatTF.
	 * @return JTextField de saisie d'immatriculation.
	 */
	public JTextField getImmatTF() {
		return immatTF;
	}
	

	/**
	 * Renvoie fenetre2.
	 * @return JFrame de suppression de location.
	 */
	public JFrame getFenetre2()
	{
		return fenetre2;
	}
	
	/**
	 * Verifie que les dates entrees sont au bon format (XX/XX/XXXX).
	 */
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
				new Integer(annee);
				new Integer(mois);
				new Integer(jour);
				dateDebut = new GregorianCalendar(Integer.parseInt(annee),Integer.parseInt(mois),Integer.parseInt(jour));
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
				new Integer(annee);
				new Integer(mois);
				new Integer(jour);
				dateFin = new GregorianCalendar(Integer.parseInt(annee),Integer.parseInt(mois),Integer.parseInt(jour));
			}
		}
		if(debutCorrect && finCorrect) {
			long difference = dateFin.getTimeInMillis() - dateDebut.getTimeInMillis();
			System.out.println(difference);
			Calendar diff = new GregorianCalendar();
			diff.setTimeInMillis(difference);
			System.out.println(diff.get(Calendar.MONTH));
			if(diff.get(Calendar.DAY_OF_MONTH)>6 || diff.get(Calendar.MONTH)>0 || diff.get(Calendar.YEAR)>0) {
				reduction.setEnabled(true);
			}else {
				reduction.setEnabled(false);
			}
		}else if(debutCorrect){
			reduction.setEnabled(false);
			finTF.setText("Format : jj/mm/aaaa svp");
		}else if(finCorrect){
			reduction.setEnabled(false);
			debutTF.setText("Format : jj/mm/aaaa svp");
		}else {
			reduction.setEnabled(false);
			debutTF.setText("Format : jj/mm/aaaa svp");
			finTF.setText("Format : jj/mm/aaaa svp");
		}
	}
	
	/**
	 * Renvoie nouveau.
	 * @return boolean indiquant si la fenetre ouverte est celle d'enregistrement ou non.
	 */
	public boolean isNouveau()
	{
		return nouveau;
	}

}
