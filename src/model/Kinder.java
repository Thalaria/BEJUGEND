package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DbHelper;

public class Kinder {
	
	// Attributes
	
	private int kindId;
	private int alterKindes;
	private int punktenStart;
	
	private ArrayList<AngenehmeAktivitaeten> angenehmeAktList = new ArrayList<>();
	
	private ArrayList<UnangenehmeAktivitaeten> unangenehmeAktList = new ArrayList<>();
	
	// Constructors
	
	public Kinder() {
	}
	
	public Kinder(int kindId, int alterKindes ) {
		
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
	
	
	// Methode toString() vom Objekt überschreiben
	
	@Override
	public String toString() {
		
		return "Kind: " + kindId + " " + alterKindes + " " + punktenStart + " " 
		+ angenehmeAktList + " " + unangenehmeAktList;
		
	}

} 

