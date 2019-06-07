package menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import action.ActionVehicule;
import client.GestionClient;
import vehicule.Avion;
import vehicule.GestionVehicule;
import vehicule.Moto;
import vehicule.Voiture;

/**
 * Classe d'affichage des fenetres concernant les vehicules.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class MenuVehicule extends Menu
{
	/** Element graphique */
	private static JTextField modele = new JTextField();
	/** Element graphique */
	private static JTextField etat = new JTextField();
	/** Element graphique */
	private static JTextField prixJour = new JTextField();
	/** Element graphique */
	private static JTextField marque = new JTextField();
	/** Element graphique */
	private static JTextField immat = new JTextField();
	/** Element graphique */
	private static JTextField vitesse = new JTextField();
	/** Element graphique */
	private static JTextField nbHeuresVol = new JTextField();
	/** Element graphique */
	private static JTextField nbMoteurs = new JTextField();
	/** Element graphique */
	private static JTextField km = new JTextField();
	/** Element graphique */
	private static JTextField puissance = new JTextField();
	/** Element graphique */
	private static JTextField nbPlaces = new JTextField();
	/** Element graphique */
	private static JButton validation1;
	/** Element graphique */
	private static JButton validation2;
	/** Element graphique */
	private static JButton validation3;
	/** Element graphique */
	private static JButton validation4;
	/** Element graphique */
	private static JButton ok;
	/** Element graphique */
	private static JComboBox<String> choixV;
	/** Element graphique */
	private static JTextField texteMar;
	/** Element graphique */
	private static JTextField texteMod;
	/** Element graphique */
	private static JTextField texteImm;
	/** Element graphique */
	private static JList<String> choixMar;
	/** Element graphique */
	private static JList<String> choixMod;
	/** Element graphique */
	private static JList<String> choixImm;
	/** Element graphique */
	private static JFrame fenetre;
	/** Element graphique */
	private static JFrame fenetre2;
	/** Element graphique */
	private static JFrame fenetre3;
	/** Element graphique */
	private static JPanel infoVehicule = new JPanel();
	
	/** Acces a l'archive "vehicules". */
	GestionVehicule gestionVehicule = new GestionVehicule();
	
	/** Indique quelle fenetre est ouverte. */
	private static boolean nouveau = true;

	/**
	 * Constructeur et initialisateur des elements Swing.
	 */
	public MenuVehicule()
	{
		if (validation1 == null)
		{
			validation1 = new JButton("Enregistrer");
			validation1.addActionListener(new ActionVehicule(this));
		}
		
		if (validation2 == null)
		{
			validation2 = new JButton("Supprimer");
			validation2.addActionListener(new ActionVehicule(this));
		}
		
		if (validation3 == null)
		{
			validation3 = new JButton("Rechercher");
			validation3.addActionListener(new ActionVehicule(this));
		}
		
		if (validation4 == null)
		{
			validation4 = new JButton("Modifier");
			validation4.addActionListener(new ActionVehicule(this));
		}
		
		if (ok == null)
		{
			ok = new JButton("OK");
			ok.addActionListener(new ActionVehicule(this));
		}
		
		if (choixV == null)
		{
			choixV = new JComboBox<String>();
			choixV.addItem("");
			choixV.addItem("Voiture");
			choixV.addItem("Moto");
			choixV.addItem("Avion");
			choixV.addActionListener(new ActionVehicule(this));
		}
		choixV.setSelectedIndex(0);

		if (choixMod == null)
		{
			choixMod = new JList<String>();
			choixMod.setModel(new GestionVehicule().tousLesModeles(null, ""));
			choixMod.setPreferredSize(new Dimension(150, 100));
			choixMod.addListSelectionListener(new ActionVehicule(this));
		}

		if (choixMar == null)
		{
			choixMar = new JList<String>();
			choixMar.setModel(new GestionVehicule().toutesLesMarques(""));
			choixMar.setPreferredSize(new Dimension(150, 100));
			choixMar.addListSelectionListener(new ActionVehicule(this));
		}
		
		if (choixImm == null)
		{
			choixImm = new JList<String>();
			choixImm.setModel(new GestionVehicule().toutesLesImmats(null, null, ""));
			choixImm.setPreferredSize(new Dimension(200, 100));
			choixImm.addListSelectionListener(new ActionVehicule(this));
		}
		
		if (texteMar == null)
		{
			texteMar = new JTextField();
			texteMar.getDocument().addDocumentListener(new ActionVehicule(this));
		}
		texteMar.setText("");
		
		if (texteMod == null)
		{
			texteMod = new JTextField();
			texteMod.getDocument().addDocumentListener(new ActionVehicule(this));
		}
		texteMod.setText("");
		
		if (texteImm == null)
		{
			texteImm = new JTextField();
			texteImm.getDocument().addDocumentListener(new ActionVehicule(this));
		}
		texteImm.setText("");
	}

	/**
	 * Enregistre un vehicule dans le fichier d'archive "vehicules".
	 * @param classe Classe du vehicule a enregistrer.
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void enregistrement(String classe)
	{
		Float prix = new Float(prixJour.getText());
		Integer vit;
		if(vitesse.getText().contains(".")) {
			vit = new Integer(vitesse.getText().substring(0,vitesse.getText().indexOf(".")));
		}else {
			vit = new Integer(vitesse.getText());
		}
		switch (classe)
		{
			case "Voiture":
				Float k = new Float(km.getText());
				Integer puis ;
				if(puissance.getText().contains(".")) {
					puis = new Integer(puissance.getText().substring(0,puissance.getText().indexOf(".")));
				}else {
					puis = new Integer(puissance.getText());
				}
				Integer pla ;
				if(nbPlaces.getText().contains(".")) {
					pla = new Integer(nbPlaces.getText().substring(0,nbPlaces.getText().indexOf(".")));
				}else {
					pla = new Integer(nbPlaces.getText());
				}
				new GestionVehicule(classe, modele.getText(), etat.getText(), prix, marque.getText(), immat.getText(),
						vit, k, puis, pla).ajouterVehicule();
				break;
			case "Moto":
				Float k2 = new Float(km.getText());
				Integer puis2 ;
				if(puissance.getText().contains(".")) {
					puis2 = new Integer(puissance.getText().substring(0,puissance.getText().indexOf(".")));
				}else {
					puis2 = new Integer(puissance.getText());
				}
				new GestionVehicule(classe, modele.getText(), etat.getText(), prix, marque.getText(), immat.getText(),
						vit, puis2, k2).ajouterVehicule();
				break;
			case "Avion":
				Integer nbmot ;
				if(nbMoteurs.getText().contains(".")) {
					nbmot = new Integer(nbMoteurs.getText().substring(0,nbMoteurs.getText().indexOf(".")));
				}else {
					nbmot = new Integer(nbMoteurs.getText());
				}
				Float nbheu = new Float(nbHeuresVol.getText());
				new GestionVehicule(classe, modele.getText(), etat.getText(), prix, marque.getText(), immat.getText(),
						vit, nbheu, nbmot).ajouterVehicule();
				break;
		}
	}
	
	/**
	 * Supprime un vehicule de l'archive "vehicule", en recherchant son immatriculation.
	 * @param classe Classe du vehicule (peut etre laissee vide).
	 * @throws IOException, ClassNotFoundException, FileNotFoundException, EOFException
	 */
	public void suppression(String classe)
	{
		GestionVehicule tempGV = new GestionVehicule(classe);
		tempGV.rechercheVehicule(texteImm.getText());
		tempGV.supprimerVehicule();
	}

	/**
	 * Affiche la fenetre d'enregistrement de vehicule.
	 * @param nom Titre de la fenetre
	 */
	public void affMenu(String nom)
	{
		if (fenetre != null) { fenetre.removeAll(); }
		fenetre = new JFrame(nom);
		fenetre.setBounds(400,200,1100,500);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		infoVehicule.removeAll();
		infoVehicule = new JPanel();
		fenetre.setLayout(new GridLayout(2, 1));
		infoVehicule.setLayout(new GridLayout(3, 3));
		addGeneralTextFields();
	}

	/**
	 * Affiche le choix du type de vehicule pour l'enregistrement.
	 */
	public void nouveauVehicule()
	{
		nouveau = true;
		if (fenetre2 != null) { fenetre2.removeAll(); }
		fenetre2 = new JFrame("Nouveau vehicule");
		fenetre2.setBounds(800, 400, 400, 100);
		fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre2.setLayout(new FlowLayout());

		fenetre2.add(comboBoxV(choixV));
		ok.setEnabled(false);
		ok.setText("OK");
		fenetre2.add(bouton(ok));
		fenetre2.setVisible(true);
	}
	
	/**
	 * Resst les valeurs déjà entrez dans les JTextField.
	 */
	public void reset() {
		texteMar.setText("");
		texteMod.setText("");
		texteImm.setText("");
	}

	/**
	 * Affiche la fenetre de selection de vehicule à modifier.
	 */
	public void modifier()
	{
		gestionVehicule.setVehicule(null);
		gestionVehicule.rechercheVehicule(texteImm.getText().toLowerCase());
		if (!(gestionVehicule.getVehicule() == null))
		{
			fenetre3.dispose();
			String classV = gestionVehicule.getVehicule().getClass().toString();
			String classe = classV.substring(classV.indexOf(".")+1);
			switch (classe)
			{
				case "Voiture":
					modvoiture("Modifier Voiture");
					Voiture voit = (Voiture) gestionVehicule.getVehicule();
					km.setText(voit.getKm().toString());
					puissance.setText(new Float(voit.getPuissance()).toString());
					nbPlaces.setText(new Float(voit.getNbPlace()).toString());
					break;
				case "Moto":
					modmoto("Modifier Moto");
					Moto mot = (Moto) gestionVehicule.getVehicule();
					km.setText(mot.getKm().toString());
					puissance.setText(new Float(mot.getPuissance()).toString());
					break;
				case "Avion":
					modavion("Modifier Avion");
					Avion avi = (Avion) gestionVehicule.getVehicule();
					nbHeuresVol.setText(avi.getNbHeureVol().toString());
					nbMoteurs.setText(new Float(avi.getNbMoteur()).toString());
					break;
				default:
					break;
			}
			modele.setText(gestionVehicule.getVehicule().getModele());
			marque.setText(gestionVehicule.getVehicule().getMarque());
			immat.setText(gestionVehicule.getVehicule().getImmatriculation());
			etat.setText(gestionVehicule.getVehicule().getEtat());
			prixJour.setText(gestionVehicule.getVehicule().getPrixJour().toString());
			vitesse.setText(new Float(gestionVehicule.getVehicule().getVitesse()).toString());
		} else {
			Erreur("Erreur de selection Vehicule","Le Vehicule que vous avez selectionne n'existe pas", "Fermez la fenetre puis recommencez");
		}
	}
	
	/**
	 * Enregistre les modifictaion apporter et ferme la fenêtre
	 */
	public void enregistrerMod() {
		String classV = gestionVehicule.getVehicule().getClass().toString();
		String classe = classV.substring(classV.indexOf(".")+1);
		switch (classe)
		{
			case "Voiture":
				Voiture voit = (Voiture) gestionVehicule.getVehicule();
				if(immat.getText()!=voit.getImmatriculation()
						|| marque.getText()!=voit.getMarque()
						|| modele.getText()!=voit.getModele()
						|| etat.getText()!=voit.getEtat()
						|| prixJour.getText()!=voit.getPrixJour().toString()
						|| vitesse.getText()!=new Float(voit.getVitesse()).toString()
						|| km.getText()!=voit.getKm().toString()
						|| nbPlaces.getText()!=new Float(voit.getNbPlace()).toString()) {
					gestionVehicule.supprimerVehicule();
					enregistrement(classe);
				}
				break;
			case "Moto":
				Moto mot = (Moto) gestionVehicule.getVehicule();
				if(immat.getText()!=mot.getImmatriculation()
						|| marque.getText()!=mot.getMarque()
						|| modele.getText()!=mot.getModele()
						|| etat.getText()!=mot.getEtat()
						|| prixJour.getText()!=mot.getPrixJour().toString()
						|| vitesse.getText()!=new Float(mot.getVitesse()).toString()
						|| km.getText()!=mot.getKm().toString()) {
					gestionVehicule.supprimerVehicule();
					enregistrement(classe);
				}
				break;
			case "Avion":
				Avion avi = (Avion) gestionVehicule.getVehicule();
				if(immat.getText()!=avi.getImmatriculation()
						|| marque.getText()!=avi.getMarque()
						|| modele.getText()!=avi.getModele()
						|| etat.getText()!=avi.getEtat()
						|| prixJour.getText()!=avi.getPrixJour().toString()
						|| vitesse.getText()!=new Float(avi.getVitesse()).toString()
						|| nbMoteurs.getText()!=new Float(avi.getNbMoteur()).toString()
						|| nbHeuresVol.getText()!= avi.getNbHeureVol().toString()) {
					gestionVehicule.supprimerVehicule();
					enregistrement(classe);
				}
				break;
			default:
				break;
		}
		fenetre.dispose();
	}
	
	/**
	 * Affiche la fenetre de selection de vehicule à modifier.
	 */
	public void modifierVehicule()
	{
		nouveau = false;
		if (fenetre3 != null) { fenetre3.removeAll(); }
		fenetre3 = new JFrame("Selectionner vehicule à modifier");
		fenetre3.setBounds(400, 400, 1100, 200);
		fenetre3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre3.setLayout(new GridLayout(2, 4));
		fenetre3.add(comboBoxV2(choixV));
		fenetre3.add(textFieldLabelAbove(texteMar, "Marque :"));
		fenetre3.add(textFieldLabelAbove(texteMod, "Modèle :"));
		fenetre3.add(textFieldLabelAbove(texteImm, "Immatriculation :"));
		
		fenetre3.add(bouton(validation3));
		fenetre3.add(listV(choixMar));
		fenetre3.add(listV(choixMod));
		fenetre3.add(listV(choixImm));
		fenetre3.setVisible(true);
	}
	
	/**
	 * Affiche la fenetre de suppression de vehicule.
	 */
	public void supprimerVehicule()
	{
		nouveau = false;
		if (fenetre3 != null) { fenetre3.removeAll(); }
		fenetre3 = new JFrame("Supprimer vehicule");
		fenetre3.setBounds(400, 400, 1100, 200);
		fenetre3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre3.setLayout(new GridLayout(2, 4));

		fenetre3.add(comboBoxV2(choixV));
		fenetre3.add(textFieldLabelAbove(texteMar, "Marque :"));
		fenetre3.add(textFieldLabelAbove(texteMod, "Modèle :"));
		fenetre3.add(textFieldLabelAbove(texteImm, "Immatriculation :"));
		fenetre3.add(bouton(validation2));
		fenetre3.add(listV(choixMar));
		fenetre3.add(listV(choixMod));
		fenetre3.add(listV(choixImm));
		fenetre3.setVisible(true);
	}
	
	/**
	 * Affiche la fenetre de modification de voiture.
	 * @param nom Titre de la fenetre.
	 */
	public void modvoiture(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Compteur", km));
		infoVehicule.add(textFieldLabelLeft("Puissance", puissance));
		infoVehicule.add(textFieldLabelLeft("Places", nbPlaces));
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation4));
		fenetre.setVisible(true);
	}

	/**
	 * Affiche la fenetre de creation de voiture.
	 * @param nom Titre de la fenetre.
	 */
	public void voiture(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Compteur", km));
		infoVehicule.add(textFieldLabelLeft("Puissance", puissance));
		infoVehicule.add(textFieldLabelLeft("Places", nbPlaces));
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation1));
		fenetre.setVisible(true);
	}

	/**
	 * Affiche la fenetre de modification de moto.
	 * @param nom Titre de la fenetre.
	 */
	public void modmoto(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Compteur", km));
		infoVehicule.add(textFieldLabelLeft("Puissance", puissance));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation4));
		fenetre.setVisible(true);
	}
	
	/**
	 * Affiche la fenetre de creation de moto.
	 * @param nom Titre de la fenetre.
	 */
	public void moto(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Compteur", km));
		infoVehicule.add(textFieldLabelLeft("Puissance", puissance));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation1));
		fenetre.setVisible(true);
	}
	
	/**
	 * Affiche la fenetre de modifictaion d'avion.
	 * @param nom Titre de la fenetre.
	 */
	public void modavion(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Heures de vol", nbHeuresVol));
		infoVehicule.add(textFieldLabelLeft("Nombre de moteurs", nbMoteurs));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation4));
		fenetre.setVisible(true);
	}


	/**
	 * Affiche la fenetre de creation d'avion.
	 * @param nom Titre de la fenetre.
	 */
	public void avion(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Heures de vol", nbHeuresVol));
		infoVehicule.add(textFieldLabelLeft("Nombre de moteurs", nbMoteurs));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation1));
		fenetre.setVisible(true);
	}

	/**
	 * Champs d'ecriture communs a tous les types de vehicule.
	 */
	private void addGeneralTextFields()
	{
		infoVehicule.add(textFieldLabelLeft("Modèle", modele));
		infoVehicule.add(textFieldLabelLeft("Etat", etat));
		infoVehicule.add(textFieldLabelLeft("Prix par jour", prixJour));
		infoVehicule.add(textFieldLabelLeft("Marque", marque));
		infoVehicule.add(textFieldLabelLeft("Immatriculation", immat));
		infoVehicule.add(textFieldLabelLeft("Vitesse", vitesse));
	}
	
	/**
	 * Affiche dans les listes de marques, modeles et immatriculations les resultats correspondant au texte entre.
	 * @throws IOException, ClassNotFoundException, EOFException
	 */
	public void autoCompletion()
	{
		((ActionVehicule) choixMar.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixMod.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixImm.getListSelectionListeners()[0]).toggle();
		
		GestionVehicule tempGV = new GestionVehicule((String) choixV.getSelectedItem());
		setChoixMar(tempGV.toutesLesMarques(texteMar.getText()));
		setChoixMod(tempGV.tousLesModeles(texteMar.getText(), texteMod.getText()));
		setChoixImm(tempGV.toutesLesImmats(texteMar.getText(), texteMod.getText(), texteImm.getText()));

		((ActionVehicule) choixMar.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixMod.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixImm.getListSelectionListeners()[0]).toggle();
	}

	/**
	 * Supprime le vehicule dont l'immatriculation a ete entree s'il existe, renvoie une alerte sinon.
	 * @param classe Classe du vehicule a supprimer.
	 */
	public void validerVehicule(String classe)
	{
		GestionVehicule tempGV = new GestionVehicule("");
		tempGV.setVehicule(null);
		tempGV.rechercheVehicule(texteImm.getText().toLowerCase());
		if (!(tempGV.getVehicule() == null))
		{
			suppression(classe);
			fenetre3.dispose();
		} else {
			Erreur("Erreur de selection Vehicule","Le Vehicule que vous avez selectionne n'existe pas", "Fermez la fenetre puis recommencez");
		}
	}
	
	/**
	 * Renvoie fenetre.
	 * @return JFrame pour l'enregistrement de vehicule.
	 */
	public JFrame getFenetre()
	{
		return fenetre;
	}

	/**
	 * Renvoie fenetre2.
	 * @return JFrame pour le choix du type de vehicule.
	 */
	public JFrame getFenetre2()
	{
		return fenetre2;
	}

	/**
	 * Renvoie fenetre3.
	 * @return JFrame pour la suppression de vehicule.
	 */
	public JFrame getFenetre3()
	{
		return fenetre3;
	}

	/**
	 * Renvoie choixV.
	 * @return JComboBox pour le choix du type de vehicule.
	 */
	public JComboBox<String> getChoixV()
	{
		return choixV;
	}

	/**
	 * Renvoie nouveau.
	 * @return boolean indiquant si la fenetre ouverte est celle d'enregistrement ou non.
	 */
	public boolean isNouveau()
	{
		return nouveau;
	}

	/**
	 * Renvoie validation1.
	 * @return JButton de validation de l'enregistrement.
	 */
	public JButton getEnregistrer()
	{
		return validation1;
	}
	
	/**
	 * Renvoie validation2.
	 * @return JButton de validation de la suppression.
	 */
	public JButton getSupprimer()
	{
		return validation2;
	}
	
	public JButton getModifier()
	{
		return validation4;
	}
	
	public JButton getRechercher()
	{
		return validation3;
	}

	/**
	 * Renvoie ok.
	 * @return JButton de confirmation du choix du type de vehicule.
	 */
	public JButton getOK()
	{
		return ok;
	}

	/**
	 * Renvoie texteMar.
	 * @return JTextField pour la saisie de la marque.
	 */
	public JTextField getTexteMar()
	{
		return texteMar;
	}
	
	/**
	 * Ecrit dans texteMar.
	 * @param texte Texte a ecrire.
	 */
	public void setTexteMar(String texte)
	{
		texteMar.setText(texte);
	}

	/**
	 * Renvoie texteMod.
	 * @return JTextField pour la saisie du modele.
	 */
	public JTextField getTexteMod()
	{
		return texteMod;
	}

	/**
	 * Ecrit dans texteMod.
	 * @param texte Texte a ecrire.
	 */
	public void setTexteMod(String texte)
	{
		texteMod.setText(texte);
	}

	/**
	 * Renvoie texteImm.
	 * @return JTextField pour la saisie de l'immatriculation.
	 */
	public JTextField getTexteImm()
	{
		return texteImm;
	}

	/**
	 * Ecrit dans texteImm.
	 * @param texte Texte a ecrire.
	 */
	public void setTexteImm(String texte)
	{
		texteImm.setText(texte);
	}

	/**
	 * Renvoie choixMar.
	 * @return JList pour la recherche de marques.
	 */
	public JList<String> getChoixMar()
	{
		return choixMar;
	}

	/**
	 * Remplace les elements de choixMar.
	 * @param model Modele de remplacement.
	 */
	public void setChoixMar(ListModel<String> model)
	{
		choixMar.setModel(model);
	}

	/**
	 * Renvoie choixMod.
	 * @return JList pour la recherche de modeles.
	 */
	public JList<String> getChoixMod()
	{
		return choixMod;
	}

	/**
	 * Remplace les elements de choixMod.
	 * @param model Modele de remplacement.
	 */
	public void setChoixMod(ListModel<String> model)
	{
		choixMod.setModel(model);
	}

	/**
	 * Renvoie choixImm.
	 * @return JList pour la recherche d'immatriculations.
	 */
	public JList<String> getChoixImm()
	{
		return choixImm;
	}

	/**
	 * Remplace les elements de choixImm.
	 * @param model Modele de remplacement.
	 */
	public void setChoixImm(ListModel<String> model)
	{
		choixImm.setModel(model);
	}
}
