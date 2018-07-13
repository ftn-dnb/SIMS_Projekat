package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import models.Deonica;
import models.NaplatnaStanica;

public class DeonicaPanel extends JPanel {
	
	private JLabel deonicaLabel;
	private JComboBox<String> comboDeonica;

	private JRadioButton radioKat1;
	private JRadioButton radioKat2;
	private JRadioButton radioKat3;
	private JRadioButton radioKat4;
	private JRadioButton radioKat5;
	private ButtonGroup katGroup;
	
	private DeonicaListener deonicaListener;
	
	
	public DeonicaPanel(NaplatnaStanica stanica) {
		setPreferredSize(new Dimension(240, 100));
		setBorder(BorderFactory.createTitledBorder("Info o deonici"));
		
		deonicaLabel = new JLabel("Deonica: ");
		
		comboDeonica = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (Deonica d : stanica.getDeonice()) {
			if (d.getStanica2() == stanica) {
				model.addElement(d.getStanica1().getNazivStanice());
			} else {
				model.addElement(d.getStanica2().getNazivStanice());
			}
		}
		comboDeonica.setModel(model);
		comboDeonica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deonicaListener.deonicaListenerOccured((String)comboDeonica.getSelectedItem(), katGroup.getSelection().getActionCommand());
			}
			
		});
		
		radioKat1 = new JRadioButton("Kat1");
		radioKat1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deonicaListener.deonicaListenerOccured((String)comboDeonica.getSelectedItem(), katGroup.getSelection().getActionCommand());
			}
			
		});
		radioKat1.setActionCommand("MOTOR");
		radioKat1.setSelected(true);
		radioKat2 = new JRadioButton("Kat2");
		radioKat2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deonicaListener.deonicaListenerOccured((String)comboDeonica.getSelectedItem(), katGroup.getSelection().getActionCommand());
			}
			
		});
		radioKat2.setActionCommand("AUTO");
		radioKat3 = new JRadioButton("Kat3");
		radioKat3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deonicaListener.deonicaListenerOccured((String)comboDeonica.getSelectedItem(), katGroup.getSelection().getActionCommand());
			}
			
		});
		radioKat3.setActionCommand("LAKO_TERETNO_VOZILO");
		radioKat4 = new JRadioButton("Kat4");
		radioKat4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deonicaListener.deonicaListenerOccured((String)comboDeonica.getSelectedItem(), katGroup.getSelection().getActionCommand());
			}
			
		});
		radioKat4.setActionCommand("AUTOBUS");
		radioKat5 = new JRadioButton("Kat5");
		radioKat5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deonicaListener.deonicaListenerOccured((String)comboDeonica.getSelectedItem(), katGroup.getSelection().getActionCommand());
			}
			
		});
		radioKat5.setActionCommand("TESKO_TERETNO_VOZILO");
		katGroup = new ButtonGroup();
		katGroup.add(radioKat1);
		katGroup.add(radioKat2);
		katGroup.add(radioKat3);
		katGroup.add(radioKat4);
		katGroup.add(radioKat5);
		
		layoutSetup();
	}
	
	public void layoutSetup() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(10, 0, 0, 0);
		add(deonicaLabel, gc);
		
		gc.weightx = 5;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(10, 0, 0, 10);
		add(comboDeonica, gc);
		
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		add(radioKat1, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(radioKat2, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(radioKat3, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(radioKat4, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		add(radioKat5, gc);
		
		ImageIcon icon = new ImageIcon("data/Iakat.png");
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(icon), gc);
		
		ImageIcon icon1 = new ImageIcon("data/Ikat.png");
		gc.gridx = 1;
		gc.gridy = 2;
		add(new JLabel(icon1), gc);
		
		ImageIcon icon2 = new ImageIcon("data/IIkat.png");
		gc.gridx = 1;
		gc.gridy = 3;
		add(new JLabel(icon2), gc);
		
		ImageIcon icon3 = new ImageIcon("data/IIIkat.png");
		gc.gridx = 1;
		gc.gridy = 4;
		add(new JLabel(icon3), gc);
		
		ImageIcon icon4 = new ImageIcon("data/IVkat.png");
		gc.gridx = 1;
		gc.gridy = 5;
		add(new JLabel(icon4), gc);
	}
	
	public void setDeonicaListener(DeonicaListener deonicaListener) {
		this.deonicaListener = deonicaListener;
	}
}
