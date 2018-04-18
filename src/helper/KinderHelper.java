package helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.AngenehmeAktivitaeten;
import model.Extras;
import model.Kinder;
import model.UnangenehmeAktivitaeten;

public class KinderHelper {
	
	// Private Attribute
	
	private static final Logger logger = LogManager.getLogger(KinderHelper.class);
	
	// Methoden
	
	// Methode braucht als Übergabeparameter eine Id des Kindes und selektiert zu jedem Kind
	// die AngenehmeAktivitaeten, fügt sie zu der angenehmeAktList hinzu
	// und gibt die Liste dann zurück

	public static ArrayList<AngenehmeAktivitaeten> holenAngenehmeAktivitaeten(int kindId) throws SQLException {

		logger.debug("Erstelle ArrayList<AngenehmeAktivitaeten>...");
		
		ArrayList<AngenehmeAktivitaeten> angenehmeAktList = new ArrayList<>();
		
		AngenehmeAktivitaeten angenehmeAktivitaeten;
		
		// Select Befehl:Query

		String sqlQuery = "SELECT kaa.EintragsDatum, kaa.KindNR, aa.Name, aa.PlusPunktenZahl "
						+ "FROM kindangenehmeaktivitaet kaa JOIN angenehmeaktivitaeten aa "
						+ " ON (kaa.AngenehmeAktivitaetNR = aa.AngenehmeID) WHERE kaa.KindNR = ? ";

		PreparedStatement prepStat = DbHelper.connection.prepareStatement(sqlQuery);

		prepStat.setInt(1, kindId);

		ResultSet result = prepStat.executeQuery();

		while (result.next()) {
			
			Date datum = result.getDate("EintragsDatum");
			
			int aktNrZumKind = result.getInt("KindNR");
			
			String name = result.getString("Name");
			
			int punkte = result.getInt("PlusPunktenZahl");

			angenehmeAktivitaeten = new AngenehmeAktivitaeten(aktNrZumKind, name, punkte, datum);
			
			angenehmeAktList.add(angenehmeAktivitaeten);
			
		}
	
		return angenehmeAktList;

	} // Ende Methode holenAngenehmeAktivitaeten()

	// Methode braucht als Übergabeparameter eine Id des Kindes und selektiert zu jedem Kind
	// die UnangenehmeAktivitaeten, fügt sie zu der unangenehmeAktList hinzu
	// und gibt die Liste dann zurück

	public static ArrayList<UnangenehmeAktivitaeten> holenUnangenehmeAktivitaeten(int kindId) throws SQLException {

		logger.debug("Erstelle ArrayList<UnangenehmeAktivitaeten>...");
		
		ArrayList<UnangenehmeAktivitaeten> unangenehmeAktList = new ArrayList<>();
		
		UnangenehmeAktivitaeten unangenehmeAktivitaeten;
		
		String sqlQuery = "SELECT kua.EintragsDatum, kua.KindNR, ua.Name, ua.MinusPunktenZahl "
						+ "FROM kindunangenehmeaktivitaet kua JOIN unangenehmeaktivitaeten ua "
						+ " ON (kua.UnangenehmeAktivitaetNR = ua.UnangenehmeID) WHERE kua.KindNR = ? ";

		PreparedStatement prepStat = DbHelper.connection.prepareStatement(sqlQuery);

		prepStat.setInt(1, kindId);

		ResultSet result = prepStat.executeQuery();

		while (result.next()) {
			
			Date datum = result.getDate("EintragsDatum");
			
			int aktNrZumKind = result.getInt("KindNR");
			
			String name = result.getString("Name");
			
			int punkte = result.getInt("MinusPunktenZahl");

			unangenehmeAktivitaeten = new UnangenehmeAktivitaeten(aktNrZumKind, name, punkte, datum);
			
			unangenehmeAktList.add(unangenehmeAktivitaeten);
			
		}

		return unangenehmeAktList;

	} // Ende Methode holenUnangenehmeAktivitaeten()
	
	// Methode braucht als Übergabeparameter eine Id des Kindes und selektiert zu jedem Kind
	// die ExtraAktivitaeten, fügt sie zu der extrasAktList hinzu
	// und gibt die Liste dann zurück

	public static ArrayList<Extras> holenExtrasAktivitaeten(int kindId) throws SQLException {

		logger.debug("Erstelle ArrayList<Extras>...");
		
		ArrayList<Extras> extrasAktList = new ArrayList<>();
		
		Extras extrasAktivitaeten;
		
		// Select Befehl:Query

		String sqlQuery = "SELECT kindextras.EintragsDatum, kindextras.KindNR, extras.Name, extras.HabenFürPunkte, extras.DanachAbziehenPunkte "
						+ "FROM kindextras JOIN extras"
						+ " ON (kindextras.ExtrasNR = extras.ExtrasID) WHERE kindextras.KindNR = ? ";

		PreparedStatement prepStat = DbHelper.connection.prepareStatement(sqlQuery);

		prepStat.setInt(1, kindId);

		ResultSet result = prepStat.executeQuery();

		while (result.next()) {
			
			Date datum = result.getDate("EintragsDatum");
			
			int extraNrZumKind = result.getInt("KindNR");
			
			String name = result.getString("Name");
			
			int habenPunkte = result.getInt("HabenFürPunkte");
			
			int abzugPunkte = result.getInt("DanachAbziehenPunkte");

			extrasAktivitaeten = new Extras(extraNrZumKind, name, habenPunkte, abzugPunkte, datum);
			
			extrasAktList.add(extrasAktivitaeten);
			
		}
	
		return extrasAktList;

	} // Ende Methode holenExtrasAktivitaeten()
	
