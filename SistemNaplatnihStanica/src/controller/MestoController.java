package controller;

import javax.swing.JLabel;

import models.Deonica;
import models.Korisnik;
import models.NaplatnaStanica;
import models.NaplatnoMesto;
import models.Sistem;
import models.TipVozila;
import view.DeonicaListener;
import view.NaplatnoMestoView;

public class MestoController {
	
	private NaplatnoMestoView view;
	private Korisnik operater;
	private NaplatnaStanica stanica;
	private NaplatnoMesto mesto;
	
	public MestoController(Korisnik operater, NaplatnaStanica stanica, NaplatnoMesto mesto) {
		this.operater = operater;
		this.stanica = stanica;
		this.mesto = mesto;
	}
	
	public void setView(NaplatnoMestoView view) {
		this.view = view;
		
		setDeonicaListener();
	}
	
	public void setDeonicaListener() {
		view.getDeonicaPanel().setDeonicaListener(new DeonicaListener() {

			@Override
			public void deonicaListenerOccured(String deonica, String kategorija) {
				System.out.println(deonica + " " + kategorija);
				JLabel cenaLabel = view.getRampaPanel().getCenaLabel();
				int cena = 0;
				Deonica d = null;
				for (Deonica de : stanica.getDeonice()) {
					if (de.getStanica1() == stanica) {
						if (de.getStanica2().getNazivStanice().equals(deonica)) {
							cena = de.procitajCenovnik(TipVozila.valueOf(kategorija));
							break;
						}
					} else {
						if (de.getStanica1().getNazivStanice().equals(deonica)) {
							cena = de.procitajCenovnik(TipVozila.valueOf(kategorija));
							break;
						}
					}
				}
				cenaLabel.setText(Integer.toString(cena));
			}
			
		});
	}
}
