package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.MestoController;
import models.NaplatnaStanica;

public class NaplatnoMestoView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private DeonicaPanel deonicaPanel;
	private RampaPanel rampaPanel;
	private Toolbar toolbar;

	public NaplatnoMestoView(NaplatnaStanica stanica) {
		
		super("Naplatno mesto");
		
		toolbar = new Toolbar();
		deonicaPanel = new DeonicaPanel(stanica);
		rampaPanel = new RampaPanel();
		
		setLayout(new BorderLayout());
		
		add(toolbar, BorderLayout.NORTH);
		add(deonicaPanel, BorderLayout.WEST);
		add(rampaPanel, BorderLayout.CENTER);
		
		setSize(460, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public Toolbar getToolbar() {
		return toolbar;
	}
	
	public RampaPanel getRampaPanel() {
		return rampaPanel;
	}
	
	public DeonicaPanel getDeonicaPanel() {
		return deonicaPanel;
	}
}
