package model;

import java.util.ArrayList;
import java.util.List;

public class Kind {

	// Attributes
	
	private int kindId;
	private int alterKindes;
	private int punktenStart;
	
	// Constructors
	
	public Kind() {
	}
	
	public Kind(int kindId, int alterKindes) {
		
		this.kindId = kindId;
		this.alterKindes = alterKindes;
		
	}
	
	// Getters & Setters
	
	public int getKindID() {
		
		return this.kindId;
		
	}

	public void setKindID(int kindId) {
		
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
	
	// Methods
	
	@Override
	public String toString() {
		
		return "Kind: " + kindId + " " + alterKindes + " " + punktenStart;
		
	}

	/*
	public List<KindAngenehmeAktivitaet> getAktivitaetenListe() {
		
		List<KindAngenehmeAktivitaet> returnValue = new ArrayList<KindAngenehmeAktivitaet>();
		
		KindAngenehmeAktivitaet ka = new KindAngenehmeAktivitaet(this.kindId);
		
		
		
		return returnValue;
		
	} */
	
}

