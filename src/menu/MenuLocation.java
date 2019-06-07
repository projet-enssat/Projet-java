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
import javax.swing.event.DocumentListener;

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
	private static JTextField kmTF;
	/** Element graphique */
	private static JTextField prixTF;
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
	/** Acces a l'archive "locations". */
	private static GestionLocation gestionLocation;
	
	/** Element graphique */
	private DocumentListener doc = new ActionLocation(this);
	
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
		validation1.setEnabled(true);
		
		if (validation2 == null)
		{
			validation2 = new JButton("Valider");
			validation2.addActionListener(new ActionLocation(this));
		}
		validation2.setEnabled(true);
		
		if (validation3 == null)
		{
			validation3 = new JButton("Valider");
			validation3.addActionListener(new ActionLocation(this));
		}
		validation3.setEnabled(true);
		
		if (debutTF == null)
		{
			debutTF = new JTextField();
			debutTF.addActionListener(new ActionLocation(this));
		}
		debutTF.setText("");
		
		if (finTF == null)
		{
			finTF = new JTextField();
			finTF.addActionListener(new ActionLocation(this));
		}
		finTF.setText("");
		
		if (nomTF == null)
		{
			nomTF = new JTextField();
			nomTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		nomTF.setText("");
		
		if (prenomTF == null)
		{
			prenomTF = new JTextField();
			prenomTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		prenomTF.setText("");
		
		if (adresseTF == null)
		{
			adresseTF = new JTextField();
			adresseTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		adresseTF.setText("");
		
		if (marqueTF == null)
		{
			marqueTF = new JTextField();
		}
		marqueTF.setText("");
		
		if (modeleTF == null)
		{
			modeleTF = new JTextField();
		}
		modeleTF.setText("");
		
		if (immatTF == null)
		{
			immatTF = new JTextField();
			immatTF.getDocument().addDocumentListener(doc);
		}
		immatTF.setText("");

		if (kmTF == null)
		{
			kmTF = new JTextField();
			kmTF.getDocument().addDocumentListener(new ActionLocation(this));
		}
		kmTF.setText("");

		if (prixTF == null)
		{
			prixTF = new JTextField();
			prixTF.setEnabled(false);
		}
		prixTF.setText("");
		
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
			choixPre.setModel(gestionClient.rechercherPrenom(null, ""));
			choixPre.addListSelectionListener(new ActionLocation(this));
		}

		if (choixAdr == null)
		{
			choixAdr = new JList<String>();
			choixAdr.setPreferredSize(new Dimension(200,150));
			choixAdr.setModel(gestionClient.rechercherAdresse(null, null,""));
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
		panelPrenom.add(textFieldLabelAbove(prenomTF, "Prenom :"));
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
		panelModele.add(textFieldLabelAbove(modeleTF, "Modele :"));
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

		panelLoc.add(textFieldLabelAbove(debutTF, "Date de Debut :"));
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

		nomTF.setText("");
		prenomTF.setText("");
		adresseTF.setText("");
		fenetre2.add(textFieldLabelAbove(nomTF, "Nom :"));
		fenetre2.add(textFieldLabelAbove(prenomTF, "Prenom :"));
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
		marqueTF.setText("");
		fenetre2.add(textFieldLabelAbove(marqueTF, "Marque :"));
		modeleTF.setEnabled(false);
		modeleTF.setText("");
		fenetre2.add(textFieldLabelAbove(modeleTF, "Modele :"));
		immatTF.setText("");
		fenetre2.add(textFieldLabelAbove(immatTF, "Immatriculation :"));
		fenetre2.add(bouton(validation2));
		fenetre2.add(vide());
		fenetre2.add(vide());
		((ActionLocation) doc).toggle();
		choixImm.setModel(gestionLocation.rechercheVehicules());
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

		debutTF.setEnabled(false);
		debutTF.setText(gestionLocation.getLocation().getDebut());
		System.out.println(gestionLocation.getLocation().getDebut());
		fenetre2.add(textFieldLabelAbove(debutTF, "Début :"));
		finTF.setEnabled(false);
		finTF.setText(gestionLocation.getLocation().getFin());
		fenetre2.add(textFieldLabelAbove(finTF, "Fin :"));
		fenetre2.add(textFieldLabelAbove(kmTF, "Kilomètres parcourus :"));
		fenetre2.add(bouton(validation3));
		fenetre2.setVisible(true);
	}
	
	/**
	 * Change le statut des boutons de validation si un client est correctement selectionne. Utilise lors d'une validation.
	 */
	public void validerClient() {
		if(gestionClient.EstClient()) {
			validation1.setEnabled(false);
			if (!validation2.isEnabled())
			{
				debutTF.setEnabled(true);
				finTF.setEnabled(true);
			}
		}else {
			Erreur("Erreur de selection Client","Le Client que vous avez selectionne n'existe pas", "Fermez la fenetre puis recommencez");
		}
	}
	
	/**
	 * Change le statut des boutons de validation si un client est correctement selectionne. Utilise lors d'une validation.
	 */
	public void validerVehicule() {
		gestionVehicule.rechercheVehicule(immatTF.getText());
		if(!(gestionVehicule.getVehicule() == null)) {
			validation2.setEnabled(false);
			if (!validation1.isEnabled())
			{
				debutTF.setEnabled(true);
				finTF.setEnabled(true);
			}
		}else {
			Erreur("Erreur de selection Vehicule","Le Vehicule que vous avez selectionne n'existe pas", "Fermez la fenetre puis recommencez");
		}
	}
	
	
	/**
	 * Change le statut des boutons de validation si un client est correctement selectionne. Utilise lors d'une validation.
	 */
	public void validerClientSuppr() {
		gestionLocation = new GestionLocation(gestionClient.getClient(), gestionVehicule.getVehicule(), debutTF.getText(), finTF.getText(), reduction.isSelected());
		gestionLocation.getLocation().setClient(gestionClient.getClient());
		if(gestionClient.EstClient() && !(gestionLocation.rechercheVehicules() == null))
		{
			fenetre2.dispose();
			finLocation2();
		} else {
			Erreur("Erreur de selection Client","Le Client que vous avez selectionne n'existe pas ou n'a pas de location en cours", "Fermez la fenetre puis recommencez");
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
	 * Remplit les attributs de gestionClient avec ceux entres.
	 */
	public void verifVehicule()
	{
		gestionVehicule.getVehicule().setImmatriculation(immatTF.getText());
		gestionVehicule.getVehicule().setMarque(marqueTF.getText());
		gestionVehicule.getVehicule().setModele(modeleTF.getText());
	}

	/**
	 * Change le statut des boutons de validation si un vehicule est corectement selectionner. Utilise lors d'une validation.
	 */
	public void validerLocation() {
		gestionLocation = new GestionLocation(gestionClient.getClient(), gestionVehicule.getVehicule(), debutTF.getText(), finTF.getText(), reduction.isSelected());
		gestionLocation.setLocation(gestionLocation.rechercheLocation());
		if (!(gestionLocation.rechercheLocation() == null))
		{
			fenetre2.dispose();
			finLocation3();
		} else {
			Erreur("Erreur de selection Location","La Location que vous avez selectionnee n'existe pas", "Fermez la fenetre puis recommencez");
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
		choixPre.setModel(gestionClient.rechercherPrenom(nomTF.getText(), prenomTF.getText()));
		choixAdr.setModel(gestionClient.rechercherAdresse(nomTF.getText(), prenomTF.getText(), adresseTF.getText()));
		
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
	 * Renvoie kmTF.
	 * @return JTextField de saisie de kilometres parcourus.
	 */
	public JTextField getKmTF() {
		return kmTF;
	}

	/**
	 * Renvoie prixTF.
	 * @return JTextField d'affichage du prix.
	 */
	public JTextField getPrixTF() {
		return prixTF;
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
		
		System.out.println("test");
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
			validation3.setEnabled(true);
			long difference = dateFin.getTimeInMillis() - dateDebut.getTimeInMillis();
			Calendar diff = new GregorianCalendar();
			if(diff.get(Calendar.DAY_OF_MONTH)>7 || diff.get(Calendar.MONTH)>1) {
				diff.setTimeInMillis(difference);
				if (diff.get(Calendar.DAY_OF_MONTH)>7 || diff.get(Calendar.MONTH)>1) {
					reduction.setEnabled(true);
				} else {
					reduction.setEnabled(false);
				}
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
