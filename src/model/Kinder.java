package model;

import java.util.ArrayList;

public class Kinder {

	// Private Attribute
	
    // Die Id des Kindes 
	
	private int kindId;
	
	// Das Alter des Kindes 
	
	private int alterKindes;
	
	// Jedes Kind verfügt anhand des Alters über einen Punktenstart
	
	private int punktenStart;

	// Die ArrayList, die mit den AngenehmeAktivitaeten parametrisiert wird
	
	private ArrayList<AngenehmeAktivitaeten> angenehmeAktList = new ArrayList<>();

	// Die ArrayList, die mit den UnangenehmeAktivitaeten parametrisiert wird
	
	private ArrayList<UnangenehmeAktivitaeten> unangenehmeAktList = new ArrayList<>();
	
	// Die ArrayList, die mit den Extra-Aktivitaeten parametrisiert wird
	
	private ArrayList<Extras> extrasAktList = new ArrayList<>();
	
	// Die Summer aller angenehemen Aktivitäten aus der Liste "angenehmeAktList"
	
	private int standAngenehm;
	
	// Die Summe aller unangenehemen Aktivitäten aus der Liste "unangenehmeAktList"
	
	private int standUnangenehm;
	
	// Ein berechneter Wert, der sich aus (punktenStart + standAngenehm - standUnangenehm) zusammensetzt
	
	private int zwischenStand;
	
	// Die Summe aller Extras aus der Liste "extrasAktList"
	
	private int standExtras;
	
	// Dieser Wert gibt die Punktezahl an, die eine Extra-Aktivität "ergattert"
	
	private int habenExtras;
	
	// Dieser Wert wird nach der ausgeführten Extra-Aktivität vom Zwischenstand abgezogen
	
	private int abziehenExtras;
	
	// Dieser Wert wird gibt an, wieviel Punkte das Kind nach ausführen der Extra-Aktiviaet noch übrig hat
	
	private int standNachExtras;
	
	// Konstruktoren

	public Kinder() { }

	public Kinder(int kindId, int alterKindes, int punktStart) {

		this.kindId = kindId;
		this.alterKindes = alterKindes;
		this.punktenStart = punktStart;

	}

	// Getters & Setters

	public int getKindId() {

		return this.kindId;

	}

	public void setKindId(int kindId) {

		this.kindId = kindId;

	}

	public int getAlterKindes() {

		return this.alterKindes;

	}

	public void setAlterKindes(int alterKindes) {

		this.alterKindes = alterKindes;

	}

	public int getPunktenStart() {

		return this.punktenStart;

	}

	public void setPunktenStart(int punktenStart) {

		this.punktenStart = punktenStart;

	}

	public ArrayList<AngenehmeAktivitaeten> getAngenehmeAktList() {
		
		return angenehmeAktList;
		
	}

	public void setAngenehmeAktList(ArrayList<AngenehmeAktivitaeten> angenehmeAktList) {
		
		this.angenehmeAktList = angenehmeAktList;
		
	}

	public ArrayList<UnangenehmeAktivitaeten> getUnangenehmeAktList() {
		
		return unangenehmeAktList;
		
	}

	public void setUnangenehmeAktList(ArrayList<UnangenehmeAktivitaeten> unangenehmeAktList) {
		
		this.unangenehmeAktList = unangenehmeAktList;
		
	}
	
	public ArrayList<Extras> getExtrasAktList() {
		
		return extrasAktList;
		
	}

	public void setExtrasAktList(ArrayList<Extras> extrasAktList) {
		
		this.extrasAktList = extrasAktList;
		
	}
	
	public int getStandAngenehm() {
		
		return standAngenehm;
		
	}

	public void setStandAngenehm(int standAngenehm) {
		
		this.standAngenehm = standAngenehm;
		
	}

	public int getStandUnangenehm() {
		
		return standUnangenehm;
		
	}

	public void setStandUnangenehm(int standUnangenehm) {
		
		this.standUnangenehm = standUnangenehm;
		
	}

	public int getZwischenStand() {
		
		return zwischenStand;
		
	}

	public void setZwischenStand(int zwischenStand) {
		
		this.zwischenStand = zwischenStand;
		
	}

	public int getStandExtras() {
		
		return standExtras;
		
	}

	public void setStandExtras(int standExtras) {
		
		this.standExtras = standExtras;
		
	}

	public int getHabenExtras() {
		
		return this.habenExtras;
		
	}

	public void setHabenExtras(int habenExtras) {
		
		this.habenExtras = habenExtras;
		
	}

	public int getAbziehenExtras() {
		
		return this.abziehenExtras;
		
	}

	public void setAbziehenExtras(int abziehenExtras) {
		
		this.abziehenExtras = abziehenExtras;
		
	}
	
	public int getStandNachExtras() {
		
		return this.standNachExtras;
		
	}

	public void setStandNachExtras(int standNachExtras) {
		
		this.standNachExtras = standNachExtras;
		
	}
	
	// Methoden
	
	// Methode toString(), die vom Objekt gererbt wird, überschreiben

	@Override
	public String toString() {

		return "Das Kind mit der ID: " + kindId + "\n" + alterKindes + "\n " + punktenStart + "\n" + angenehmeAktList + "\n" + unangenehmeAktList + "\n" + extrasAktList;

	}

} // Ende der Klasse Kinder
