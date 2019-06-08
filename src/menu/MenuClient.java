package menu;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import action.ActionClient;
import client.Client;
import client.GestionClient;

/**
 * Classe d'affichage des fenetres concernant les clients.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class MenuClient extends Menu
{
	/** Acces a l'archive "clients". */
	private static GestionClient gestionClient = new GestionClient("", "", "", "", "");
	
	/** Element graphique */
	private static JTextField adresse;
	/** Element graphique */
	private static JTextField prenom;
	/** Element graphique */
	private static JTextField nomClient;
	/** Element graphique */
	private static JTextField datePermis = new JTextField();
	/** Element graphique */
	private static JTextField dateApprentissage = new JTextField();
	/** Element graphique */
	private static JButton validation;
	/** Element graphique */
	private static JButton affichage;

	/** Element graphique */
	private static JFrame fenetre;
	/** Element graphique */
	private static JList<String> listNom;
	/** Element graphique */
	private static JList<String> listPrenom;
	/** Element graphique */
	private static JList<String> listAdresse;

	/** Element graphique */
	private static JScrollPane scrollListNom = new JScrollPane();
	/** Element graphique */
	private static JScrollPane scrollListPrenom = new JScrollPane();
	/** Element graphique */
	private static JScrollPane scrollListAdresse = new JScrollPane();

	/**
	 * Constructeur et initialisateur des elements Swing.
	 */
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
		nomClient.setText("");
		prenom.setText("");
		adresse.setText("");
		datePermis.setText("");
		dateApprentissage.setText("");
	}
	
	/**
	 * Ouvre une fenêtre permettant de modifier les champ d'un client.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void modification() {
		boolean estClient = false;
		if(gestionClient.EstClient() && gestionClient.getClient().getNom() == nomClient.getText() && gestionClient.getClient().getPrenom() == prenom.getText() && gestionClient.getClient().getAdresse() == adresse.getText()) {
			estClient = true;
		}else {
			Client client = gestionClient.getClient();
			client.setNom(nomClient.getText());
			client.setAdresse(adresse.getText());
			client.setPrenom(prenom.getText());
			gestionClient.setClient(client);
			if(gestionClient.EstClient()) {
				estClient = true;
			}else {
				Erreur("Erreur de Modification Client","Ce que vous voulez modifier n'est pas un client", "Fermez la fenêtre puis verifier le client");
			}
		}if(estClient) {
			fenetre.dispose();
			validation.setText("Modifier");
			affMenu("Modifier le Client selectionner");
			nomClient.setText(gestionClient.getClient().getNom());
			prenom.setText(gestionClient.getClient().getPrenom());
			adresse.setText(gestionClient.getClient().getAdresse());
			dateApprentissage.setText(gestionClient.getClient().getDateApprentissage());
			datePermis.setText(gestionClient.getClient().getDatePermis());
		}
	}
	
	/**
	 * Enregistre les modification des champs d'un client
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void validation() {
		if(nomClient.getText()!=gestionClient.getClient().getNom()
				|| prenom.getText()!=gestionClient.getClient().getPrenom()
				|| adresse.getText()!=gestionClient.getClient().getAdresse()
				|| dateApprentissage.getText()!=gestionClient.getClient().getDateApprentissage()
				|| datePermis.getText()!=gestionClient.getClient().getDatePermis()) {
			gestionClient.supprimerClient();
			gestionClient.setClient(nomClient.getText(),prenom.getText(),adresse.getText(),dateApprentissage.getText(),datePermis.getText());
			gestionClient.ajouterClient();
		}
		fenetre.dispose();
	}
	
	/**
	 * Complete les champs nom, prenom et adresse du client lors de la selection.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void autoCompletion()
	{
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
		
		listNom.setModel(gestionClient.rechercherNom(nomClient.getText()));
		listPrenom.setModel(gestionClient.rechercherPrenom(nomClient.getText(), prenom.getText()));
		listAdresse.setModel(gestionClient.rechercherAdresse(nomClient.getText(), prenom.getText(), adresse.getText()));
		
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
	}
	
	/**
	 * Affiche tous les clients enregistres.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshTous()
	{
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
		
		listNom.setModel(gestionClient.rechercherNom(""));
		listPrenom.setModel(gestionClient.rechercherPrenom(null, ""));
		listAdresse.setModel(gestionClient.rechercherAdresse(null, null, ""));
		
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
	}

	/**
	 * Affiche la fenetre de suppression de client.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void recherche() {
		fenetre = new JFrame("Choississez le Client");
		fenetre.setBounds(450,200,800,500);
		GridLayout grillePrincipale = new GridLayout(3,3);
		fenetre.setLayout(grillePrincipale);
		fenetre.add(textFieldLabelAbove(nomClient, "Nom :"));
		fenetre.add(textFieldLabelAbove(prenom, "Prenom :"));
		fenetre.add(textFieldLabelAbove(adresse, "Adresse :"));
		listNom.setModel(gestionClient.rechercherNom(""));
		listPrenom.setModel(gestionClient.rechercherPrenom(null, ""));
		listAdresse.setModel(gestionClient.rechercherAdresse(null, null, ""));
		scrollListNom = new JScrollPane(listNom,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollListPrenom = new JScrollPane(listPrenom,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollListAdresse = new JScrollPane(listAdresse,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollListNom.setPreferredSize(new Dimension(200, 140));
		scrollListPrenom.setPreferredSize(new Dimension(200, 140));
		scrollListAdresse.setPreferredSize(new Dimension(200, 140));
		fenetre.add(jspV(scrollListNom));
		fenetre.add(jspV(scrollListPrenom));
		fenetre.add(jspV(scrollListAdresse));
		fenetre.add(bouton(validation));
		fenetre.add(vide());
		fenetre.add(bouton(affichage));
		fenetre.setVisible(true);
	}

	/**
	 * Enregistre un client dans l'archive "clients" et ferme la fenetre d'enregistrement.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void enregistrement()
	{
		new GestionClient(nomClient.getText(), prenom.getText(), adresse.getText(), dateApprentissage.getText(),
				datePermis.getText()).ajouterClient();
		fenetre.dispose();
	}
	
	/**
	 * Supprime un client de l'archive "clients" et ferme la fenetre de suppression.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void suppression()
	{
		if(gestionClient.EstClient() && gestionClient.getClient().getNom() == nomClient.getText() && gestionClient.getClient().getPrenom() == prenom.getText() && gestionClient.getClient().getAdresse() == adresse.getText()) {
			gestionClient.supprimerClient();
			fenetre.dispose();
		}else {
			Client client = gestionClient.getClient();
			client.setNom(nomClient.getText());
			client.setAdresse(adresse.getText());
			client.setPrenom(prenom.getText());
			gestionClient.setClient(client);
			if(gestionClient.EstClient()) {
				gestionClient.supprimerClient();
				fenetre.dispose();
			}else {
				Erreur("Erreur de Suppression Client","Ce que vous voulez effacez n'est pas un client", "Fermez la fenêtre puis verifier le client");
			}
		}
	}

	/**
	 * Affiche la fenetre d'enregistrement de nouveau client.
	 * @param nom Titre de la fenetre.
	 */
	public void affMenu(String nom)
	{
		fenetre = new JFrame(nom);
		fenetre.setBounds(450, 200, 400, 400);
		GridLayout grillePrincipale = new GridLayout(5, 1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1, 2);
		nomPrenom.setLayout(posNomPrenom);
		nomClient.setText("");
		JPanel champNom = textFieldLabelAbove(nomClient, "Nom :");
		nomPrenom.add(champNom);
		prenom.setText("");
		nomPrenom.add(textFieldLabelAbove(prenom, "Prenom :"));
		fenetre.add(nomPrenom);
		adresse.setText("");
		fenetre.add(textFieldLabelAbove(adresse, "Adresse :"));
		datePermis.setText("");
		fenetre.add(textFieldLabelAbove(datePermis, "Date du permis :"));
		dateApprentissage.setText("");
		fenetre.add(textFieldLabelAbove(dateApprentissage, "Date de fin d'apprentissage :"));
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}

	/**
	 * Remplit les champs avec les attributs du client passe en parametre.
	 * @param client Client a inserer.
	 */
	public void insererclient(Client client)
	{
		adresse.setText(client.getAdresse());
		prenom.setText(client.getPrenom());
		datePermis.setText(client.getDatePermis());
		nomClient.setText(client.getNom());
		dateApprentissage.setText(client.getDateApprentissage());
	}

	/**
	 * Donne un nom au bouton de validation.
	 * @param nomBouton Nom du JButton validation.
	 */
	public void setValidation(String nomBouton)
	{
		validation.setText(nomBouton);
	}
	
	/**
	 * Renvoie adresse.
	 * @return Le JTextField de saisie d'adresse.
	 */
	public JTextField getAdresse() {
		return adresse;
	}

	/**
	 * Renvoie prenom.
	 * @returnLe JTextField de saisie de prenom.
	 */
	public JTextField getPrenom() {
		return prenom;
	}

	/**
	 * Renvoie nomClient.
	 * @return Le JTextField de saisie de nom.
	 */
	public JTextField getNomClient() {
		return nomClient;
	}

	/**
	 * Renvoie listNom.
	 * @return La JList de selection de nom.
	 */
	public JList<String> getListNom()
	{
		return listNom;
	}

	/**
	 * Renvoie listPrenom.
	 * @return La JList de selection de prenom.
	 */
	public JList<String> getListPrenom()
	{
		return listPrenom;
	}

	/**
	 * Renvoie listAdresse.
	 * @return La JList de selection d'adresse.
	 */
	public JList<String> getListAdresse()
	{
		return listAdresse;
	}
}
