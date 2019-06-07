package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.GestionClient;
import location.GestionLocation;
import menu.Menu;
import menu.MenuClient;
import menu.MenuLocation;
import menu.MenuPrincipal;
import menu.MenuVehicule;

/**
 * Permet la gestion d'evenements declenches par le menu principal.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class Action implements ActionListener
{
	/**
	 * Menu a ecouter.
	 */
	MenuPrincipal menu;

	/**
	 * Constructeur
	 * @param menu Menu a ecouter.
	 */
	public Action(Menu menu)
	{
		this.menu = (MenuPrincipal) menu;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (((JButton) e.getSource()).getText())
		{
			case "Nouveau Client":
				MenuClient nouvclient = new MenuClient();
				nouvclient.setValidation("Enregistrer");
				nouvclient.affMenu("Nouveau Client");
				break;
			case "Modifier Client":
				MenuClient modiclient = new MenuClient();
				modiclient.setValidation("Rechercher");
				modiclient.recherche();
				break;
			case "Supprimer Client":
				MenuClient suppclient = new MenuClient();
				suppclient.setValidation("Supprimer");
				suppclient.recherche();
				break;
			case "Debut Location":
				new MenuLocation().nouvLocation("Nouvelle location");
				break;
			case "Fin Location":
				new MenuLocation().finLocation1();
				break;
			case "Nouveau Vehicule":
				new MenuVehicule().nouveauVehicule();
				break;
			case "Modifier Vehicule":
				new MenuVehicule().modifierVehicule();
				break;
			case "Supprimer Vehicule":
				new MenuVehicule().supprimerVehicule();
				break;
			case "Options":
				System.out.println(new GestionLocation(null, null, null, null, false).lireLocations("locations"));
				break;
		}
	}
}
