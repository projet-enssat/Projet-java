package menu;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class MenuPrincipal extends Menu{
	
	JButton nouvClient = new JButton("Nouveau Client");
	JButton nouvLoc = new JButton("Début Location");
	JButton nouvVehi = new JButton("Nouveau Véhicule");
	JButton suppClient = new JButton("Supprimer Client");
	JButton suppLoc = new JButton("Fin Location");
	JButton suppVehi = new JButton("Supprimer Véhicule");
	JButton options = new JButton("Options");

	public MenuPrincipal() {
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
		option1.add(option2, BorderLayout.WEST);
		options.addActionListener(new Action(this));
		option2.add(options, BorderLayout.NORTH);
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
		GridLayout grilleAction = new GridLayout(3,3);
		action.setLayout(grilleAction);
		action.add(client);
		action.add(location);
		action.add(vehicule);
		nouvClient.addActionListener(new Action(this));
		action.add(bouton(nouvClient));
		nouvLoc.addActionListener(new Action(this));
		action.add(bouton(nouvLoc));
		nouvVehi.addActionListener(new Action(this));
		action.add(bouton(nouvVehi));
		suppClient.addActionListener(new Action(this));
		action.add(bouton(suppClient));
		suppLoc.addActionListener(new Action(this));
		action.add(bouton(suppLoc));
		suppVehi.addActionListener(new Action(this));
		action.add(bouton(suppVehi));
		
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
	
	public static void main(String[] args){
		
		//Creation des archives clients, locations, vehicules
		File fichierClients = new File("clients");
		File fichierLocations = new File("locations");
		File fichierVehicules = new File("vehicules");
		try
		{
			fichierClients.createNewFile();
			fichierLocations.createNewFile();
			fichierVehicules.createNewFile();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		MenuPrincipal con = new MenuPrincipal();
	}
}
