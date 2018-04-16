package model;

import java.util.Date;

public class AngenehmeAktivitaeten extends Aktivitaeten {

	// Konstruktoren - Hier wird der super()-Konstruktor der Aktivitaeten-Klasse
	// aufgerufen

	public AngenehmeAktivitaeten() { }
	
	public AngenehmeAktivitaeten(int id, String name, int punkte, Date datum) {

		super();

		this.aktivitaetId = id;
		this.nameAktivitaet = name;
		this.punktenZahl = punkte;
		this.eintragsDatum = datum;
		
	}

	// Methoden
	
	// Die toString()- Methode aus der Objekt-Klasse wird überschrieben
	
	@Override
	public String toString() {

		return "AngenehmeAktivitaeten: " + aktivitaetId + " " + nameAktivitaet + " " + punktenZahl + " "
				+ eintragsDatum;

	}

} // Ende der Klasse AngenehmeAktivitaeten
