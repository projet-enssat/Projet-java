package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.MenuLocation;

/**
 * Permet la gestion d'evenements declenches par le menu location.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class ActionLocation implements ActionListener, ListSelectionListener, DocumentListener
{
	/**
	 * Menu a ecouter.
	 */
	MenuLocation menu;

	/**
	 * Constructeur.
	 * @param menu Menu a ecouter.
	 */
	public ActionLocation(MenuLocation menu)
	{
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(menu.getValidation1())) {
			menu.validerClient();
		} else if(e.getSource().equals(menu.getValidation2())) {
			menu.validerVehicule();
		} else if(e.getSource().equals(menu.getValidation3())) {
			menu.enregistrement();
		} else {
			menu.verifDate();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
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
	public void removeUpdate(DocumentEvent e)
	{
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
	public void valueChanged(ListSelectionEvent e)
	{
		if(!e.getValueIsAdjusting()) {
			if(e.getSource().equals(menu.getListNom()) || e.getSource().equals(menu.getListPrenom()) || e.getSource().equals(menu.getListAdresse())) {
				if(((JList<String>) e.getSource()).getSelectedValue()!=null) {
					menu.autoCompletionClient(((JList<String>) e.getSource()).getSelectedValue());
				}
			}else if(e.getSource().equals(menu.getListImmat())) {
				if(((JList<String>) e.getSource()).getSelectedValue()!=null) {
					menu.autoCompletionVehicule(((JList<String>) e.getSource()).getSelectedValue());
				}
			}
		}
	}

}
