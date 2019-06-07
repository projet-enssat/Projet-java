package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.MenuVehicule;

/**
 * Permet la gestion d'evenements declenches par le menu vehicule.
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public class ActionVehicule implements ActionListener, ListSelectionListener, DocumentListener
{
	/**
	 * Menu a ecouter.
	 */
	MenuVehicule menu;
	/** (Des)active la reaction aux evenements. */
	boolean enabled = true;

	/**
	 * Constructeur.
	 * @param menu Menu a ecouter.
	 */
	public ActionVehicule(MenuVehicule menu)
	{
		this.menu = menu;
		enabled = true;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (enabled)
		{
			if (menu.getChoixV().getSelectedIndex() != 0)
			{
				menu.getOK().setEnabled(true);
			} else
			{
				menu.getOK().setEnabled(false);
			}
			if (e.getSource().equals(menu.getOK()))
			{
				menu.getFenetre2().dispose();
				String nom = "";
				switch (menu.getChoixV().getSelectedIndex())
				{
					case 1:
						if (menu.isNouveau())
						{
							nom = "Nouvelle Voiture";
						} else
						{
							nom = "Supprimer Voiture";
						}
						menu.voiture(nom);
						break;
					case 2:
						if (menu.isNouveau())
						{
							nom = "Nouvelle Moto";
						} else
						{
							nom = "Supprimer Moto";
						}
						menu.moto(nom);
						break;
					case 3:
						if (menu.isNouveau())
						{
							nom = "Nouvel Avion";
						} else
						{
							nom = "Supprimer Avion";
						}
						menu.avion(nom);
						break;
					default:
						break;
				}
			} else if (e.getSource().equals(menu.getEnregistrer()))
			{
				String classe = "";
				switch (menu.getChoixV().getSelectedIndex())
				{
					case 1:
						classe = "Voiture";
						break;
					case 2:
						classe = "Moto";
						break;
					case 3:
						classe = "Avion";
						break;
					default:
						break;
				}
				menu.enregistrement(classe);
				menu.getFenetre().dispose();
			} else if (e.getSource().equals(menu.getSupprimer()))
			{
				String classe = "";
				switch (menu.getChoixV().getSelectedIndex())
				{
					case 1:
						classe = "Voiture";
						break;
					case 2:
						classe = "Moto";
						break;
					case 3:
						classe = "Avion";
						break;
					default:
						break;
				}
				menu.validerVehicule(classe);
			} else if (e.getSource().equals(menu.getRechercher())) {
				menu.modifier();
			}else if (e.getSource().equals(menu.getModifier())) {
				menu.enregistrerMod();
			}else if (e.getSource().equals(menu.getChoixV()) && !menu.isNouveau())
			{
				menu.autoCompletion();
				menu.reset();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (enabled && !e.getValueIsAdjusting())
		{
			if (e.getSource().equals(menu.getChoixMar()))
			{
				menu.setTexteMar((menu.getChoixMar().getSelectedValue()));
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getChoixMod()))
			{
				menu.setTexteMod((menu.getChoixMod().getSelectedValue()));
				menu.autoCompletion();
			} else if (e.getSource().equals(menu.getChoixImm()))
			{
				menu.setTexteImm((menu.getChoixImm().getSelectedValue()));
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
}
