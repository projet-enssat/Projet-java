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
	private static JButton validation;
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
		if (validation == null)
		{
			validation = new JButton("Enregistrer");
			validation.addActionListener(new ActionVehicule(this));
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
		
		if (texteMod == null)
		{
			texteMod = new JTextField();
			texteMod.getDocument().addDocumentListener(new ActionVehicule(this));
		}
		
		if (texteImm == null)
		{
			texteImm = new JTextField();
			texteImm.getDocument().addDocumentListener(new ActionVehicule(this));
		}
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
		fenetre2 = new JFrame("Nouveau v�hicule");
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
		fenetre3 = new JFrame("Supprimer v�hicule");
		fenetre3.setBounds(400, 400, 1100, 200);
		fenetre3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout layout = new GridLayout(2, 4);
		fenetre3.setLayout(layout);

		
		fenetre3.add(comboBoxV(choixV));
		fenetre3.add(textFieldNoLabel(texteMar));
		fenetre3.add(textFieldNoLabel(texteMod));
		fenetre3.add(textFieldNoLabel(texteImm));
		fenetre3.add(vide());
		fenetre3.add(listV(choixMar));
		fenetre3.add(listV(choixMod));
		fenetre3.add(listV(choixImm));
		fenetre3.setVisible(true);
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
		fenetre.add(bouton(validation));
		fenetre.setVisible(true);
	}

	public void addGeneralTextFields()
	{
		infoVehicule.add(textField("Mod�le", modele));
		infoVehicule.add(textField("Etat", etat));
		infoVehicule.add(textField("Prix par jour", prixJour));
		infoVehicule.add(textField("Marque", marque));
		infoVehicule.add(textField("Immatriculation", immat));
		infoVehicule.add(textField("Vitesse", vitesse));
	}
	
	public void autoCompletion()
	{
		((ActionVehicule) choixMar.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixMod.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixImm.getListSelectionListeners()[0]).toggle();
		
		GestionVehicule tempGV = new GestionVehicule((String) choixV.getSelectedItem());
		setChoixMar(tempGV.toutesLesMarques(texteMar.getText()));
		setChoixMod(tempGV.tousLesModeles(choixMar.getSelectedValue(), texteMod.getText()));
		setChoixImm(tempGV.toutesLesImmats(choixMar.getSelectedValue(), choixMod.getSelectedValue(), texteImm.getText()));

		((ActionVehicule) choixMar.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixMod.getListSelectionListeners()[0]).toggle();
		((ActionVehicule) choixImm.getListSelectionListeners()[0]).toggle();
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
