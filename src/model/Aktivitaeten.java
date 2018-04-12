package model;

//Eine abstrakte Klasse von Aktivitaeten wird definiert.

abstract class Aktivitaeten {

	// Attribute
	protected int aktivitaetId;
	protected String nameAktivitaet;
	protected int punktenZahl;

	// Deklaration der Methoden der Klasse Aktivitaeten

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

	/*
	 * // Deklaration der toString()-Methode, die aus der Objekt-Klasse vererbt
	 * wird.
	 * 
	 * @Override public abstract String toString();
	 */

} //Ende der Klasse Aktivitaeten