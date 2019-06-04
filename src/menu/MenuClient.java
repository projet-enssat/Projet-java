package menu;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;
import client.GestionClient;
import location.GestionLocation;
import location.ListeLocations;

<<<<<<< HEAD
public class MenuClient extends Menu {
	
	private static JTextField adresse = new JTextField();
=======
public class MenuClient extends Menu
{

	private static JTextField adresse = new JTextField("Entrez votre adresse avec code postal et ville");
>>>>>>> branch 'master' of https://github.com/projet-enssat/Projet-java
	private static JTextField prenom = new JTextField();
	private static JTextField nomClient = new JTextField();
	private static JTextField datePermis = new JTextField();
	private static JTextField dateApprentissage = new JTextField();
	private static JButton validation = new JButton();

	public MenuClient()
	{

	}
	
	public void recherche() {
		fenetre = new JFrame("Choississez le Client");
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(3,3);
		fenetre.setLayout(grillePrincipale);
		fenetre.add(textField("Nom :",nomClient));
		fenetre.add(textField("Prenom :",prenom));
		fenetre.add(textField("Adresse :",adresse));
		GestionClient gestion = new GestionClient();
		listNom = gestion.rechercherNom(nomClient.getText());
		listNom.addListSelectionListener(new ActionClient(this));
		listPrenom = gestion.rechercherPrenom(prenom.getText());
		listAdresse = gestion.rechercherAdresse(adresse.getText());
		fenetre.add(listNom);
		fenetre.add(listPrenom);
		fenetre.add(listAdresse);
		fenetre.add(vide());
		validation.setText("Valider");
		fenetre.add(validation);
		fenetre.setVisible(true);

	public void enregistrement()
	{
		new GestionClient(nomClient.getText(), prenom.getText(), adresse.getText(), dateApprentissage.getText(),
				datePermis.getText()).ajouterClient();
	}
	
	public void enregistrement() {
		new GestionClient(nomClient.getText(),prenom.getText(),adresse.getText(),
						  dateApprentissage.getText(), datePermis.getText()).ajouterClient();
	}
	
	public void affMenu(String nom) {
		
=======

	public void affMenu(String nom)
	{

>>>>>>> branch 'master' of https://github.com/projet-enssat/Projet-java
		JFrame fenetre = new JFrame(nom);
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

}
