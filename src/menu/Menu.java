package menu;
import java.awt.*;
import javax.swing.*;

public class Menu{

	public JPanel bouton(String nom) {
		JPanel panel = new JPanel();
		FlowLayout pospanel = new FlowLayout();
		panel.setLayout(pospanel);
		JButton bouton = new JButton(nom);
		bouton.addActionListener(new Action());
		panel.add(bouton);
		return panel;
	}
	
	public JPanel vide() {
		JPanel vide = new JPanel();
		FlowLayout espaceVide = new FlowLayout();
		vide.setLayout(espaceVide);
		return vide;
	}
	
	public JPanel textField(String nom) {
		JPanel panelSec = new JPanel();
		GridLayout posPanelS = new GridLayout(3,1);
		panelSec.setLayout(posPanelS);
		panelSec.add(vide());
		JTextField text = new JTextField();
		panelSec.add(text);
		

		JPanel panelTer = new JPanel();
		GridLayout posPanelT = new GridLayout(1,3);
		panelTer.setLayout(posPanelT);
		panelTer.add(vide());
		JLabel label = new JLabel(nom);
		panelTer.add(label);
		
		JPanel panelPrinc = new JPanel();
		GridLayout posPanelP = new GridLayout(1,2);
		panelPrinc.setLayout(posPanelP);
		panelPrinc.add(panelTer);
		panelPrinc.add(panelSec);
		return panelPrinc;
	}
	
	public void AffClient(String nom) {
		
		JFrame fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipale = new GridLayout(4,1);
		fenetre.setLayout(grillePrincipale);
		JPanel nomPrenom = new JPanel();
		GridLayout posNomPrenom = new GridLayout(1,2);
		nomPrenom.setLayout(posNomPrenom);
		JPanel champNom = textField("Nom :");
		nomPrenom.add(champNom);
		nomPrenom.add(textField("Prenom :"));
		fenetre.add(nomPrenom);
		fenetre.add(textField("Adresse :"));
		fenetre.add(textField("Date du permis :"));
		fenetre.add(textField("Date de fin d'apprentissage :"));
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new Action());
		fenetre.add(enregistrer);
		fenetre.setVisible(true);
		
	}
	
	public void MenuPrincipal() {
		//pour creer des espaces sans rien
		
				
		//mise en place des options de modification et de verification des locations
		JPanel optionVerif = new JPanel();
		GridLayout grilleoption = new GridLayout(1,2);
		optionVerif.setLayout(grilleoption);
		JPanel option1 = new JPanel();
		BorderLayout posOption1 = new BorderLayout();
		option1.setLayout(posOption1);
		JPanel option2 = new JPanel();
		BorderLayout posOption2 = new BorderLayout();
		option2.setLayout(posOption2);
		JButton boutonoption = new JButton("Options");
		option1.add(option2, BorderLayout.WEST);
		option2.add(boutonoption, BorderLayout.NORTH);
		optionVerif.add(option1);
		optionVerif.add(vide());
		
		JPanel client = new JPanel();
		FlowLayout posClient = new FlowLayout();
		client.setLayout(posClient);
		JLabel labelClient = new JLabel("Client");
		client.add(labelClient);
		
		JPanel location = new JPanel();
		FlowLayout posLocation = new FlowLayout();
		location.setLayout(posLocation);
		JLabel labelLocation = new JLabel("Location");
		location.add(labelLocation);
		
		JPanel vehicule = new JPanel();
		FlowLayout posVehicule = new FlowLayout();
		vehicule.setLayout(posVehicule);
		JLabel labelVehicule = new JLabel("Véhicule");
		vehicule.add(labelVehicule);
		
		//mise en place des choix d'actions (location, client, véhicule : nouvelle ou fin)
		JPanel action = new JPanel();
		GridLayout grilleaction = new GridLayout(3,3);
		action.setLayout(grilleaction);
		action.add(client);
		action.add(location);
		action.add(vehicule);
		action.add(bouton("Nouveau Client"));
		action.add(bouton("Début Location"));
		action.add(bouton("Nouveau Véhicule"));
		action.add(bouton("Supprimer Client"));
		action.add(bouton("Fin Location"));
		action.add(bouton("Supprimer Véhicule"));
		
		JPanel test2 = new JPanel();
		FlowLayout test = new FlowLayout();
		test2.setLayout(test);
		
		JFrame principal = new JFrame("Accueil");
		principal.setBounds(600,200,700,500);
		GridLayout grillePrincipal = new GridLayout(4,1);
		principal.setLayout(grillePrincipal);
		principal.add(optionVerif);
		principal.add(test2);
		principal.add(action);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setVisible(true);
	}
	
	public Menu() {

	}
	
	public static void main(String[] args){
		Menu con = new Menu();
		con.MenuPrincipal();
	}
}
