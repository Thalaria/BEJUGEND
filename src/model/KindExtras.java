package model;

import java.util.Date;

public class KindExtras {

	// Private Attributes
	
	private Date eintragsDatum;
	private int kindNr;
	private int extrasNr;
	
	// Konstruktoren
	
	public KindExtras() { }
	
	public KindExtras(int extrasNr) {
		
		this.kindNr = extrasNr;
		
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

	public int getExtrasNr() {
		
		return this.extrasNr;
		
	}

	public void setExtrasNr(int extrasNr) {
		
		this.extrasNr = extrasNr;
		
	}
	
	// Methoden
	
	@Override
	public String toString() {
		
		return "Kind: " + eintragsDatum + " " + kindNr + " " + extrasNr;
		
	}
	
} // Ende der Klasse KindExtras
