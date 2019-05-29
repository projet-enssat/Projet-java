package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import location.Gestionlocation;
import client.Gestionclient;
import client.Client;

public class Action implements ActionListener {

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(((JButton) e.getSource()).getText() == "Nouveau Client"){
			Gestionclient gclient = new Gestionclient();
			gclient.creerClient();
		}
		if(((JButton) e.getSource()).getText() == "Supprimer Client") {
			Gestionclient gclient = new Gestionclient();
			gclient.supprimerClient();
		}
		if(((JButton) e.getSource()).getText() == "Début Location") {
			Gestionlocation glocation = new Gestionlocation();
			glocation.nouvelleLocation();
		}
		if(((JButton) e.getSource()).getText() == "Fin Location") {
			Gestionlocation glocation = new Gestionlocation();
			glocation.finLocation();
		}
		if(((JButton) e.getSource()).getText() == "Nouveau Véhicule") {
			Gestionvehicule gvehicule = new Gestionvehicule();
			gvehicule.nouvellevehicule();
		}
		if(((JButton) e.getSource()).getText() == "Suprimer Véhicule") {
			Gestionvehicule gvehicule = new Gestionvehicule();
			gvehicule.finvehicule();
		}
	}

}
