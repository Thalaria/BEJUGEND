package helper;

import org.apache.logging.log4j.*;
import java.sql.*;
import javafx.collections.*;
import model.Person;

public class DbHelper {

	// Private attributes
	
	private static final Logger logger = LogManager.getLogger(DbHelper.class);
	
	// Public attributes
	
	public static Connection connection;
	
	// Methods
	
	public static void personAddToDb(Person p) throws SQLException {
		
		String prep = "INSERT INTO personen (vorname, nachname) VALUES (?, ?)";
		
		String vorname = p.getVorname();
		
		String nachname = p.getNachname();
		
		PreparedStatement prepStat = connection.prepareStatement(prep);
		
		prepStat.setString(1, vorname);
		
		prepStat.setString(2, nachname);
		
		prepStat.executeUpdate();
		
	}
	
	public static void personRemoveFromDb(Person p) throws SQLException {
		
		String prep = "DELETE FROM personen WHERE vorname = ? OR nachname = ?";
		
		String vorname = p.getVorname();
		
		String nachname = p.getNachname();
		
		PreparedStatement prepStat = connection.prepareStatement(prep);
		
		prepStat.setString(1, vorname);
		
		prepStat.setString(2, nachname);
		
		prepStat.executeUpdate();
		
	}
	
	public static void getDataFromDB(ObservableList<Person> ol) {
	
		
		String sqlQuery = "SELECT * from personen";
		
		try {
			
			Statement stm = connection.createStatement();
			
			ResultSet res = stm.executeQuery(sqlQuery);
			
			while(res.next()) {
				
				String nachname = res.getString("nachname");
				
				String vorname = res.getString("vorname");
				
				Person pTemp = new Person(vorname, nachname);
				
				ol.add(pTemp);
				
			}
			
		} catch (SQLException sqle) {
			
			logger.error(sqle);
			
		}
		
	}
	
}
