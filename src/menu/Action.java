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
				MenuClient client = new MenuClient();
				client.affMenu("Nouveau Client");
				break;
			case "Supprimer Client" :
				GestionClient gsClient = new GestionClient();
				gsClient.supprimerClient();
				break;
			case "D�but Location" :
				
				break;
			case "Fin Location" :
				
				break;
			case "Nouveau V�hicule" :
				MenuVehicule vehicule = new MenuVehicule();
				vehicule.nouveauVehicule();
				break;
			case "Supprimer V�hicule" :
				
				break;
			case "Options" :
				System.out.println(new GestionClient().lireClients());
				break;
		}
	}
}
