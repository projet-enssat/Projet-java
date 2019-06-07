package menu;

import java.awt.GridLayout;
import java.io.IOException;

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
			nomClient.setText("");
			nomClient.getDocument().addDocumentListener(new ActionClient(this));
		}
		if(prenom == null) {
			prenom = new JTextField();
			prenom.setText("");
			prenom.getDocument().addDocumentListener(new ActionClient(this));
		}
		if(adresse == null) {
			adresse = new JTextField();
			adresse.setText("");
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
	
	/**
	 * Complete les champs nom, prenom et adresse du client lors de la selection.
	 * @param test Chaine de caractere representant un client.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void autoCompletion(String test) {
		if(test.contains("#")) {
			gestionClient.select(test);
		}
		nomClient.setText("WUT");//gestionClient.getClient().getNom());
		prenom.setText(gestionClient.getClient().getPrenom());
		adresse.setText(gestionClient.getClient().getAdresse());
	}
	
	/**
	 * Renvoie la zone d'ecriture du JTextField nomClient.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getNomDocument() {
		return nomClient.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField prenom.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getPrenomDocument() {
		return prenom.getDocument();
	}

	/**
	 * Renvoie la zone d'ecriture du JTextField adresse.
	 * @return Un Document, declenchant un evenement lors de l'ecriture dans le JTextField.
	 */
	public Document getAdresseDocument() {
		return adresse.getDocument();
	}

	/**
	 * Remplace les modeles des listes de noms, prenoms et adresses, pour qu'elles affichent tous les clients enregistres.
	 */
	public void refreshTous() {
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
		
		listNom.setModel(gestionClient.rechercherNom(""));
		listPrenom.setModel(gestionClient.rechercherPrenom(""));
		listAdresse.setModel(gestionClient.rechercherAdresse(""));
		
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
	}
	
	/**
	 * Actualise la liste des noms, en n'affichant que les clients trouves par rechercheNom.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshNom() {
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
		listNom.setModel(gestionClient.rechercherNom(nomClient.getText()));
		((ActionClient) listNom.getListSelectionListeners()[0]).toggle();
	}
	
	/**
	 * Actualise la liste des prenoms, en n'affichant que les clients trouves par rehcerchePrenom.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshPrenom() {
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
		listPrenom.setModel(gestionClient.rechercherPrenom(prenom.getText()));
		((ActionClient) listPrenom.getListSelectionListeners()[0]).toggle();
	}
	
	/**
	 * Actualise la liste des adresses, en n'affichant que les clients trouves par rechercheAdresse.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void refreshAdresse() {
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
		listAdresse.setModel(gestionClient.rechercherAdresse(adresse.getText()));
		((ActionClient) listAdresse.getListSelectionListeners()[0]).toggle();
	}

	/**
	 * Affiche la fenetre de suppression de client.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void recherche() {
		fenetre = new JFrame("Choississez le Client");
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(3,3);
		fenetre.setLayout(grillePrincipale);
		fenetre.add(textFieldLabelLeft("Nom :", nomClient));
		fenetre.add(textFieldLabelLeft("Prenom :", prenom));
		fenetre.add(textFieldLabelLeft("Adresse :", adresse));
		listNom.setModel(gestionClient.rechercherNom(nomClient.getText()));
		listPrenom.setModel(gestionClient.rechercherPrenom(prenom.getText()));
		listAdresse.setModel(gestionClient.rechercherAdresse(adresse.getText()));
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
		if(gestionClient.getClient().getDateApprentissage()!="" && gestionClient.getClient().getDatePermis()!="") {
			gestionClient.supprimerClient();
			fenetre.dispose();
		}
	}

	/**
	 * Affiche la fenetre d'enregistrement de nouveau client.
	 * @param nom Titre de la fenetre.
	 */
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

}