	// Methode berechnet die Summe aller positiven Aktivitäten, die ein Kind
	// (innerhalb von einem gewissen Zeitraum) gemacht hat. Als Übergabeparameter nimmt sie ein Kind-Objekt an und returniert die
	// Summe als int zurück

	public static int berechnePlusPunkte(Kinder kind) {
		
		logger.debug("BerechnePlusPunkte...");
		
        // Das Ergebnis definieren und initialisieren
		int ergebnisPlus = 0;

		ArrayList<AngenehmeAktivitaeten> tempListAn = kind.getAngenehmeAktList();
		
		AngenehmeAktivitaeten aa = null;

		for (int i = 0; i < tempListAn.size(); i++) {
			
			aa = tempListAn.get(i);
			
			ergebnisPlus += aa.getPunktenZahl();
			
		}

		return ergebnisPlus;

	} // Ende Methode berechnePlusPunkte()
	
	// Methode berechnet die Summe aller negativen Aktivitäten, die ein Kind
	// (innerhalb von einem gewissen Zeitraum) gemacht hat. 
	// Als Übergabeparameter nimmt sie ein Kind-Objekt an und returniert die
	// Summe als int zurück

	public static int berechneMinusPunkte(Kinder kind) {

		logger.debug("BerechneMinusPunkte...");
		
		int ergebnisMinus = 0;

		ArrayList<UnangenehmeAktivitaeten> tempListUn = kind.getUnangenehmeAktList();
		
		UnangenehmeAktivitaeten ua = null;

		for (int i = 0; i < tempListUn.size(); i++) {
			
			ua = tempListUn.get(i);
			
			ergebnisMinus += ua.getPunktenZahl();
			
		}

		return ergebnisMinus;

	} // Ende Methode berechneMinusPunkte()
	
	// Methode berechnet den Zwischenstand für die Aktivitäten, die ein Kind
	// (innerhalb von einem gewissen Zeitraum) gemacht hat. 
	// Dabei wird von der Summe aller positiven Aktivitäten, die Summe aller negativer Aktivitäten
	// abgezogen. Zu dem Ergebnis werden noch die Punkte, die ein Kind am Anfang festgezetzt bekommt
	// hinzuaddiert.
	// Als Übergabeparameter nimmt sie ein Kind-Objekt an und returniert das zwischen
	// Ergebnis als int zurück.
	
	public static int berechneZwischenPunkte(Kinder kind) {

		logger.debug("BerechneZwischenPunkte...");
		
		int ergebnisZwischen = 0;

		ergebnisZwischen = kind.getPunktenStart() + (kind.getStandAngenehm() - kind.getStandUnangenehm());

		return ergebnisZwischen;

	} // Ende Methode berechneZwischenPunkte()
	
	// Methode berechnet die Extra-Punkte, die ein Kind durch Extra-Aktivitäten hinzugefügt bekommen hat.
	
	public static int berechneExtraPunkte(Kinder kind) {

		logger.debug("BerechneExtraPunkte...");
		
		int ergebnisExtra = 0;

		ArrayList<Extras> tempListExtras = kind.getExtrasAktList();
		
		Extras extra = null;

		for (int i = 0; i < tempListExtras.size(); i++) {
			
			extra = tempListExtras.get(i);
			
			ergebnisExtra += extra.getPunktenZahl();
			
		}

		return ergebnisExtra;

	} // Ende Methode berechneExtraPunkte()

	// Methode berechnet den Punktestand nach dem die Extra-Aktivität durchgeführt wurde.
	// Dazu wird vom Zwischenstand der für die Aktivität entsprechende Abzugs-Wert abgezogen.
	
	public static int berechneEndstandNachExtra(Kinder kind) {
	
		int ergebnisZwischenstand = 0;
		int ergebnisEndstand = 0;
		
		ArrayList<Extras> tempListExtras = kind.getExtrasAktList();
		
		Extras extra = null;

		for (int i = 0; i < tempListExtras.size(); i++) {
			
			extra = tempListExtras.get(i);
			
			ergebnisZwischenstand = KinderHelper.berechneZwischenPunkte(kind);
			ergebnisEndstand = (ergebnisZwischenstand - extra.getDanachAbziehenPunkte());
			
		}
		
		return ergebnisEndstand;
		
	} // Ende Methode berechneEndstandNachExtra()
	
	// Diese Methode gibt den Wert der durch die Extra-Aktivität hinzugefügten Pukte zurück
	
	public static int holenHabenExtras(Kinder kind) {
		
		int ergebnisHabenExtras = 0;
		
		ArrayList<Extras> tempListExtras = kind.getExtrasAktList();
		
		Extras extra = null;

		for (int i = 0; i < tempListExtras.size(); i++) {
			
			extra = tempListExtras.get(i);
		
			ergebnisHabenExtras = extra.getPunktenZahl();
			
		}
		
		return ergebnisHabenExtras;
		
	} // Ende Methode holenHabenExtras()
	
	// Diese Methode gibt den Wert aus, der nach dem Ausführen der Extra-Aktivität abgezogenen wird	
	
	public static int holenAbziehenExtras(Kinder kind) {
		
		int ergebnisAbziehenExtras = 0;
		
		ArrayList<Extras> tempListExtras = kind.getExtrasAktList();
		
		Extras extra = null;

		for (int i = 0; i < tempListExtras.size(); i++) {
			
			extra = tempListExtras.get(i);
			
			ergebnisAbziehenExtras = extra.getDanachAbziehenPunkte();
			
		}
		
		return ergebnisAbziehenExtras;
		
	} // Ende Methode holenAbziehenExtras()
	
} // Ende class KinderHelper
