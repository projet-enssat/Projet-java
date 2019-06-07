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
	/** (Des)active la reaction aux evenements. */
	boolean enabled = true;

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
		if (enabled)
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
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		if (enabled) { menu.autoCompletion(); }
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		if (enabled) { menu.autoCompletion(); }
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (enabled && !e.getValueIsAdjusting())
		{
			if (e.getSource().equals(menu.getListNom()))
			{
				menu.getNomTF().setText(menu.getListNom().getSelectedValue());
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getListPrenom()))
			{
				menu.getPrenomTF().setText(menu.getListPrenom().getSelectedValue());
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getListAdresse()))
			{
				menu.getAdresseTF().setText(menu.getListAdresse().getSelectedValue());
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getListImmat()))
			{
				menu.getImmatTF().setText(menu.getListImmat().getSelectedValue());
				menu.autoCompletion();
			}
		}
	}

	/**
	 * Toggles the action listener. Used for autocompletion.
	 */
	public void toggle()
	{
		enabled = !enabled;
	}
}
