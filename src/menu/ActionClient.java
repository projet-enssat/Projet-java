package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ActionClient implements ActionListener,ListSelectionListener {

	MenuClient menu;

	public ActionClient(Menu menu)
	{
		this.menu = (MenuClient) menu;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().getClass()==(new JButton().getClass())){
			switch (((JButton) e.getSource()).getText())
			{
				case "Enregistrer":
					menu.enregistrement();
					break;
				default:
					break;
			}
		}
		if (e.getSource().equals(menu.getNomClient())){
			menu.refreshNom();
		}else if(e.getSource().equals(menu.getPrenom())){
			menu.refreshPrenom();
		}else if(e.getSource().equals(menu.getAdresse())){
			menu.refreshAdresse();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		menu.autoComp();
	}

}
