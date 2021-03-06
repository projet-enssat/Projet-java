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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Classe abstraite dont heritent toutes celles utilisees pour l'affichage Swing (Menu*.java).
 * @author Celia Ellmann
 * @author Dejan Paris
 */
public abstract class Menu
{
	/**
	 * Incruste un JButton dans un JPanel pour en reduire la taille.
	 * @param bouton JButton a incruster.
	 * @return JPanel contenant le JButton entoure d'espace vide.
	 */
	public JPanel bouton(JButton bouton)
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(bouton);
		return panel;
	}
	
	/**
	 * Incruste un JLabel dans un JPanel.
	 * @param label JLabel a incruster
	 * @return JPanel contenant le JLabel.
	 */
	public JPanel label(JLabel label)
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(label);
		return panel;
	}

	/**
	 * Genere un JPanel vide.
	 * @return JPanel vide.
	 */
	public JPanel vide()
	{
		JPanel vide = new JPanel(new FlowLayout());
		return vide;
	}

	/**
	 * Incruste une JComboBox dans un JPanel pour en reduire la taille.
	 * @param comboBox JComboBox a incruster.
	 * @return JPanel contenant la JComboBox entouree d'espace vide.
	 */
	public JPanel comboBoxV(JComboBox<String> comboBox)
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(comboBox);
		return panel;
	}
	/**
	 * Incruste une JComboBox dans un JPanel pour en reduire la taille.
	 * @param comboBox JComboBox a incruster.
	 * @return JPanel contenant la JComboBox entouree d'espace vide.
	 */
	public JPanel comboBoxV2(JComboBox<String> comboBox)
	{
		JPanel panel = new JPanel(new GridLayout(3,3));
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
	
	/**
	 * Fenetre popup d'erreur.
	 * @param nom Titre de la fenetre.
	 * @param ligne1 Texte d'erreur.
	 * @param ligne2 Texte d'explications.
	 */
	public void Erreur(String nom, String ligne1, String ligne2) {
		JFrame erreur = new JFrame(nom);
		erreur.setSize(500,200);
		erreur.setLocationRelativeTo(null);
		erreur.setLayout(new GridLayout(2,1));
		erreur.add(new JLabel(ligne1));
		erreur.add(new JLabel(ligne2));
		erreur.setVisible(true);
	}
	
	/**
	 * Incruste une JList dans un JPanel pour en reduire la taille.
	 * @param list JList a incruster.
	 * @return JPanel contenant la JList entouree d'espace vide.
	 */
	public JPanel listV(JList<String> list)
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(list);
		return panel;
	}
	
	/**
	 * Incruste un JScrollPane dans un JPanel pour en reduire la taille.
	 * @param jsp JScrollPane a incruster.
	 * @return JPanel contenant le JScrollPane entouree d'espace vide.
	 */
	public JPanel jspV(JScrollPane jsp)
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(jsp);
		return panel;
	}

	/**
	 * Incruste un JTextField dans un JPanel pour en reduire la taille, en ajoutant un JLabel au-dessus.
	 * @param tf JTextField a incruster.
	 * @param nom JLabel a ajouter.
	 * @return JPanel contenant le JTextField au centre, le JLabel au-dessus, entoures d'espace vide.
	 */
	public JPanel textFieldLabelAbove(JTextField tf, String nom)
	{
		JPanel insidePanel = new JPanel(new BorderLayout());
		insidePanel.add(vide(), BorderLayout.EAST);
		insidePanel.add(vide(), BorderLayout.WEST);
		insidePanel.add(tf, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(new JLabel(nom, 0));
		panel.add(insidePanel);
		return panel;
	}
	
	/**
	 * Incruste un JPanel dans un JPanel pour en reduire la taille, en ajoutant un JLabel au-dessus.
	 * @param p JPanel a incruster.
	 * @param nom JLabel a ajouter.
	 * @return JPanel contenant le JTextField au centre, le JLabel au-dessus, entoures d'espace vide.
	 */
	public JPanel panelLabelAbove(JPanel p, String nom)
	{
		JPanel insidePanel = new JPanel(new BorderLayout());
		insidePanel.add(vide(), BorderLayout.EAST);
		insidePanel.add(vide(), BorderLayout.WEST);
		insidePanel.add(p, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(new JLabel(nom, 0));
		panel.add(insidePanel);
		return panel;
	}

	/**
	 * Incruste un JTextField dans un JPanel pour en reduire la taille, en ajoutant un JLabel a gauche.
	 * @param tf JTextField a incruster.
	 * @param nom JLabel a ajouter.
	 * @return JPanel contenant le JTextField au centre, le JLabel a gauche, entoures d'espace vide.
	 */
	public JPanel textFieldLabelLeft(String nom, JTextField tf)
	{
		JPanel panelQuad = new JPanel(new BorderLayout());
		panelQuad.add(vide(), BorderLayout.EAST);
		panelQuad.add(tf, BorderLayout.CENTER);
		
		JPanel panelSec = new JPanel(new GridLayout(3, 1));
		panelSec.add(vide());
		panelSec.add(panelQuad);

		JPanel panelTer = new JPanel(new GridLayout(1, 3));
		panelTer.add(vide());
		JLabel label = new JLabel(nom);
		panelTer.add(label);

		JPanel panelPrinc = new JPanel(new GridLayout(1, 2));
		panelPrinc.add(panelTer);
		panelPrinc.add(panelSec);
		return panelPrinc;
	}

}
