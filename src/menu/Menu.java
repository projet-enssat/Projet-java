package menu;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public abstract class Menu {
	
	public JPanel bouton(JButton bouton) {
		JPanel panel = new JPanel();
		FlowLayout pospanel = new FlowLayout();
		panel.setLayout(pospanel);
		panel.add(bouton);
		return panel;
	}
	
	public JPanel vide() {
		JPanel vide = new JPanel();
		FlowLayout espaceVide = new FlowLayout();
		vide.setLayout(espaceVide);
		return vide;
	}
	
	public JPanel comboBoxV(JComboBox<String> comboBox)
	{
		JPanel panel = new JPanel();
		FlowLayout pospanel = new FlowLayout();
		panel.setLayout(pospanel);
		panel.add(comboBox);
		return panel;
	}
	
	public JPanel textField(String nom, JTextField text) {
		JPanel panelSec = new JPanel();
		GridLayout posPanelS = new GridLayout(3,1);
		panelSec.setLayout(posPanelS);
		panelSec.add(vide());
		panelSec.add(text);
		

		JPanel panelTer = new JPanel();
		GridLayout posPanelT = new GridLayout(1,3);
		panelTer.setLayout(posPanelT);
		panelTer.add(vide());
		JLabel label = new JLabel(nom);
		panelTer.add(label);
		
		JPanel panelPrinc = new JPanel();
		GridLayout posPanelP = new GridLayout(1,2);
		panelPrinc.setLayout(posPanelP);
		panelPrinc.add(panelTer);
		panelPrinc.add(panelSec);
		return panelPrinc;
	}
	
}
