package menu;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vehicule.GestionVehicule;

public class MenuVehicule extends Menu
{
	public void resetBox()
	{
		choixV.removeAllItems();
		choixV.addItem("");
		choixV.addItem("Voiture");
		choixV.addItem("Moto");
		choixV.addItem("Avion");

		choixMod.removeAll();
		choixMod = new GestionVehicule().tousLesModeles("", "");

		choixMar.removeAll();
		choixMar = new GestionVehicule().toutesLesMarques("");

		choixImm.removeAll();
		choixImm = new GestionVehicule().toutesLesImmats("", "", "");
	}

	private static JTextField modele = new JTextField();
	private static JTextField etat = new JTextField();
	private static JTextField prixJour = new JTextField();
	private static JTextField marque = new JTextField();
	private static JTextField immat = new JTextField();
	private static JTextField vitesse = new JTextField();
	private static JTextField nbHeuresVol = new JTextField();
	private static JTextField nbMoteurs = new JTextField();
	private static JTextField km = new JTextField();
	private static JTextField puissance = new JTextField();
	private static JTextField nbPlaces = new JTextField();
	private static JButton validation = new JButton("Enregistrer");
	private static JButton ok = new JButton("OK");
	private static JComboBox<String> choixV = new JComboBox<String>();
	private static JTextField texteMar = new JTextField();
	private static JTextField texteMod = new JTextField();
	private static JTextField texteImm = new JTextField();
	private static JList<String> choixMar = new JList<String>();
	private static JList<String> choixMod = new JList<String>();
	private static JList<String> choixImm = new JList<String>();
	private static JFrame fenetre;
	private static JFrame fenetre2;
	private static JPanel infoVehicule = new JPanel();
	private static boolean nouveau = true;
	private ActionVehicule choixVAL = new ActionVehicule(this);

	public MenuVehicule()
	{
		resetBox();
	}

	public void enregistrement(String classe)
	{
		Float prix = new Float(prixJour.getText());
		Integer vit = new Integer(vitesse.getText());
		switch (classe)
		{
			case "Voiture":
				Float k = new Float(km.getText());
				Integer puis = new Integer(puissance.getText());
				Integer pla = new Integer(nbPlaces.getText());
				new GestionVehicule(classe, modele.getText(), etat.getText(), prix, marque.getText(), immat.getText(),
						vit, k, puis, pla).ajouterVehicule();
				break;
			case "Moto":
				Float k2 = new Float(km.getText());
				Integer puis2 = new Integer(puissance.getText());
				new GestionVehicule(classe, modele.getText(), etat.getText(), prix, marque.getText(), immat.getText(),
						vit, puis2, k2).ajouterVehicule();
				break;
			case "Avion":
				Integer nbmot = new Integer(nbMoteurs.getText());
				Float nbheu = new Float(nbHeuresVol.getText());
				new GestionVehicule(classe, modele.getText(), etat.getText(), prix, marque.getText(), immat.getText(),
						vit, nbheu, nbmot).ajouterVehicule();
				break;
		}
	}

	public void affMenu(String nom)
	{
		fenetre = null;
		infoVehicule = null;
		fenetre = new JFrame(nom);
		fenetre.setBounds(400, 200, 1100, 500);
		GridLayout grillePrincipale = new GridLayout(2, 1);
		fenetre.setLayout(grillePrincipale);
		GridLayout grilleInfo = new GridLayout(3, 3);
		infoVehicule = new JPanel();
		infoVehicule.setLayout(grilleInfo);
		addGeneralTextFields();
	}

	public void nouveauVehicule()
	{
		fenetre2 = null;
		fenetre2 = new JFrame("Nouveau véhicule");
		fenetre2.setBounds(800, 400, 400, 100);
		FlowLayout layout = new FlowLayout();
		fenetre2.setLayout(layout);

		choixV.addActionListener(new ActionVehicule(this));
		fenetre2.add(comboBoxV(choixV));
		ok.setEnabled(false);
		ok.setText("OK");
		ok.addActionListener(new ActionVehicule(this));
		fenetre2.add(bouton(ok));
		fenetre2.setVisible(true);
		nouveau = true;
	}

