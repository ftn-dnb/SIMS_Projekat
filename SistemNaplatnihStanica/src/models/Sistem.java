package models;

import java.util.ArrayList;

import utils.JSONReader;
import utils.JSONReaderStanice;

public class Sistem {

	private static Sistem instance;
	
	public static ArrayList<Korisnik> korisnici;
	public static ArrayList<NaplatnaStanica> stanice;
	
	public static Sistem getInstance() {
		if (instance == null) {
			instance = new Sistem();
		}
		return instance;
	}
	
	private Sistem() {
		korisnici = JSONReader.procitajKorisnike("data/korisnici.json");
		stanice = JSONReaderStanice.procitajStanice("data/stanice.json", this);
		
	}
}
