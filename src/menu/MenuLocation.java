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
	private static JCheckBox reduction = new JCheckBox("R�duction");

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
		panelPrenom.add(textFieldLabelAbove(prenomTF, "Pr�nom :"));
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
		panelModele.add(textFieldLabelAbove(modeleTF, "Mod�le :"));
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

		panelLoc.add(textFieldLabelAbove(debutTF, "Date de D�but :"));
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
	
	public void finLocation()
	{
		nouveau = false;
		if (fenetre2 != null) { fenetre2.removeAll(); }
		fenetre2 = new JFrame("Supprimer une location");
		fenetre2.setBounds(400, 400, 1100, 200);
		fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre2.setLayout(new GridLayout(2, 4));

		fenetre2.setVisible(true);
	}
	
	/**
	 * Change le statut des boutons de validation. Utilise lors d'une validation.
	 */
	public void validerClient() {
		validation1.setEnabled(false);
		if(!validation2.isEnabled()) {
			validation3.setEnabled(true);
		}
	}

	/**
	 * Change le statut des boutons de validation. Utilise lors d'une validation.
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
	 * Actualise la liste des adresses, en n'affichant que les clients trouves par rechercheAdresse.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshAdresse() {
		choixAdr.setModel(gestionClient.rechercherAdresse(adresseTF.getText()));
	}
	
	/**
	 * Renvoie choixAdr.
	 * @return JList contenant les adresses.
	 */
	public JList<String> getListAdresse() {
		return choixAdr;
	}

	/**
	 * Actualise la liste des noms, en n'affichant que les clients trouves par rechercheNom.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshNom() {
		choixNom.setModel(gestionClient.rechercherNom(nomTF.getText()));
	}
	
	/**
	 * Renvoie choixNom.
	 * @return JList contenant les noms.
	 */
	public JList<String> getListNom() {
		return choixNom;
	}
	
	/**
	 * Actualise la liste des prenoms, en n'affichant que les clients trouves par rehcerchePrenom.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshPrenom() {
		choixPre.setModel(gestionClient.rechercherPrenom(prenomTF.getText()));
	}
	
	/**
	 * Renvoie choixPre.
	 * @return JList contenant les prenoms.
	 */
	public JList<String> getListPrenom() {
		return choixPre;
	}
	
	/**
	 * Remplit les champs nomTF, prenomTF et adresseTF avec les attributs du client (sous forme de chaine de caracteres) passe en parametre.
	 * @param client Client a inserer.
	 */
	public void autoCompletionClient(String client) {
		if(client.contains("#")) {
			gestionClient.select(client);
		}
		nomTF.setText(gestionClient.getClient().getNom());
		prenomTF.setText(gestionClient.getClient().getPrenom());
		adresseTF.setText(gestionClient.getClient().getAdresse());
	}

	/**
	 * Remplit les champs marqueTF, modeleTF et immatTF avec les attributs du vehicule (sous forme de chaine de caracteres) passe en parametre.
	 * @param vehicule Vehicule a inserer.
	 */
	public void autoCompletionVehicule(String vehicule) {
		gestionVehicule.rechercheVehicule(vehicule);
		immatTF.setText(gestionVehicule.getVehicule().getImmatriculation());
		modeleTF.setText(gestionVehicule.getVehicule().getModele());
		marqueTF.setText(gestionVehicule.getVehicule().getMarque());
		validation2.setEnabled(true);
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
	 * Actualise la liste des immatriculations, en n'affichant que les vehicules trouves par toutesLesImmats.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshImmat() {
		choixImm.setModel(gestionVehicule.toutesLesImmats(null, null, immatTF.getText()));
	}
	
	/**
	 * Renvoie choixImm.
	 * @return JList des immatriculations.
	 */
	public JList<String> getListImmat() {
		return choixImm;
	}
	
	/**
	 * Renvoie la zone d'ecriture du JTextField debutTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getDebutTFDocument() {
		return debutTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField finTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getFinTFDocument() {
		return finTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField nomTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getNomTFDocument() {
		return nomTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField prenomTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getPrenomTFDocument() {
		return prenomTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField adresseTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getAdresseTFDocument() {
		return adresseTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField marqueTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getMarqueTFDocument() {
		return marqueTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField modeleTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getModeleTFDocument() {
		return modeleTF.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField immatTF.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getImmatTFDocument() {
		return immatTF.getDocument();
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
	
}
