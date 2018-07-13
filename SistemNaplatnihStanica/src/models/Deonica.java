package models;

public class Deonica {
	
	private NaplatnaStanica stanica1;
	private NaplatnaStanica stanica2;
	
	private Cenovnik cenovnik;
	private int idDeonice;
	
	static private int id = 0;
	
	private Deonica() {}
	
	public Deonica(NaplatnaStanica s1, NaplatnaStanica s2, int cena) {
		idDeonice = ++id;
		stanica1 = s1;
		stanica2 = s2;
		cenovnik = new Cenovnik();
		izmeniCenovnik(TipVozila.MOTOR, cena);
		izmeniCenovnik(TipVozila.AUTO, cena+200);
		izmeniCenovnik(TipVozila.LAKO_TERETNO_VOZILO, cena+300);
		izmeniCenovnik(TipVozila.AUTOBUS, cena+700);
		izmeniCenovnik(TipVozila.TESKO_TERETNO_VOZILO, cena+1200);
	}
	
	public Deonica(NaplatnaStanica s1, NaplatnaStanica s2) {
		idDeonice = ++id;
		stanica1 = s1;
		stanica2 = s2;
		cenovnik = new Cenovnik();
		int cena = 200;
		izmeniCenovnik(TipVozila.MOTOR, cena);
		izmeniCenovnik(TipVozila.AUTO, cena+200);
		izmeniCenovnik(TipVozila.LAKO_TERETNO_VOZILO, cena+300);
		izmeniCenovnik(TipVozila.AUTOBUS, cena+700);
		izmeniCenovnik(TipVozila.TESKO_TERETNO_VOZILO, cena+1200);
	}
	
	public void izmeniCenovnik(TipVozila tip, int cena) {
		cenovnik.cene.put(tip, cena);
	}
	
	public int getId() {
		return idDeonice;
	}

	public NaplatnaStanica getStanica1() {
		return stanica1;
	}

	public NaplatnaStanica getStanica2() {
		return stanica2;
	}
	
	public int procitajCenovnik(TipVozila tip) {
		return cenovnik.cene.get(tip);
	}
	
}
