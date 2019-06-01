package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Actionclient implements ActionListener {

	Menuclient menu;
	
	public Actionclient(Menu menu) {
		this.menu=(Menuclient)menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(((JButton) e.getSource()).getText())
		{
		case "enregistrer" :
			System.out.println("test\n");
			menu.enregistrement();
			break;
		}
	}

}
