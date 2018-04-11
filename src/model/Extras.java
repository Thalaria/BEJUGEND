package model;

public class Extras {

	// Attributes
	
	private int extrasId;
	private String nameExtra;
	private int habenFuerPunkte;
	private int danachAbziehenPunkte;
	
	// Constructors
	
	public Extras() {
	}
	
	public Extras(int extrsaId) {
		
		this.extrasId = extrasId;
		
	}
	
	// Getters & Setters
	
	public int getExtraId() {
		
		return this.extrasId;
		
	}

	public void setExtraId(int extraId) {
		
		this.extrasId = extraId;
		
	}

	public String getNameExtra() {
		
		return this.nameExtra;
		
	}

	public void setNameExtra(String nameExtra) {
		
		this.nameExtra = nameExtra;
		
	}

	public int getHabenFuerPunkte() {
		
		return this.habenFuerPunkte;
		
	}

	public void setHabenFuerPunkte(int habenFuerPunkte) {
		
		this.habenFuerPunkte = habenFuerPunkte;
		
	}

	public int getDanachAbziehenPunkte() {
		
		return this.danachAbziehenPunkte;
		
	}

	public void setDanachAbziehenPunkte(int danachAbziehenPunkte) {
		
		this.danachAbziehenPunkte = danachAbziehenPunkte;
		
	}
	
	// Methods
	
	@Override
	public String toString() {
		
		return "Kind: " + extrasId + " " + nameExtra + " " + habenFuerPunkte + " " + danachAbziehenPunkte;
		
	}
	
}
