package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controller.AdminController;

public class AdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int NUM_TABS = 4;
	private static final int WIDTH    = 640;
	private static final int HEIGHT   = 480;
	
	private JTabbedPane tabPane;
	
	private JPanel[] panels;
	private JTable[] dataTables;
	
	private JButton btnUnos, btnBrisanje, btnIzmena;
	private JButton btnOdjava;
	
	// TODO: cim se otvori prozor tabele se nece prikazati jer
	// se one ocitavaju kada se promeni tab
	
	public AdminView() {
		setTitle("Sistem naplatnih stanica - Administrator");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(true);
		
		dataTables = new JTable[NUM_TABS];
		panels = new JPanel[NUM_TABS];
		
		createPanels();
		createButtons();
		initDataTables();
		
		initToolbar();
		initTabs();
		
		setVisible(true);
	}
	
	private void createPanels() {
		for (int i = 0; i < panels.length; ++i) {
			panels[i] = new JPanel();
		}
	}
	
	private void createButtons() {
		btnUnos = new JButton("Unos");
		btnBrisanje = new JButton("Brisanje");
		btnIzmena = new JButton("Izmena");
		btnOdjava = new JButton("Odjavi se");
	}
	
	private void initToolbar() {
		JToolBar toolbar = new JToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		toolbar.add(btnUnos);
		toolbar.add(btnIzmena);
		toolbar.add(btnBrisanje);
		toolbar.addSeparator();
		toolbar.add(btnOdjava);
	}
	
	private void initDataTables() {
		for (int i = 0; i < dataTables.length; ++i) {
			dataTables[i] = new JTable();
			panels[i].add(dataTables[i]);
		}
	}
	
	private void initTabs() {
		tabPane = new JTabbedPane();
		
		tabPane.addTab("Korisnici", panels[0]);
		tabPane.addTab("Nap.stanice", panels[1]);
		tabPane.addTab("Nap.mesta", panels[2]);
		tabPane.addTab("Deonice", panels[3]);
		
		add(tabPane, BorderLayout.CENTER);
	}
	
	public void setTabChangeListener(ChangeListener cl) {
		tabPane.addChangeListener(cl);
	}
	
	public int getSelectedTab() {
		return tabPane.getSelectedIndex();
	}
	
	public void btnIzmeniEnable(boolean state) {
		btnIzmena.setEnabled(state);
	}
	
	public void setDataToTable(int tab, String[] header, Object[][] data) {
		dataTables[tab].setModel(new DefaultTableModel(data, header));
	}
	
	// Samo za testiranje
	public static void main(String[] args) {
		AdminView view = new AdminView();
		AdminController controller = new AdminController(view);
	}
}