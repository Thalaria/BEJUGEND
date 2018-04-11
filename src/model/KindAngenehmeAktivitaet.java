package model;

import java.util.Date;

public class KindAngenehmeAktivitaet {
	
	// Attributes

	private Date eintragsDatum;
	private int kindNr;
	private int angenemeAktivitaetNr;
	
	// Constructors

	public KindAngenehmeAktivitaet() {
	}
	
	public KindAngenehmeAktivitaet(Kind kind) {
	
		int t = kind.getKindID();
		this.kindNr = t;
		
	}
	
	public KindAngenehmeAktivitaet(int kindId) {
		
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

	public int getAngenemeAktivitaetNr() {
		
		return this.angenemeAktivitaetNr;
		
	}

	public void setAngenemeAktivitaetNr(int angenemeAktivitaetNr) {
		
		this.angenemeAktivitaetNr = angenemeAktivitaetNr;
		
	}
	
	// Methods
	
	@Override
	public String toString() {
		
		return "Kind: " + eintragsDatum + " " + kindNr + " " + angenemeAktivitaetNr;
		
	}
	
}
