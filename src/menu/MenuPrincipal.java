package menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * Classe d'affichage de la fenetre d'accueil.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class MenuPrincipal extends Menu
{
	/** Element graphique */
	private static JButton nouvClient = new JButton("Nouveau Client");
	/** Element graphique */
	private static JButton nouvLoc = new JButton("Début Location");
	/** Element graphique */
	private static JButton nouvVehi = new JButton("Nouveau Véhicule");
	/** Element graphique */
	private static JButton suppClient = new JButton("Supprimer Client");
	/** Element graphique */
	private static JButton suppLoc = new JButton("Fin Location");
	/** Element graphique */
	private static JButton suppVehi = new JButton("Supprimer Véhicule");
	/** Element graphique */
	private static JButton options = new JButton("Options");

	/**
	 * Constructeur et afficheur de la fenetre principale.
	 */
	public MenuPrincipal()
	{
		JPanel optionVerif = new JPanel();
		GridLayout grilleoption = new GridLayout(1, 2);
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

		JPanel client = label(new JLabel("Client"));
		JPanel location = label(new JLabel("Location"));
		JPanel vehicule = label(new JLabel("Véhicule"));
		
		JPanel action = new JPanel(new GridLayout(3,3));
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

		JPanel test2 = new JPanel(new FlowLayout());

		JFrame principal = new JFrame("Accueil");
		principal.setBounds(600, 200, 700, 500);
		principal.setLayout(new GridLayout(4,1));
		principal.add(optionVerif);
		principal.add(test2);
		principal.add(action);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setVisible(true);
	}

	/**
	 * Lancement du programme.
	 */
	public static void main(String[] args)
	{
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
