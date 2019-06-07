package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.Menu;
import menu.MenuClient;

/**
 * Permet la gestion d'evenements declenches par le menu client.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class ActionClient implements ActionListener, ListSelectionListener, DocumentListener
{
	/**
	 * Menu a ecouter.
	 */
	MenuClient menu;
	/** (Des)active la reaction aux evenements. */
	boolean enabled = true;
	boolean test = false; // DEBUGGING PURPOSE
	
	/**
	 * Constructeur.
	 * @param menu Menu a ecouter.
	 */
	public ActionClient(Menu menu)
	{
		this.menu = (MenuClient) menu;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (enabled)
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
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (enabled && !e.getValueIsAdjusting())
		{
			if (e.getSource().equals(menu.getListNom()))
			{
				menu.getNomClient().setText(menu.getListNom().getSelectedValue());
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getListPrenom()))
			{
				menu.getPrenom().setText(menu.getListPrenom().getSelectedValue());
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getListAdresse()))
			{
				menu.getAdresse().setText(menu.getListAdresse().getSelectedValue());
				menu.autoCompletion();
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

	/**
	 * Toggles the action listener. Used for autocompletion.
	 */
	public void toggle()
	{
		enabled = !enabled;
	}
}
