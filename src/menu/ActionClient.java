package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ActionClient implements ActionListener,ListSelectionListener,DocumentListener {

	MenuClient menu;
	boolean test = false;
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
				case "Tous":
					menu.refreshTous();
					break;
				case "Valider":
					menu.suppression();
					break;
				default:
					break;
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(!e.getValueIsAdjusting()) {
			if((String) ((JList<String>) e.getSource()).getSelectedValue()!=null) {
				menu.autoComp(((JList<String>) e.getSource()).getSelectedValue());
			}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(e.getDocument().equals(menu.getNomDocument())) {
			menu.refreshNom();
		}else if(e.getDocument().equals(menu.getPrenomDocument())) {
			menu.refreshPrenom();
		}else {
			menu.refreshAdresse();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(e.getDocument().equals(menu.getNomDocument())) {
			menu.refreshNom();
		}else if(e.getDocument().equals(menu.getPrenomDocument())) {
			menu.refreshPrenom();
		}else if(e.getDocument().equals(menu.getAdresseDocument())) {
			menu.refreshAdresse();
		}
	}
}
