package model;

public class UnangenehmeAktivitaeten extends Aktivitaeten {

	// Attributes

	// Constructors - hier wird der super()-Konstruktor der Aktivitaeten-Klasse
	// aufgerufen

	public UnangenehmeAktivitaeten(int id, String name, int punkte) {

		super();

		this.aktivitaetId = id;
		this.nameAktivitaet = name;
		this.punktenZahl = punkte;
	}

	// Die toString()- Methode aus der Objekt-Klasse wird überschrieben

	@Override
	public String toString() {

		return "Kind: " + aktivitaetId + " " + nameAktivitaet + " " + punktenZahl;

	}

}//Ende der Klasse UnangenehmeAktivitaeten
