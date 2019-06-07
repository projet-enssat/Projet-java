package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ActionLocation implements ActionListener,ListSelectionListener,DocumentListener
{
	MenuLocation menu;
	
	public ActionLocation(MenuLocation menu)
	{
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().getClass()==(new JButton().getClass())){
			if(((JButton) e.getSource()).equals(menu.getValidation1())) {
				menu.validerClient();
			}else if(((JButton) e.getSource()).equals(menu.getValidation2())) {
				menu.validerVehicule();
			}else if(((JButton) e.getSource()).equals(menu.getValidation3())) {
				menu.setEnregistrement();
			}
		}else {
			menu.verifDate();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(e.getDocument().equals(menu.getAdresseTFDocument())) {
			menu.refreshAdresse();
		}else if(e.getDocument().equals(menu.getNomTFDocument())) {
			menu.refreshNom();
		}else if(e.getDocument().equals(menu.getPrenomTFDocument())) {
			menu.refreshPrenom();
		}else if(e.getDocument().equals(menu.getImmatTFDocument())) {
			menu.refreshImmat();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(e.getDocument().equals(menu.getAdresseTFDocument())) {
			menu.refreshAdresse();
		}else if(e.getDocument().equals(menu.getNomTFDocument())) {
			menu.refreshNom();
		}else if(e.getDocument().equals(menu.getPrenomTFDocument())) {
			menu.refreshPrenom();
		}else if(e.getDocument().equals(menu.getImmatTFDocument())) {
			menu.refreshImmat();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(!e.getValueIsAdjusting()) {
			if(((JList<String>) e.getSource()).equals(menu.getListNom()) || ((JList<String>) e.getSource()).equals(menu.getListPrenom()) || ((JList<String>) e.getSource()).equals(menu.getListAdresse())) {
				if(((JList<String>) e.getSource()).getSelectedValue()!=null) {
					menu.autoCompClient(((JList<String>) e.getSource()).getSelectedValue());
				}
			}else if(((JList<String>) e.getSource()).equals(menu.getListImmat())) {
				if(((JList<String>) e.getSource()).getSelectedValue()!=null) {
					menu.autoCompVehicule(((JList<String>) e.getSource()).getSelectedValue());
				}
			}
		}
	}

}
