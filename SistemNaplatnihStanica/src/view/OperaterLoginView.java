package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.NaplatnaStanica;
import models.NaplatnoMesto;
import models.Sistem;

public class OperaterLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField usernameField;
	private JTextField passwordField;
	private JComboBox<String> mestoCombo;
	
	private JButton btnLogin;
	
	private JPanel mainPanel;
	
	public OperaterLoginView() {
		super("Login Operater");
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		usernameField = new JTextField(20);
		passwordField = new JTextField(20);
		
		btnLogin = new JButton("Login");
		
		mestoCombo = new JComboBox<String>();
		mestoCombo.setPreferredSize(new Dimension(260, 30));
		DefaultComboBoxModel<String> empM = new DefaultComboBoxModel<String>();
		
		for (NaplatnoMesto nm : Sistem.getInstance().naplatnaMesta) {
			NaplatnaStanica nadredjena = null;
			for (NaplatnaStanica ns : Sistem.getInstance().stanice) {
				if (nm.getIdStanice() == ns.getIdStanice()) {
					nadredjena = ns;
				}
			}
			
			empM.addElement("Mesto br. " + nm.getId() + " : " + nadredjena.getNazivStanice());
		}
		mestoCombo.setModel(empM);
		
		mainPanel = new JPanel();
		
		layoutSetup();
		
		add(mainPanel);
	}
	
	private void layoutSetup() {
		mainPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(5, 5, 0, 0);
		mainPanel.add(new JLabel("Username: "), gc);
		
		gc.weightx = 1.5;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(5, 0, 0, 5);
		mainPanel.add(usernameField, gc);
		
		gc.weightx = 1.5;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0, 5, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		mainPanel.add(new JLabel("Password: "), gc);
		
		gc.weightx = 2;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(0, 0, 0, 5);
		mainPanel.add(passwordField, gc);
		
		gc.weightx = 2;
		gc.weighty = 3;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 10, 0, 5);
		mainPanel.add(mestoCombo, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		mainPanel.add(btnLogin, gc);
	}
	
	public void setButtonListener(ActionListener actionListener) {
		btnLogin.addActionListener(actionListener);
	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
	
	public String getMesto() {
		return (String)mestoCombo.getSelectedItem();
	}
	
	public void showWrongUserDialog() {
		JOptionPane.showMessageDialog(null, "Uneto pogresno korisnicko ime, lozinka ili tip korisnika. Korisnik mora biti operater.",
				"Greska", JOptionPane.ERROR_MESSAGE);
	}
}
