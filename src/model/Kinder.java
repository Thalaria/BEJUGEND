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
	
    //Die Id des Kindes 
	private int kindId;
	
	//Das Alter des Kindes 
	private int alterKindes;
	
	//Jedes Kind verfügt anhand des Alters über einen Punktenstart
	private int punktenStart;

	// Die ArrayList, die mit den AngenehmeAktivitaeten parametrisiert wird
	private ArrayList<AngenehmeAktivitaeten> angenehmeAktList = new ArrayList<>();

	// Die ArrayList, die mit den UnangenehmeAktivitaeten parametrisiert wird
	private ArrayList<UnangenehmeAktivitaeten> unangenehmeAktList = new ArrayList<>();
	
	// Die ArrayList, die mit den Extra-Aktivitaeten parametrisiert wird
	private ArrayList<Extras> extrasAktList = new ArrayList<>();
	
	private int standAngenehm;
	
	private int standUnangenehm;
	
	private int zwischenStand;
	
	private int standExtras;

	// Constructors


	public Kinder() {
	}

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

	// Methode toString(), die vom Objekt gererbt wird, überschreiben

	@Override
	public String toString() {

		return "Das Kind mit der : " + kindId + " " + alterKindes + " " + punktenStart + " " + angenehmeAktList + " "
				+ unangenehmeAktList + " " + extrasAktList;

	}

} // Ende class Kinder
