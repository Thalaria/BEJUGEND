package model;

public class AngenehmeAktivitaeten {

	// Attributes
	
	private int angenehmeId;
	private String nameAngenehm;
	private int plusPunkteZahl;
	
	// Constructors
	
	public AngenehmeAktivitaeten() {
	}
	
	public AngenehmeAktivitaeten(int angenehmeId) {
		
		this.angenehmeId = angenehmeId;
		
	}
	
	// Getters & Setters
	
	public int getAngenehmeId() {
		
		return this.angenehmeId;
		
	}

	public void setAngenehmeId(int angenehmeId) {
		
		this.angenehmeId = angenehmeId;
		
	}

	public String getName() {
		
		return this.nameAngenehm;
		
	}

	public void setName(String nameAngenehm) {
		
		this.nameAngenehm = nameAngenehm;
		
	}

	public int getPlusPunkteZahl() {
		
		return this.plusPunkteZahl;
		
	}

	public void setPlusPunkteZahl(int plusPunkteZahl) {
		
		this.plusPunkteZahl = plusPunkteZahl;
		
	}
	
	// Methods
	
	@Override
	public String toString() {
		
		return "Kind: " + angenehmeId + " " + nameAngenehm + " " + plusPunkteZahl;
		
	}
	
}
