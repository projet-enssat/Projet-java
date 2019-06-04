package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.GestionClient;

public class Action implements ActionListener {

	MenuPrincipal menu;
	
	public Action(Menu menu) {
		this.menu=(MenuPrincipal)menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(((JButton) e.getSource()).getText())
		{
			case "Nouveau Client" :
				MenuClient nouvclient = new MenuClient();
				nouvclient.setValidation("Enregistrer");
				nouvclient.affMenu("Nouveau Client");
				break;
			case "Supprimer Client" :
				MenuClient suppclient = new MenuClient();
				suppclient.setValidation("rechercher");
				suppclient.affMenu("Supprimer Client");
				break;
			case "Début Location" :
				
				break;
			case "Fin Location" :
				
				break;
			case "Nouveau Véhicule" :
				new MenuVehicule().nouveauVehicule();
				break;
			case "Supprimer Véhicule" :
				new MenuVehicule().supprimerVehicule();
				break;
			case "Options" :
				System.out.println(new GestionClient().lireClients());
				break;
		}
	}
}
