package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		}else if(e.getDocument().equals(menu.getMarqueTFDocument())) {
			menu.refreshMarque();
		}else if(e.getDocument().equals(menu.getModeleTFDocument())) {
			menu.refreshModele();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
