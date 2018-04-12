package application;

import org.apache.logging.log4j.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import model.AngenehmeAktivitaeten;
import model.Kinder;
import helper.DbHelper;

public class Main extends Application {
	
	// Private attributes
	
	private final static Logger logger = LogManager.getLogger(Main.class);
	
	private final static String urlDB = "jdbc:mysql://localhost:3306/bewertungssystem";
	private final static String dbUser = "root";
	private final static String dbPassword = "";
	
	// Public attributes
	
	// Methods
	
	@Override
	public void start(Stage primaryStage) {
		
		// Main window will be crated
		
		try {
			
			URL location = Main.class.getResource("MainView.fxml");
			
			Parent root = FXMLLoader.load(location);
			
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		} catch (Exception e) {
			
			logger.error(e);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		// Db connection will be established
		
		try(Connection connection = DriverManager.getConnection(urlDB, dbUser, dbPassword)) {
			
			DbHelper.connection = connection;
			
			// JavaFX application will be started
		
			launch(args);
			
		} catch (SQLException sqle) {
			
			logger.error(sqle);
			
		}
		
	}
	
}
