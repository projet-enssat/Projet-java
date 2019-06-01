package menu;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Menu {
	public JPanel bouton(String nom) {
		JPanel panel = new JPanel();
		FlowLayout pospanel = new FlowLayout();
		panel.setLayout(pospanel);
		JButton bouton = new JButton(nom);
		bouton.addActionListener(new Action());
		panel.add(bouton);
		return panel;
	}
	
	public JPanel vide() {
		JPanel vide = new JPanel();
		FlowLayout espaceVide = new FlowLayout();
		vide.setLayout(espaceVide);
		return vide;
	}
	
	public JPanel textField(String nom) {
		JPanel panelSec = new JPanel();
		GridLayout posPanelS = new GridLayout(3,1);
		panelSec.setLayout(posPanelS);
		panelSec.add(vide());
		JTextField text = new JTextField();
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
