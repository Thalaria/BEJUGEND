package helper;

import org.apache.logging.log4j.*;
import java.sql.*;
import javafx.collections.*;
import model.Kinder;

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
				
				ol.add(kTemp);
				
			}
			
		} catch (SQLException e) {
			
			logger.error(e);
			
		}
		
	}
	
}
