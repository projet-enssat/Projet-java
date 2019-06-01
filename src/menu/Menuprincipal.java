package menu;
import java.awt.*;
import javax.swing.*;

public class Menuprincipal extends Menu{
	
	public Menuprincipal() {
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
		JLabel labelVehicule = new JLabel("V�hicule");
		vehicule.add(labelVehicule);
		
		//mise en place des choix d'actions (location, client, v�hicule : nouvelle ou fin)
		JPanel action = new JPanel();
		GridLayout grilleaction = new GridLayout(3,3);
		action.setLayout(grilleaction);
		action.add(client);
		action.add(location);
		action.add(vehicule);
		action.add(boutonprinc("Nouveau Client"));
		action.add(boutonprinc("D�but Location"));
		action.add(boutonprinc("Nouveau V�hicule"));
		action.add(boutonprinc("Supprimer Client"));
		action.add(boutonprinc("Fin Location"));
		action.add(boutonprinc("Supprimer V�hicule"));
		
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
		Menuprincipal con = new Menuprincipal();
	}
}
