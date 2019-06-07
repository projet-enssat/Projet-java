package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		if(enabled && !e.getValueIsAdjusting()) {
			if((String) ((JList<String>) e.getSource()).getSelectedValue()!=null) {
				menu.autoCompletion(((JList<String>) e.getSource()).getSelectedValue());
			}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		if (enabled)
		{
			if(e.getDocument().equals(menu.getNomDocument())) {
				menu.refreshNom();
			}else if(e.getDocument().equals(menu.getPrenomDocument())) {
				menu.refreshPrenom();
			}else {
				menu.refreshAdresse();
			}
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		if(e.getDocument().equals(menu.getNomDocument())) {
			menu.refreshNom();
		}else if(e.getDocument().equals(menu.getPrenomDocument())) {
			menu.refreshPrenom();
		}else if(e.getDocument().equals(menu.getAdresseDocument())) {
			menu.refreshAdresse();
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
