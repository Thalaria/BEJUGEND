package model;

public class UnangenehmeAktivitaeten {

	// Attributes
	
	private int unangenehmeId;
	private String nameUnangenehm;
	private int minusPunktenZahl;
	
	// Constructors
	
	public UnangenehmeAktivitaeten() {
	}
	
	public UnangenehmeAktivitaeten(int unangenehmeId) {
		
		this.unangenehmeId = unangenehmeId;
		
	}
	
	// Getters & Setters
	
	public int getUnangenehmeId() {
		
		return this.unangenehmeId;
		
	}

	public void setUnangenehmeId(int unangenehmeId) {
		
		this.unangenehmeId = unangenehmeId;
		
	}

	public String getNameUnangenehm() {
		
		return this.nameUnangenehm;
		
	}

	public void setNameUnangenehm(String nameUnangenehm) {
		
		this.nameUnangenehm = nameUnangenehm;
		
	}

	public int getMinusPunktenZahl() {
		
		return this.minusPunktenZahl;
		
	}

	public void setMinusPunktenZahl(int minusPunktenZahl) {
		
		this.minusPunktenZahl = minusPunktenZahl;
		
	}
	
	// Methods
	
	@Override
	public String toString() {
		
		return "Kind: " + unangenehmeId + " " + nameUnangenehm + " " + minusPunktenZahl;
		
	}
	
}
