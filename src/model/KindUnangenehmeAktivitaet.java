package model;

import java.util.Date;

public class KindUnangenehmeAktivitaet {

	// Attributes
	
	private Date eintragsDatum;
	private int kindNr;
	private int unangenehmeAktivitaetNr;
	
	// Constructors
	
	public KindUnangenehmeAktivitaet() {
	}
	
	public KindUnangenehmeAktivitaet(int kindId) {
		
		this.kindNr = kindId;
		
	}
	
	// Getters & Setters
	
	public Date getEintragsDatum() {
		
		return this.eintragsDatum;
		
	}

	public void setEintragsDatum(Date eintragsDatum) {
		
		this.eintragsDatum = eintragsDatum;
		
	}

	public int getKindNr() {
		
		return this.kindNr;
		
	}

	public void setKindNr(int kindNr) {
		
		this.kindNr = kindNr;
		
	}

	public int getUnangenehmeAktivitaetNr() {
		
		return this.unangenehmeAktivitaetNr;
		
	}

	public void setUnangenehmeAktivitaetNr(int unangenehmeAktivitaetNr) {
		
		this.unangenehmeAktivitaetNr = unangenehmeAktivitaetNr;
		
	}
	
	// Methods

	@Override
	public String toString() {
		
		return "Kind: " + eintragsDatum + " " + kindNr + " " + unangenehmeAktivitaetNr;
		
	}
	
}
