package models;

import java.util.Date;

public class Kvar {
	
	private static int idCount = 1;

	private TipKvara tipKvara;
	private String opis;
	private int idKvara;
	private Date datum;
	private String idMesta;
	
	public Kvar() {
		
	}
	
	public Kvar(TipKvara tipKvara, String opis, Date datum, String idMesta) {
		super();
		this.tipKvara = tipKvara;
		this.opis = opis;
		this.idKvara = idCount++;
		this.datum = datum;
		this.idMesta = idMesta;
	}

	public TipKvara getTipKvara() {
		return tipKvara;
	}

	public void setTipKvara(TipKvara tipKvara) {
		this.tipKvara = tipKvara;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getIdKvara() {
		return idKvara;
	}

	public void setIdKvara(int idKvara) {
		this.idKvara = idKvara;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getIdMesta() {
		return idMesta;
	}

	@Override
	public String toString() {
		return "Kvar [tipKvara=" + tipKvara + ", opis=" + opis + ", idKvara=" + idKvara + ", datum=" + datum
				+ ", idMesta=" + idMesta + "]";
	}

	
}
