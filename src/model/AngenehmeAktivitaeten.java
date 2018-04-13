package model;

import java.util.Date;

public class AngenehmeAktivitaeten extends Aktivitaeten {

	// Attributes

	// Constructors - hier wird der super()-Konstruktor der Aktivitaeten-klasse
	// aufgerufen

	public AngenehmeAktivitaeten(int id, String name, int punkte, Date datum) {

		super();

		this.aktivitaetId = id;
		this.nameAktivitaet = name;
		this.punktenZahl = punkte;
		this.eintragsDatum = datum;
	}

	// Die toString()- Methode aus der Objekt-Klasse wird überschrieben
	@Override
	public String toString() {

		return "AngenehmeAktivitaeten: " + aktivitaetId + " " + nameAktivitaet + " " + punktenZahl + " "
				+ eintragsDatum;

	}

} // Ende der Klasse AngenehmeAktivitaeten
