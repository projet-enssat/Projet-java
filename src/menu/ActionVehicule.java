package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vehicule.GestionVehicule;

public class ActionVehicule implements ActionListener, ListSelectionListener, DocumentListener
{
	MenuVehicule menu;
	boolean enabled;

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
				menu.getFenetreChoix().dispose();
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
						menu.Voiture(nom);
						break;
					case 2:
						if (menu.isNouveau())
						{
							nom = "Nouvelle Moto";
						} else
						{
							nom = "Supprimer Moto";
						}
						menu.Moto(nom);
						break;
					case 3:
						if (menu.isNouveau())
						{
							nom = "Nouvel Avion";
						} else
						{
							nom = "Supprimer Avion";
						}
						menu.Avion(nom);
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
			} else if (e.getSource().equals(menu.getChoixV()) && !menu.isNouveau())
			{
				menu.autoCompletion();
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
			}
			if (e.getSource().equals(menu.getChoixMod()))
			{
				menu.setTexteMod((menu.getChoixMod().getSelectedValue()));
				menu.autoCompletion();
			}
			if (e.getSource().equals(menu.getChoixImm()))
			{
				System.out.println(menu.getChoixImm().getSelectedValue());
				menu.setTexteImm((menu.getChoixImm().getSelectedValue()));
				menu.autoCompletion();
			}
		}
	}
	
	public void toggle()
	{
		enabled = !enabled;
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		menu.autoCompletion();
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		menu.autoCompletion();
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		menu.autoCompletion();
	}
}
