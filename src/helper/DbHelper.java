package helper;

import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.*;
import model.AngenehmeAktivitaeten;
import model.Kinder;
import model.UnangenehmeAktivitaeten;

public class DbHelper {

	// Private attributes
	
	private static final Logger logger = LogManager.getLogger(DbHelper.class);
	
	// Public attributes
	
	public static Connection connection;
	
	// Methods
	
	public static void addKindToDb(Kinder k) throws SQLException {
		
		String prep = "INSERT INTO kinder (KindID, AlterKindes) VALUES (?, ?)";
		
		int kindId = k.getKindID();
		
		int alterKindes = k.getAlterKindes();
		
		PreparedStatement prepStat = connection.prepareStatement(prep);
		
		prepStat.setInt(1, kindId);
		
		prepStat.setInt(2, alterKindes);
		
		prepStat.executeUpdate();
		
	}
	
	public static void removeKindFromDb(Kinder k) throws SQLException {
		
		String prep = "DELETE FROM kinder WHERE KinderID = ?";
		
		int kindId = k.getKindID();
		
		PreparedStatement prepStat = connection.prepareStatement(prep);
		
		prepStat.setInt(1, kindId);
		
		prepStat.executeUpdate();
		
	}
	
	public static void getKindFromDB(ObservableList<Kinder> ol) {
	
		
		String sqlQuery = "SELECT * from kinder";
		
		try {
			
			Statement stm = connection.createStatement();
			
			ResultSet res = stm.executeQuery(sqlQuery);
			
			while(res.next()) {
				
				int kindId = res.getInt("KindID");
				
				int alterKindes = res.getInt("AlterKindes");
				
				Kinder kTemp = new Kinder(kindId, alterKindes);
				
				kTemp.setAngenehmeAktList(holenAngenehmeAktivitaeten(kindId));
				kTemp.setUnangenehmeAktList(holenUnangenehmeAktivitaeten(kindId));
				ol.add(kTemp);
				
			}
			logger.debug(ol);
			
		} catch (SQLException e) {
			
			logger.error(e);
			
		}
		
	}

	// Methode braucht als Übergabeparameter eine Id des Kindes und selektiert zu
	// jedem Kind
	// die AngenehmeAktivitaeten, fügt sie zu der angenehmeAktList hinzu
	// und gibt die Liste dann zurück

	public static ArrayList<AngenehmeAktivitaeten> holenAngenehmeAktivitaeten(int kindId) throws SQLException {

		ArrayList<AngenehmeAktivitaeten> angenehmeAktList = new ArrayList<>();
		AngenehmeAktivitaeten angenehmeAktivitaeten;
		// Select Befehl:Query

		String sqlQuery = "SELECT kaa.EintragsDatum, kaa.KindNR, aa.Name, aa.PlusPunktenZahl "
				+ "FROM kindangenehmeaktivitaet kaa JOIN angenehmeaktivitaeten aa "
				+ " ON (kaa.AngenehmeAktivitaetNR = aa.AngenehmeID) WHERE kaa.KindNR = ? ";

		// int idKind = kind.getKindID();

		PreparedStatement prepStat = connection.prepareStatement(sqlQuery);

		prepStat.setInt(1, kindId);

		ResultSet result = prepStat.executeQuery();

		while (result.next()) {
			Date datum = result.getDate("EintragsDatum");
			int aktNr = result.getInt("KindNR");
			String name = result.getString("Name");
			int punkte = result.getInt("PlusPunktenZahl");

			angenehmeAktivitaeten = new AngenehmeAktivitaeten(aktNr, name, punkte);
			angenehmeAktList.add(angenehmeAktivitaeten);
		}
		System.out.println("connection erzeugt");

		return angenehmeAktList;

	} // Ende Methode holenAngenehmeAktivitaeten()

		
	// Methode braucht als Übergabeparameter eine Id des Kindes und selektiert zu
	// jedem Kind
	// die AngenehmeAktivitaeten, fügt sie zu der angenehmeAktList hinzu
	// und gibt die Liste dann zurück

	public static ArrayList<UnangenehmeAktivitaeten> holenUnangenehmeAktivitaeten(int kindId) 
			throws SQLException {

		ArrayList<UnangenehmeAktivitaeten> unangenehmeAktList = new ArrayList<>();
		UnangenehmeAktivitaeten unangenehmeAktivitaeten;
		
		String sqlQuery = "SELECT kua.EintragsDatum, kua.KindNR, ua.Name, ua.MinusPunktenZahl "
				+ "FROM kindunangenehmeaktivitaet kua JOIN unangenehmeaktivitaeten ua "
				+ " ON (kua.UnangenehmeAktivitaetNR = ua.UnangenehmeID) WHERE kua.KindNR = ? ";

		// int idKind = kind.getKindID();

		PreparedStatement prepStat = connection.prepareStatement(sqlQuery);

		prepStat.setInt(1, kindId);

		ResultSet result = prepStat.executeQuery();

		while (result.next()) {
			Date datum = result.getDate("EintragsDatum");
			int aktNr = result.getInt("KindNR");
			String name = result.getString("Name");
			int punkte = result.getInt("MinusPunktenZahl");

			unangenehmeAktivitaeten = new UnangenehmeAktivitaeten(aktNr, name, punkte);
			unangenehmeAktList.add(unangenehmeAktivitaeten);
		}
		System.out.println("connection erzeugt");

		return unangenehmeAktList;

	} // Ende Methode holenUnangenehmeAktivitaeten()

}
