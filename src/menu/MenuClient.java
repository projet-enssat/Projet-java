package menu;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.Document;

import client.Client;
import client.GestionClient;

public class MenuClient extends Menu {
	
	private static JTextField adresse;
	private static JTextField prenom;
	private static JTextField nomClient;
	private static JTextField datePermis = new JTextField();
	private static JTextField dateApprentissage = new JTextField();
	private static JButton validation;
	private static JButton affichage;
	private static GestionClient gestion = new GestionClient();
	
	private static JFrame fenetre;
	private static JList<String> listNom;
	private static JList<String> listPrenom;
	private static JList<String> listAdresse;
	
	private static JScrollPane scrollListNom = new JScrollPane();
	private static JScrollPane scrollListPrenom = new JScrollPane();
	private static JScrollPane scrollListAdresse = new JScrollPane();

	public MenuClient()
	{
		if(listNom == null) {
			listNom = new JList<String>();
			listNom.addListSelectionListener(new ActionClient(this));
		}
		if(listPrenom == null) {
			listPrenom = new JList<String>();
			listPrenom.addListSelectionListener(new ActionClient(this));
		}
		if(listAdresse == null) {
			listAdresse = new JList<String>();
			listAdresse.addListSelectionListener(new ActionClient(this));
		}
		if(nomClient == null) {
			nomClient = new JTextField();
			nomClient.getDocument().addDocumentListener(new ActionClient(this));
		}
		if(prenom == null) {
			prenom = new JTextField();
			prenom.getDocument().addDocumentListener(new ActionClient(this));
		}
		if(adresse == null) {
			adresse = new JTextField();
			adresse.getDocument().addDocumentListener(new ActionClient(this));
		}
		if(affichage == null) {
			affichage = new JButton("Tous");
			affichage.addActionListener(new ActionClient(this));
		}
		if(validation == null) {
			validation = new JButton();
			validation.addActionListener(new ActionClient(this));
		}
		datePermis.setText("");
		dateApprentissage.setText("");
	}
	
	public void autoComp(Object test) {
		String client = (String) test;
		if(client.contains("#")) {
			gestion.select(client);
		}
		nomClient.setText(gestion.getClient().getNom());
		prenom.setText(gestion.getClient().getPrenom());
		adresse.setText(gestion.getClient().getAdresse());
	}
	
	public Document getNomDocument() {
		return nomClient.getDocument();
	}
	
	public Document getPrenomDocument() {
		return prenom.getDocument();
	}
	
	public Document getAdresseDocument() {
		return adresse.getDocument();
	}
	
	public void refreshTous() {
		listNom.setModel(gestion.tous());
		listPrenom.setModel(gestion.tous());
		listAdresse.setModel(gestion.tous());
	}
	
	public void refreshNom() {
		listNom.setModel(gestion.rechercherNom(nomClient.getText()));
	}
	
	public void refreshPrenom() {
		listPrenom.setModel(gestion.rechercherPrenom(prenom.getText()));
	}
	
	public void refreshAdresse() {
		listAdresse.setModel(gestion.rechercherAdresse(adresse.getText()));
	}

	public void recherche() {
		fenetre = new JFrame("Choississez le Client");
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(3,3);
		fenetre.setLayout(grillePrincipale);
		fenetre.add(textFieldLabelLeft("Nom :",nomClient));
		nomClient.addActionListener(new ActionClient(this));
		nomClient.setText("");
		fenetre.add(textFieldLabelLeft("Prenom :",prenom));
		prenom.addActionListener(new ActionClient(this));
		prenom.setText("");
		fenetre.add(textFieldLabelLeft("Adresse :",adresse));
		adresse.addActionListener(new ActionClient(this));
		adresse.setText("");
		listNom.setModel(gestion.rechercherNom(nomClient.getText()));
		listPrenom.setModel(gestion.rechercherPrenom(prenom.getText()));
		listAdresse.setModel(gestion.rechercherAdresse(adresse.getText()));
		scrollListNom = new JScrollPane(listNom,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollListPrenom = new JScrollPane(listPrenom,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollListAdresse = new JScrollPane(listAdresse,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		fenetre.add(scrollListNom);
		fenetre.add(scrollListPrenom);
		fenetre.add(scrollListAdresse);
		validation.setText("Valider");
		fenetre.add(validation);
		fenetre.add(vide());
		fenetre.add(affichage);
		fenetre.setVisible(true);
	}

	public void enregistrement()
	{
		new GestionClient(nomClient.getText(), prenom.getText(), adresse.getText(), dateApprentissage.getText(),
				datePermis.getText()).ajouterClient();
		fenetre.dispose();
	}
		
	public void suppression()
	{
		if(gestion.getClient().getDateApprentissage()!="" && gestion.getClient().getDatePermis()!="") {
			gestion.supprimerClient();
			fenetre.dispose();
		}
	}

	public void affMenu(String nom)
	{
		fenetre = new JFrame(nom);
		fenetre.setBounds(600, 200, 700, 500);
		GridLayout grillePrincipale = new GridLayout(5, 1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1, 2);
		nomPrenom.setLayout(posNomPrenom);
		nomClient.setText("");
		JPanel champNom = textFieldLabelLeft("Nom :", nomClient);
		nomPrenom.add(champNom);
		prenom.setText("");
		nomPrenom.add(textFieldLabelLeft("Prenom :", prenom));
		fenetre.add(nomPrenom);
		adresse.setText("");
		fenetre.add(textFieldLabelLeft("Adresse :", adresse));
		fenetre.add(textFieldLabelLeft("Date du permis :", datePermis));
		fenetre.add(textFieldLabelLeft("Date de fin d'apprentissage :", dateApprentissage));
		validation.addActionListener(new ActionClient(this));
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}

	public void insererclient(Client client)
	{
		adresse.setText(client.getAdresse());
		prenom.setText(client.getPrenom());
		datePermis.setText(client.getDatePermis());
		nomClient.setText(client.getNom());
		dateApprentissage.setText(client.getDateApprentissage());
	}

	public void setValidation(String nomBouton)
	{
		validation.setText(nomBouton);
	}
	
	public JTextField getAdresse() {
		return adresse;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public JTextField getNomClient() {
		return nomClient;
	}

}
