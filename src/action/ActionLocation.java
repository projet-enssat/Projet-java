package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			if (menu.isNouveau())
			{
				if (e.getSource().equals(menu.getValidation1())) {
					menu.verifClient();
					menu.validerClient();
				} else if(e.getSource().equals(menu.getValidation2())) {
					menu.validerVehicule();
				} else if(e.getSource().equals(menu.getValidation3())) {
					menu.enregistrement();
				} else {
					menu.verifDate();
				}
			} else
			{
				if (e.getSource().equals(menu.getValidation1())) {
					menu.verifClient();
					menu.validerClientSuppr();
				} else if(e.getSource().equals(menu.getValidation2())) {
					menu.verifVehicule();
					menu.validerLocation();
				} else if(e.getSource().equals(menu.getValidation3())) {
					//menu.archivage();
				}
			}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		removeUpdate(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		if (enabled)
		{
			if (e.getDocument().equals(menu.getNomTF().getDocument())
			 || e.getDocument().equals(menu.getPrenomTF().getDocument())
			 || e.getDocument().equals(menu.getAdresseTF().getDocument()))
			{ menu.autoCompletionClient(); }
			else if (e.getDocument().equals(menu.getImmatTF().getDocument()))
			{ menu.autoCompletionVehicule(); }
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (enabled && !e.getValueIsAdjusting())
		{
			if (e.getSource().equals(menu.getListNom()))
			{
				menu.getNomTF().setText(menu.getListNom().getSelectedValue());
				menu.autoCompletionClient();
			} else if (e.getSource().equals(menu.getListPrenom()))
			{
				menu.getPrenomTF().setText(menu.getListPrenom().getSelectedValue());
				menu.autoCompletionClient();
			} else if (e.getSource().equals(menu.getListAdresse()))
			{
				menu.getAdresseTF().setText(menu.getListAdresse().getSelectedValue());
				menu.autoCompletionClient();
			} else if (e.getSource().equals(menu.getListImmat()))
			{
				menu.getImmatTF().setText(menu.getListImmat().getSelectedValue());
				menu.autoCompletionVehicule();
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
