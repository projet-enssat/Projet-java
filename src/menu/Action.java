package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vehicule.GestionVehicule;
import client.GestionClient;

public class Action implements ActionListener {

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(((JButton) e.getSource()).getText())
		{
			case "Nouveau Client" :
				GestionClient gnClient = new GestionClient();
				Menuprincipal con2 = new Menuprincipal();
				con2.AffClient("test");
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
				
				break;
			case "Supprimer V�hicule" :
				
				break;
			case "Options" :
				
				break;
		}
	}
}
