package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Korisnik;
import models.NaplatnaStanica;
import models.NaplatnoMesto;
import models.Sistem;
import models.TipKorisnika;
import view.NaplatnoMestoView;
import view.OperaterLoginView;

public class LoginOperaterController {

	private OperaterLoginView view;
	
	private Korisnik operater;
	private NaplatnaStanica stanica;
	private NaplatnoMesto mesto;
	
	public LoginOperaterController(OperaterLoginView view) {
		this.view = view;
		
		setLoginListener();
	}
	
	private void setLoginListener() {
		view.setButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user = view.getUsername();
				String pass = view.getPassword();
				String mestoString = view.getMesto();
				
				for (Korisnik k : Sistem.getInstance().korisnici) {
					if (user.equals(k.getKorisnickoIme()) && pass.equals(k.getSifra()) && k.getTip().equals(TipKorisnika.OPERATER)) {
						operater = k;
					}
				}
				
				if (operater == null) {
					view.showWrongUserDialog();
					return;
				}
				
				String[] tokens = mestoString.split(" : ");
				
				String[] tokens2 = tokens[0].split(". ");
				
				for (NaplatnaStanica ns : Sistem.getInstance().stanice) {
					if (ns.getNazivStanice().equals(tokens[1])) {
						stanica = ns;
						break;
					}
				}
				
				for (NaplatnoMesto nm : Sistem.getInstance().naplatnaMesta) {
					if (nm.getId().equals(tokens2[2])) {
						mesto = nm;
						break;
					}
				}
				view.setVisible(false);
				MestoController controller = new MestoController(operater, stanica, mesto);
				NaplatnoMestoView view = new NaplatnoMestoView(stanica);
				controller.setView(view);
				
			}
			
		});
	}
}
