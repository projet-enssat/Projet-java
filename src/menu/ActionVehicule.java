package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ActionVehicule implements ActionListener
{
	MenuVehicule menu;
	
	public ActionVehicule(MenuVehicule menu) {
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (menu.getChoixV().getSelectedIndex() != 0)
		{
				menu.getOK().setEnabled(true);
		} else
		{
				menu.getOK().setEnabled(false);
		}
	 	if (e.getSource().equals(menu.getOK()))
		{
			menu.getFenetre().setVisible(false);
			switch (menu.getChoixV().getSelectedIndex())
			{
				case 1 : menu.nouvelleVoiture(); break;
				case 2 : menu.nouvelleMoto(); break;
				case 3 : menu.nouvelAvion(); break;
				default : break;
			}
			menu.resetBox();
		} else if (e.getSource().equals(menu.getEnregistrer()))
		{
			String classe = "";
			switch (menu.getChoixV().getSelectedIndex())
			{
				case 1 : classe = "Voiture"; break;
				case 2 : classe = "Moto"; break;
				case 3 : classe = "Avion"; break;
				default : break;
			}
			menu.enregistrement(classe);
			menu.getFenetre().setVisible(false);
		}
	}
}
