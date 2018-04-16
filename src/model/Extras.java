package model;

import java.util.Date;

public class Extras extends Aktivitaeten {

	// Private Attribute

	// Nachdem diese Extra-Aktivität durchgeführt wurde, werden die u.s. Punkte
	// abgezogen
	
	private int danachAbziehenPunkte;

	// Konstruktoren
	
	// Hier wird der super()-Konstruktor der Aktivitaeten-klasse aufgerufen

	public Extras() { }

	public Extras(int id, String name, int habenFuerPunkte, int danachAbziehenPunkte, Date datum) {
		
		super();
		
		this.aktivitaetId = id;
		this.nameAktivitaet = name;
		this.punktenZahl = habenFuerPunkte;
		this.danachAbziehenPunkte = danachAbziehenPunkte;
		this.eintragsDatum = datum;
		
	}

	// Getters und Setters fürs das Attribut "danachAbziehenPunkte" erzeugen
	
	public int getDanachAbziehenPunkte() {
		
		return this.danachAbziehenPunkte;
		
	}

	public void setDanachAbziehenPunkte(int danachAbziehenPunkte) {
		
		this.danachAbziehenPunkte = danachAbziehenPunkte;
		
	}

	// Methoden
	
	// Die toString()- Methode aus der Objekt-Klasse wird überschrieben

	@Override
	public String toString() {
		
		return "Extras: " + aktivitaetId + " " + nameAktivitaet + " " + punktenZahl + " " + eintragsDatum + " "
				+ danachAbziehenPunkte;
		
	}

} // Ende der Klasse Extras
