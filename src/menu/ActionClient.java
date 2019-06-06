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
		switch (((JButton) e.getSource()).getText())
		{
			case "Enregistrer":
				menu.enregistrement();
				break;
			default:
				break;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		menu.autoComp();
	}

}
