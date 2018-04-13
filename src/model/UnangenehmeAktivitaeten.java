package model;

import java.util.Date;

public class UnangenehmeAktivitaeten extends Aktivitaeten {

	// Attributes

	// Constructors - hier wird der super()-Konstruktor der Aktivitaeten-Klasse
	// aufgerufen

	public UnangenehmeAktivitaeten(int id, String name, int punkte, Date datum) {

		super();

		this.aktivitaetId = id;
		this.nameAktivitaet = name;
		this.punktenZahl = punkte;
		this.eintragsDatum = datum;
	}

	// Die toString()- Methode aus der Objekt-Klasse wird überschrieben

	@Override
	public String toString() {

		return "UnangenehmeAktivitaeten: " + aktivitaetId + " " + nameAktivitaet + " " +   
		         punktenZahl + " " + eintragsDatum;

	}

} //Ende der Klasse UnangenehmeAktivitaeten
