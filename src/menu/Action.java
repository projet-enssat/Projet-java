package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.GestionClient;

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
			case "Supprimer Client":
				MenuClient suppclient = new MenuClient();
				suppclient.setValidation("Rechercher");
				suppclient.recherche();
				break;
			case "Début Location":
				MenuLocation nouvLoc = new MenuLocation();
				nouvLoc.nouvLocation("test");
				break;
			case "Fin Location":

				break;
			case "Nouveau Véhicule":
				new MenuVehicule().nouveauVehicule();
				break;
			case "Supprimer Véhicule":
				new MenuVehicule().supprimerVehicule();
				break;
			case "Options":
				System.out.println(new GestionClient().lireClients());
				break;
		}
	}
}
