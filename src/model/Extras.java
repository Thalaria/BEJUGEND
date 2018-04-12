package model;

public class Extras extends Aktivitaeten {

	// Attributes

	private int danachAbziehenPunkte;

	// Constructors definieren
	// Hier wird der super()-Konstruktor der Aktivitaeten-klasse aufgerufen

	public Extras(int id, String name, int habenFürPunkte) {
		super();
		this.aktivitaetId = id;
		this.nameAktivitaet = name;
		this.punktenZahl = habenFürPunkte;
	}

	// Getters und Setters fürs das Attribut "danachAbziehenPunkte" erzeugen.
	public int getDanachAbziehenPunkte() {

		return this.danachAbziehenPunkte;

	}

	public void setDanachAbziehenPunkte(int danachAbziehenPunkte) {

		this.danachAbziehenPunkte = danachAbziehenPunkte;

	}

	// Die toString()- Methode aus der Objekt-Klasse wird überschrieben

	@Override
	public String toString() {

		return "Kind: " + aktivitaetId + " " + nameAktivitaet + " " + punktenZahl + " " + danachAbziehenPunkte;

	}

}// Ende class Extras
