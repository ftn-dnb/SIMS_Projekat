package models;

import models.stanja.rampa.*;

public class Rampa {
	
	public Rampa() {
		tekuceStanje = new RampaSpustena();
	}
	
	public void aktivirajMotor(int smer) {
		
	}
	
	public void iskljuciMotor() {
		
	}
	
	public boolean proveraSenzoraZaVisinu() {
		
		return false;
	}
	
	public void promeniStanje(StanjeRampe stanje) {
		tekuceStanje = stanje;
	}
	
	private StanjeRampe tekuceStanje;
}
