package menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import vehicule.GestionVehicule;

public class MenuVehicule extends Menu
{
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
	private static JButton validation1;
	private static JButton validation2;
	private static JButton ok;
	private static JComboBox<String> choixV;
	private static JTextField texteMar;
	private static JTextField texteMod;
	private static JTextField texteImm;
	private static JList<String> choixMar;
	private static JList<String> choixMod;
	private static JList<String> choixImm;
	private static JFrame fenetre;
	private static JFrame fenetre2;
	private static JFrame fenetre3;
	private static JPanel infoVehicule = new JPanel();
	private static boolean nouveau = true;

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
			choixMod.setModel(new GestionVehicule().tousLesModeles("", ""));
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
			choixImm.setModel(new GestionVehicule().toutesLesImmats("", "", ""));
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
	
	public void suppression(String classe)
	{
		GestionVehicule tempGV = new GestionVehicule(classe);
		tempGV.rechercheVehicule(texteImm.getText());
		tempGV.supprimerVehicule();
	}

	public void affMenu(String nom)
	{
		if (fenetre != null) { fenetre.removeAll(); }
		fenetre = new JFrame(nom);
		fenetre.setBounds(400,200,1100,500);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		infoVehicule.removeAll();
		infoVehicule = new JPanel();
		GridLayout grillePrincipale = new GridLayout(2, 1);
		fenetre.setLayout(grillePrincipale);
		GridLayout grilleInfo = new GridLayout(3, 3);
		infoVehicule.setLayout(grilleInfo);
		addGeneralTextFields();
	}

	public void nouveauVehicule()
	{
		nouveau = true;
		if (fenetre2 != null) { fenetre2.removeAll(); }
		fenetre2 = new JFrame("Nouveau véhicule");
		fenetre2.setBounds(800, 400, 400, 100);
		fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FlowLayout layout = new FlowLayout();
		fenetre2.setLayout(layout);

		fenetre2.add(comboBoxV(choixV));
		ok.setEnabled(false);
		ok.setText("OK");
		fenetre2.add(bouton(ok));
		fenetre2.setVisible(true);
	}

	public void supprimerVehicule()
	{
		nouveau = false;
		if (fenetre3 != null) { fenetre3.removeAll(); }
		fenetre3 = new JFrame("Supprimer véhicule");
		fenetre3.setBounds(400, 400, 1100, 200);
		fenetre3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout layout = new GridLayout(2, 4);
		fenetre3.setLayout(layout);

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

	public void Voiture(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Compteur", km));
		infoVehicule.add(textFieldLabelLeft("Puissance", puissance));
		infoVehicule.add(textFieldLabelLeft("Places", nbPlaces));
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation1));
		fenetre.setVisible(true);
	}

	public void Moto(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Compteur", km));
		infoVehicule.add(textFieldLabelLeft("Puissance", puissance));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation1));
		fenetre.setVisible(true);
	}

	public void Avion(String nom)
	{
		affMenu(nom);

		infoVehicule.add(textFieldLabelLeft("Heures de vol", nbHeuresVol));
		infoVehicule.add(textFieldLabelLeft("Nombre de moteurs", nbMoteurs));
		infoVehicule.add(vide());
		fenetre.add(infoVehicule);
		fenetre.add(bouton(validation1));
		fenetre.setVisible(true);
	}

	public void addGeneralTextFields()
	{
		infoVehicule.add(textFieldLabelLeft("Modèle", modele));
		infoVehicule.add(textFieldLabelLeft("Etat", etat));
		infoVehicule.add(textFieldLabelLeft("Prix par jour", prixJour));
		infoVehicule.add(textFieldLabelLeft("Marque", marque));
		infoVehicule.add(textFieldLabelLeft("Immatriculation", immat));
		infoVehicule.add(textFieldLabelLeft("Vitesse", vitesse));
	}
	
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
	
	public JFrame getFenetre()
	{
		return fenetre;
	}

	public JFrame getFenetre2()
	{
		return fenetre2;
	}
	
	public JFrame getFenetre3()
	{
		return fenetre3;
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
		return validation1;
	}
	
	public JButton getSupprimer()
	{
		return validation2;
	}

	public JButton getOK()
	{
		return ok;
	}

	public JTextField getTexteMar()
	{
		return texteMar;
	}
	
	public void setTexteMar(String texte)
	{
		texteMar.setText(texte);
	}

	public JTextField getTexteMod()
	{
		return texteMod;
	}
	
	public void setTexteMod(String texte)
	{
		texteMod.setText(texte);
	}

	public JTextField getTexteImm()
	{
		return texteImm;
	}
	
	public void setTexteImm(String texte)
	{
		texteImm.setText(texte);
	}

	public JList<String> getChoixMar()
	{
		return choixMar;
	}

	public void setChoixMar(ListModel<String> model)
	{
		choixMar.setModel(model);
	}

	public JList<String> getChoixMod()
	{
		return choixMod;
	}

	public void setChoixMod(ListModel<String> model)
	{
		choixMod.setModel(model);
	}

	public JList<String> getChoixImm()
	{
		return choixImm;
	}

	public void setChoixImm(ListModel<String> model)
	{
		choixImm.setModel(model);
	}
}
