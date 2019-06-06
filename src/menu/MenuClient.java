package menu;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;
import client.GestionClient;

public class MenuClient extends Menu {
	
	private static JTextField adresse = new JTextField();
	private static JTextField prenom = new JTextField();
	private static JTextField nomClient = new JTextField();
	private static JTextField datePermis = new JTextField();
	private static JTextField dateApprentissage = new JTextField();
	private static JButton validation = new JButton();
	private static JButton affichage = new JButton("Tous");
	private static GestionClient gestion = new GestionClient();
	
	private static JFrame fenetre;
	private static JList<String> listNom = new JList<String>();
	private static JList<String> listPrenom = new JList<String>();
	private static JList<String> listAdresse = new JList<String>();

	public MenuClient()
	{
		listNom.addListSelectionListener(new ActionClient(this));
	}
	
	public void autoComp(Object test) {
		String client = (String) test;
		if(client.contains(" ")) {
			gestion.select(client);
		}
	}
	
	public void refreshTous() {
		listNom.setModel(gestion.tousNom());
		listPrenom.setModel(gestion.tousPrenom());
		listAdresse.setModel(gestion.tousAdresse());
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
		fenetre.add(textField("Nom :",nomClient));
		nomClient.addActionListener(new ActionClient(this));
		nomClient.setText("");
		fenetre.add(textField("Prenom :",prenom));
		prenom.addActionListener(new ActionClient(this));
		prenom.setText("");
		fenetre.add(textField("Adresse :",adresse));
		adresse.addActionListener(new ActionClient(this));
		adresse.setText("");
		listNom.setModel(gestion.rechercherNom(nomClient.getText()));
		listPrenom.setModel(gestion.rechercherPrenom(prenom.getText()));
		listAdresse.setModel(gestion.rechercherAdresse(adresse.getText()));
		fenetre.add(listNom);
		fenetre.add(listPrenom);
		fenetre.add(listAdresse);
		validation.setText("Valider");
		fenetre.add(validation);
		fenetre.add(vide());
		affichage.addActionListener(new ActionClient(this));
		fenetre.add(affichage);
		fenetre.setVisible(true);
	}

	public void enregistrement()
	{
		new GestionClient(nomClient.getText(), prenom.getText(), adresse.getText(), dateApprentissage.getText(),
				datePermis.getText()).ajouterClient();
		fenetre.dispose();
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
		JPanel champNom = textField("Nom :", nomClient);
		nomPrenom.add(champNom);
		nomPrenom.add(textField("Prenom :", prenom));
		fenetre.add(nomPrenom);
		fenetre.add(textField("Adresse :", adresse));
		fenetre.add(textField("Date du permis :", datePermis));
		fenetre.add(textField("Date de fin d'apprentissage :", dateApprentissage));
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
