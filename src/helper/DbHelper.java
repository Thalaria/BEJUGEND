package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.collections.ObservableList;
import model.Kinder;

public class DbHelper {

	// Private Attribute
	
	private static final Logger logger = LogManager.getLogger(DbHelper.class);
	
	// Public Attribute
	
	public static Connection connection;
	
	//public static KinderHelper kinderHelper;
	
	// Methoden
	
	public static void addKindToDb(Kinder k) throws SQLException {
		
		String prep = "INSERT INTO kinder (KindID, AlterKindes) VALUES (?, ?)";
		
		int kindId = k.getKindId();
		
		int alterKindes = k.getAlterKindes();
		
		PreparedStatement prepStat = connection.prepareStatement(prep);
		
		prepStat.setInt(1, kindId);
		
		prepStat.setInt(2, alterKindes);
		
		prepStat.executeUpdate();
		
	}
	
	public static void removeKindFromDb(Kinder k) throws SQLException {
		
		String prep = "DELETE FROM kinder WHERE KinderID = ?";
		
		int kindId = k.getKindId();
		
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
				int punktStart = res.getInt("PunktenStart");
				
				Kinder kTemp = new Kinder(kindId, alterKindes, punktStart);
				
				kTemp.setAngenehmeAktList(KinderHelper.holenAngenehmeAktivitaeten(kindId));
				kTemp.setStandAngenehm(KinderHelper.berechnePlusPunkte(kTemp));
				
				kTemp.setUnangenehmeAktList(KinderHelper.holenUnangenehmeAktivitaeten(kindId));
				kTemp.setStandUnangenehm(KinderHelper.berechneMinusPunkte(kTemp));
				
				kTemp.setZwischenStand(KinderHelper.berechneZwischenPunkte(kTemp));
				
				kTemp.setExtrasAktList(KinderHelper.holenExtrasAktivitaeten(kindId));
				kTemp.setStandExtras(KinderHelper.berechneExtraPunkte(kTemp));
				
				ol.add(kTemp);
				
			}
			
			logger.debug(ol);
			
		} catch (SQLException e) {
			
			logger.error(e);
			
		}
		
	}


} // Ende der Klasse DbHelper
