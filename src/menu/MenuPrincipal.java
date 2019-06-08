package menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import action.Action;

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
	private static JButton nouvLoc = new JButton("Debut Location");
	/** Element graphique */
	private static JButton nouvVehi = new JButton("Nouveau Vehicule");
	/** Element graphique */
	private static JButton modiClient = new JButton("Modifier Client");
	/** Element graphique */
	private static JButton modiVehi = new JButton("Modifier Vehicule");
	/** Element graphique */
	private static JButton suppClient = new JButton("Supprimer Client");
	/** Element graphique */
	private static JButton suppLoc = new JButton("Fin Location");
	/** Element graphique */
	private static JButton suppVehi = new JButton("Supprimer Vehicule");

	/**
	 * Constructeur et afficheur de la fenetre principale.
	 */
	public MenuPrincipal()
	{
		JPanel client = label(new JLabel("Client"));
		JPanel location = label(new JLabel("Location"));
		JPanel vehicule = label(new JLabel("Vehicule"));
		
		JPanel action = new JPanel(new GridLayout(4,3));
		action.add(client);
		action.add(location);
		action.add(vehicule);
		nouvClient.addActionListener(new Action(this));
		action.add(bouton(nouvClient));
		nouvLoc.addActionListener(new Action(this));
		action.add(bouton(nouvLoc));
		nouvVehi.addActionListener(new Action(this));
		action.add(bouton(nouvVehi));
		modiClient.addActionListener(new Action(this));
		action.add(bouton(modiClient));
		action.add(vide());
		modiVehi.addActionListener(new Action(this));
		action.add(bouton(modiVehi));
		suppClient.addActionListener(new Action(this));
		action.add(bouton(suppClient));
		suppLoc.addActionListener(new Action(this));
		action.add(bouton(suppLoc));
		suppVehi.addActionListener(new Action(this));
		action.add(bouton(suppVehi));

		JFrame principal = new JFrame("Accueil");
		principal.setBounds(450, 200, 600, 200);
		principal.setLayout(new FlowLayout());
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
		File fichierLocationsFinies = new File("locations_finies");
		File fichierVehicules = new File("vehicules");
		try
		{
			fichierClients.createNewFile();
			fichierLocations.createNewFile();
			fichierLocationsFinies.createNewFile();
			fichierVehicules.createNewFile();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		MenuPrincipal con = new MenuPrincipal();
	}
}
