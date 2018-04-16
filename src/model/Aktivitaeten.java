package model;

import java.util.Date;

// Eine abstrakte Klasse von Aktivitaeten wird definiert.

abstract class Aktivitaeten {

	// Private Attribute
	
	protected int aktivitaetId;
	protected String nameAktivitaet;
	protected int punktenZahl;
	protected Date eintragsDatum;

	// Getters & Setters

	public int getAktivitaetId() {
		
		return aktivitaetId;
		
	}

	public void setAktivitaetId(int aktivitaetId) {
		
		this.aktivitaetId = aktivitaetId;
		
	}

	public String getNameAktivitaet() {
		
		return this.nameAktivitaet;
		
	}

	public void setNameAktivitaet(String nameAktivitaet) {
		
		this.nameAktivitaet = nameAktivitaet;
		
	}

	public int getPunktenZahl() {
		
		return punktenZahl;
		
	}

	public void setPunktenZahl(int punktenZahl) {
		
		this.punktenZahl = punktenZahl;
		
	}

	public Date getEintragsDatum() {
		
		return eintragsDatum;
		
	}

	public void setEintragsDatum(Date eintragsDatum) {
		
		this.eintragsDatum = eintragsDatum;
		
	}

} //Ende der Klasse Aktivitaeten
