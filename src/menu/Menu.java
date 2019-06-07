package menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public abstract class Menu
{

	public JPanel bouton(JButton bouton)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(bouton);
		return panel;
	}

	public JPanel vide()
	{
		JPanel vide = new JPanel();
		vide.setLayout(new FlowLayout());
		return vide;
	}

	public JPanel comboBoxV(JComboBox<String> comboBox)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(comboBox);
		return panel;
	}
	
	public JPanel comboBoxV2(JComboBox<String> comboBox)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		panel.add(vide());
		panel.add(vide());
		panel.add(vide());
		panel.add(vide());
		panel.add(comboBox);
		panel.add(vide());
		panel.add(vide());
		panel.add(vide());
		panel.add(vide());
		
		return panel;
	}

	public JPanel listV(JList<String> list)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(list);
		return panel;
	}

	public JPanel textFieldLabelAbove(JTextField tf, String nom)
	{
		JPanel insidePanel = new JPanel();
		insidePanel.setLayout(new BorderLayout());
		insidePanel.add(vide(), BorderLayout.EAST);
		insidePanel.add(vide(), BorderLayout.WEST);
		insidePanel.add(tf, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(new JLabel(nom, 0));
		panel.add(insidePanel);
		return panel;
	}

	public JPanel textFieldLabelLeft(String nom, JTextField tf)
	{
		JPanel panelQuad = new JPanel(new BorderLayout());
		panelQuad.add(vide(), BorderLayout.EAST);
		panelQuad.add(tf, BorderLayout.CENTER);
		
		JPanel panelSec = new JPanel();
		panelSec.setLayout(new GridLayout(3, 1));
		panelSec.add(vide());
		panelSec.add(panelQuad);

		JPanel panelTer = new JPanel();
		panelTer.setLayout(new GridLayout(1, 3));
		panelTer.add(vide());
		JLabel label = new JLabel(nom);
		panelTer.add(label);

		JPanel panelPrinc = new JPanel();
		panelPrinc.setLayout(new GridLayout(1, 2));
		panelPrinc.add(panelTer);
		panelPrinc.add(panelSec);
		return panelPrinc;
	}

}