	public void supprimerVehicule()
	{
		fenetre2 = new JFrame("Supprimer véhicule");
		fenetre2.setBounds(400, 400, 1100, 200);
		GridLayout layout = new GridLayout(2, 4);
		fenetre2.setLayout(layout);

		
		choixMar.addListSelectionListener(new ActionVehicule(this));
		choixMod.addListSelectionListener(new ActionVehicule(this));
		choixImm.addListSelectionListener(new ActionVehicule(this));
		fenetre2.add(comboBoxV(choixV));
		fenetre2.add(textFieldNoLabel(texteMar));
		fenetre2.add(textFieldNoLabel(texteMod));
		fenetre2.add(textFieldNoLabel(texteImm));
		fenetre2.add(vide());
		fenetre2.add(listV(choixMar));
		fenetre2.add(listV(choixMod));
		fenetre2.add(listV(choixImm));
		fenetre2.setVisible(true);
		nouveau = false;
	}

	public void Voiture(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textField("Compteur", km));
		infoVehicule.add(textField("Puissance", puissance));
		infoVehicule.add(textField("Places", nbPlaces));
		fenetre.add(infoVehicule);
		if (fenetre.getTitle() == "Nouvelle Voiture")
		{
			validation.setText("Enregistrer");
		} else
		{
			validation.setText("Rechercher");
		}
		validation.addActionListener(new ActionVehicule(this));
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}

	public void Moto(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textField("Compteur", km));
		infoVehicule.add(textField("Puissance", puissance));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		if (fenetre.getTitle() == "Nouvelle Moto")
		{
			validation.setText("enregistrer");
		} else
		{
			validation.setText("rechercher");
		}
		validation.addActionListener(new ActionVehicule(this));
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}

	public void Avion(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textField("Heures de vol", nbHeuresVol));
		infoVehicule.add(textField("Nombre de moteurs", nbMoteurs));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		if (fenetre.getTitle() == "Nouvel Avion")
		{
			validation.setText("enregistrer");
		} else
		{
			validation.setText("rechercher");
		}
		validation.addActionListener(new ActionVehicule(this));
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}

	public void addGeneralTextFields()
	{
		infoVehicule.add(textField("Modèle", modele));
		infoVehicule.add(textField("Etat", etat));
		infoVehicule.add(textField("Prix par jour", prixJour));
		infoVehicule.add(textField("Marque", marque));
		infoVehicule.add(textField("Immatriculation", immat));
		infoVehicule.add(textField("Vitesse", vitesse));
	}

	public JFrame getFenetre()
	{
		return fenetre;
	}

	public JFrame getFenetreChoix()
	{
		return fenetre2;
	}

	public JComboBox<String> getChoixV()
	{
		return choixV;
	}

	public boolean isNouveau()
	{
		return nouveau;
	}

	public JButton getEnregistrer()
	{
		return validation;
	}

	public JButton getOK()
	{
		return ok;
	}

	public JTextField getTexteMar()
	{
		return texteMar;
	}

	public JTextField getTexteMod()
	{
		return texteMod;
	}

	public JTextField getTexteImm()
	{
		return texteImm;
	}

	public JList<String> getChoixMar()
	{
		return choixMar;
	}

	public void setChoixMar(JList<String> choixMar)
	{
		choixMar.removeAll();
		MenuVehicule.choixMar = choixMar;
		choixMar.repaint();
	}

	public JList<String> getChoixMod()
	{
		return choixMod;
	}

	public void setChoixMod(JList<String> choixMod)
	{
		choixMod.removeAll();
		MenuVehicule.choixMod = choixMod;
		choixMod.repaint();
	}

	public JList<String> getChoixImm()
	{
		return choixImm;
	}

	public void setChoixImm(JList<String> choixImm)
	{
		choixImm.removeAll();
		MenuVehicule.choixImm = choixImm;
		choixImm.repaint();
	}
}
