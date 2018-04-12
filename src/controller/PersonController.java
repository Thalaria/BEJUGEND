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
import model.Kinder;

public class PersonController implements Initializable {
	
	// Private attributes
	
	private final static Logger logger = LogManager.getLogger(PersonController.class);
	
	ObservableList<Kinder> ol1 = FXCollections.observableArrayList();
	
	// Public attributes
	
	// Methods
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		DbHelper.getKindFromDB(ol1);
		
		// (1) Observable List and Table View anbinden
		tabView1.setItems(ol1);
				
		// (2) Table Columns an Attribute (Properties) der Klasse Person anbinden
		colKindId.setCellValueFactory(new PropertyValueFactory<Kinder, String>("KindID"));
		colAlterKindes.setCellValueFactory(new PropertyValueFactory<Kinder, String>("AlterKindes"));
		
	}
	
	// FXML content
	
    @FXML
    private TableView<Kinder> tabView1;

    @FXML
    private TableColumn<Kinder, String> colKindId;

    @FXML
    private TableColumn<Kinder, String> colAlterKindes;

    @FXML
    private TextField eingabeVorname;

    @FXML
    private TextField eingabeNachname;

    @FXML
    void butHinzufuegen(ActionEvent event) { }
    
    @FXML
    void butRemove(ActionEvent event) { }
	
}
