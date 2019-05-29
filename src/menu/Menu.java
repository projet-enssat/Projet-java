package menu;
import java.awt.*;
import javax.swing.*;

public class Menu{
	
	private static final long serialVersionUID = 1L;

	public void AffClient(String nom) {
		JPanel nom = new JPanel();
		GridLayout posNom = new GridLayout(1,2);
		nom.setLayout(posnom);
		nom.add(new Label("Nom :"));
		JTextField textNom = new JTextField();
		nom.add(textNom);
		
		JFrame fenetre = new JFrame(nom);
		fenetre.setBounds(600,200,700,500);
		GridLayout grillePrincipal = new GridLayout(4,1);
		fenetre.setLayout(grillePrincipal);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
	}
	public void MenuPrincipal() {
		//pour creer des espaces sans rien
		JPanel vide = new JPanel();
		FlowLayout espaceVide = new FlowLayout();
		vide.setLayout(espaceVide);
				
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
		JButton boutonoption = new JButton("option");
		option1.add(option2, BorderLayout.WEST);
		option2.add(boutonoption, BorderLayout.NORTH);
		optionVerif.add(option1);
		optionVerif.add(vide);
		
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
		
		JPanel nouvClient = new JPanel();
		FlowLayout posNouvClient = new FlowLayout();
		nouvClient.setLayout(posNouvClient);
		JButton boutonNouvClient = new JButton("Nouveau Client");
		boutonNouvClient.addActionListener(new Action());
		nouvClient.add(boutonNouvClient);
		
		JPanel nouvLocation = new JPanel();
		FlowLayout posNouvLocation = new FlowLayout();
		nouvLocation.setLayout(posNouvLocation);
		JButton boutonNouvLocation = new JButton("Début Location");
		boutonNouvLocation.addActionListener(new Action());
		nouvLocation.add(boutonNouvLocation);
		
		JPanel nouvVehicule = new JPanel();
		FlowLayout posNouvVehicule = new FlowLayout();
		nouvVehicule.setLayout(posNouvVehicule);
		JButton boutonNouvVehicule = new JButton("Nouveau Véhicule");
		boutonNouvVehicule.addActionListener(new Action());
		nouvVehicule.add(boutonNouvVehicule);
		
		JPanel suppClient = new JPanel();
		FlowLayout posSuppClient = new FlowLayout();
		suppClient.setLayout(posSuppClient);
		JButton boutonSuppClient = new JButton("Supprimer Client");
		boutonSuppClient.addActionListener(new Action());
		suppClient.add(boutonSuppClient);
		
		JPanel suppLocation = new JPanel();
		FlowLayout posSuppLocation = new FlowLayout();
		suppLocation.setLayout(posSuppLocation);
		JButton boutonSuppLocation = new JButton("Fin Location");
		boutonSuppLocation.addActionListener(new Action());
		suppLocation.add(boutonSuppLocation);
		
		JPanel suppVehicule = new JPanel();
		FlowLayout posSuppVehicule = new FlowLayout();
		suppVehicule.setLayout(posSuppVehicule);
		JButton boutonSuppVehicule = new JButton("Suprimer Véhicule");
		boutonSuppVehicule.addActionListener(new Action());
		suppVehicule.add(boutonSuppVehicule);
		
		//mise en place des choix d'actions (location, client, véhicule : nouvelle ou fin)
		JPanel action = new JPanel();
		GridLayout grilleaction = new GridLayout(3,3);
		action.setLayout(grilleaction);
		action.add(client);
		action.add(location);
		action.add(vehicule);
		action.add(nouvClient);
		action.add(nouvLocation);
		action.add(nouvVehicule);
		action.add(suppClient);
		action.add(suppLocation);
		action.add(suppVehicule);
		
		JPanel test2 = new JPanel();
		FlowLayout test = new FlowLayout();
		test2.setLayout(test);
		
		JFrame principal = new JFrame("Acceuil");
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
