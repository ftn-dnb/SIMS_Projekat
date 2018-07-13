package models;

import java.util.ArrayList;

import utils.JSONReader;
import utils.JSONReaderStanice;

public class Sistem {

	private static Sistem instance;
	
	public static ArrayList<Korisnik> korisnici;
	public static ArrayList<NaplatnaStanica> stanice;
	public static ArrayList<RegularnoMesto> naplatnaMesta;
	
	public static Sistem getInstance() {
		if (instance == null) {
			instance = new Sistem();
		}
		return instance;
	}
	
	private Sistem() {
		korisnici = JSONReader.procitajKorisnike("data/korisnici.json");
		stanice = JSONReaderStanice.procitajStanice("data/stanice.json", this);
		naplatnaMesta = JSONReader.procitajRegularnaMesta("data/naplatnaMesta.json", this);
		
		System.out.println(stanice);
	}
	
	public static void dodajKorisnika(Korisnik k) {
		if (k == null || korisnici.contains(k))
	        return;
		
	    korisnici.add(k);
	}
	
	public static void obrisiKorisnika(Korisnik k) {
		if (k == null || !korisnici.contains(k))
			return;
		
		korisnici.remove(k);
	}
	
	public static void obrisiKorisnika(int index) {
		if (index >= korisnici.size())
			return;
		
		korisnici.remove(index);
	}
	
	public static void dodajNaplatnoMesto(RegularnoMesto r) {
		if (r == null || naplatnaMesta.contains(r))
			return;
		
		naplatnaMesta.add(r);
	}
	
	public static void obrisiNaplatnoMesto(RegularnoMesto r) {
		if (r == null || !naplatnaMesta.contains(r))
			return;
		
		naplatnaMesta.remove(r);
	}
	
	public static void obrisiNaplatnoMesto(int index) {
		if (index >= naplatnaMesta.size())
			return;
		
		naplatnaMesta.remove(index);
	}
}
