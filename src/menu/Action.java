package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.GestionClient;

public class Action implements ActionListener {

	Menuprincipal menu;
	
	public Action(Menu menu) {
		this.menu=(Menuprincipal)menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(((JButton) e.getSource()).getText())
		{
			case "Nouveau Client" :
				Menuclient client = new Menuclient();
				client.AffMenu("Nouveau Client");
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
