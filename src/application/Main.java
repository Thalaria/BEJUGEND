package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import helper.DbHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	// Private Attribute
	
	private final static Logger logger = LogManager.getLogger(Main.class);
	
	private final static String urlDB = "jdbc:mysql://localhost:3306/bewertungssystem";
	private final static String dbUser = "root";
	private final static String dbPassword = "root";
	
	// Methoden
	
	@Override
	public void start(Stage primaryStage) {
		
		// Hauptfenster wird erstellt
		
		try {
			
			URL location = Main.class.getResource("KinderView.fxml");
			
			Parent root = FXMLLoader.load(location);
			
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Titel der Anwendung setzen
			
			primaryStage.setTitle("BEJUGEND");
			
			// groessenanpassung erlauben
            
			primaryStage.setResizable(false);
            
            // Vollbildmodus ausschalten (default aus)
            
			primaryStage.setFullScreen(false);
            
            // Größe des Fensters auf die Größe des Contents setzen
            
			primaryStage.sizeToScene();

            // Scene der Stage zuweisen
            
			primaryStage.setScene(scene);
            
            // Stage anzeigen 
            
			primaryStage.show();
			
		} catch (Exception e) {
			
			logger.error(e);
			
		}
		
	} // Ende der Methode start()
	
	public static void main(String[] args) {
		
		// Datenbank-Verbindung wird hergestellt
		
		try(Connection connection = DriverManager.getConnection(urlDB, dbUser, dbPassword)) {
			
			// Das "connection"-Objekt wird in das globale Objekt der Klasse DbHelper geschrieben
			
			DbHelper.connection = connection;
			
			// JavaFX Anwendung wird gestartet
		
			launch(args);
			
		} catch (SQLException sqle) {
			
			logger.error(sqle);
			
		}
		
	} // Ende der Methode main()
	
} // Ende der Klasse Main
