package controller;

import org.apache.logging.log4j.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import helper.DbHelper;
import model.Person;

public class PersonController implements Initializable {
	
	// Private attributes
	
	private final static Logger logger = LogManager.getLogger(PersonController.class);
	
	Thread threadCreate = null;
	Thread threadRemove = null;
	
	ObservableList<Person> ol1 = FXCollections.observableArrayList();
	
	// Public attributes
	
	// Methods
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		DbHelper.getDataFromDB(ol1);
		
		// (1) Observable List and Table View anbinden
		tabView1.setItems(ol1);		
				
		// (2) Table Columns an Attribute (Properties) der Klasse Person anbinden
		colVorname.setCellValueFactory(new PropertyValueFactory<Person, String>("vorname"));
		colNachname.setCellValueFactory(new PropertyValueFactory<Person, String>("nachname"));
		
	}
	
	// FXML content
	
    @FXML
    private TableView<Person> tabView1;

    @FXML
    private TableColumn<Person, String> colVorname;

    @FXML
    private TableColumn<Person, String> colNachname;

    @FXML
    private TextField eingabeVorname;

    @FXML
    private TextField eingabeNachname;

    @FXML
    synchronized void butHinzufuegen(ActionEvent event) {
    	
    	Thread threadCreate = new Thread(new Runnable() {
    		
    		@Override
    		public void run() {
    			
    			System.out.println("Ab jetzt sleep Modus");
    			
    	    	// Hier dauert eine Aktion sehr lange
    	    	try {
    	    		
    				Thread.sleep(10);
    				
    				System.out.println("Raus aus sleep Modus");
    				
    			} catch (InterruptedException ie) {
    				
    				logger.error(ie);
    				
    			}
    	    	    
    	    	Person p = new Person(eingabeVorname.getText(), eingabeNachname.getText());
    	    	
    	    	try {
    	    		
    	    		DbHelper.personAddToDb(p);
    	    		
    	    		ol1.add(p);
    	    		
    	    	} catch (SQLException sqle) {
    	    		
    	    		logger.error(sqle);
    	    		
    	    	}
    	    	
    		}
    		
    	});
    	
    	threadCreate.start();
    	
    	try {
    		
    		if (threadRemove != null) {
    			
    			threadRemove.join();
    			threadCreate.start();
    			
    		} else {
    			
    			threadCreate.start();
    			
    		}
			
		} catch (InterruptedException ie) {
			
			logger.error(ie);
			
		}
    	
    }
    
    @FXML
    synchronized void butRemove(ActionEvent event) {
    	
		Thread threadRemove = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
    			System.out.println("Ab jetzt sleep Modus");
    			
    	    	// Hier dauert eine Aktion sehr lange
    	    	try {
    	    		
    				Thread.sleep(10);
    				
    				System.out.println("Raus aus sleep Modus");
    				
    			} catch (InterruptedException ie) {
    				
    				logger.error(ie);
    				
    			}
				
		    	Person p = new Person(eingabeVorname.getText(), eingabeNachname.getText());
		    	
    	    	try {
    	    		
    	    		DbHelper.personRemoveFromDb(p);
    	    		
    	    		ol1.remove(p);
    	    		
    	    	} catch (SQLException sqle) {
    	    		
    	    		logger.error(sqle);
    	    		
    	    	}
			
			}
		
		});
		
		try {
			
			if (threadCreate != null) {
				
				threadCreate.join();
				threadRemove.start();
				
			} else {
				
				threadRemove.start();
				
			}
			
		} catch (InterruptedException ie) {
			
			logger.error(ie);
			
		}
    	
    }
	
}
