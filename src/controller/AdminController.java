package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import application.Main;
import helper.ActionButtonTableCell;
import helper.DbHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Kinder;

public class AdminController implements Initializable {

	// Private Attribute
	
	private final static Logger logger = LogManager.getLogger(AdminController.class);
	
	private static ObservableList<Kinder> ol = FXCollections.observableArrayList();
	
	// Methoden

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		logger.debug("Initializing AdminController...");
		
		// Observable List leeren
		
		ol.clear();
		
		// Table Columns erstellen
		
		TableColumn<Kinder, Integer> colKindId = new TableColumn<Kinder, Integer>("ID des Kindes");
		TableColumn<Kinder, Integer> colAlterKindes = new TableColumn<Kinder, Integer>("Alter des Kindes");
		TableColumn<Kinder, Integer> colStandAngenehm = new TableColumn<Kinder, Integer>("Punktestand Angenehme Aktivitäten");
		TableColumn<Kinder, Integer> colStandUnangenehm = new TableColumn<Kinder, Integer>("Punktestand Unangenehme Aktivitäten");
		TableColumn<Kinder, Integer> colZwischenStand = new TableColumn<Kinder, Integer>("Zwischenstand");
		TableColumn<Kinder, Integer> colStandExtras = new TableColumn<Kinder, Integer>("Punktestand Extras");
		
		// Button-Spalten
		
		TableColumn colEditAction = new TableColumn();
		TableColumn colRemoveAction = new TableColumn();
		
		// Table Columns an Attribute (Properties) der Klasse Kinder anbinden
		
		colKindId.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("KindId"));
		colAlterKindes.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("AlterKindes"));
		colStandAngenehm.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandAngenehm"));
		colStandUnangenehm.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandUnangenehm"));
		colZwischenStand.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("ZwischenStand"));
		colStandExtras.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandExtras"));

		// Button-Spalten
		
		colEditAction.setCellFactory(ActionButtonTableCell.<Kinder>forTableColumn("Bearbeiten", (Kinder k) -> {
			// to do "Bearbeiten"
			return k;
		}));
		
		colRemoveAction.setCellFactory(ActionButtonTableCell.<Kinder>forTableColumn("Löschen", (Kinder k) -> {
			ol.remove(k);
			return k;
		}));
		
		// Table Columns in die Table View einbinden
		
		tvAdminView.getColumns().add(colKindId);
		tvAdminView.getColumns().add(colAlterKindes);
		tvAdminView.getColumns().add(colStandAngenehm);
		tvAdminView.getColumns().add(colStandUnangenehm);
		tvAdminView.getColumns().add(colZwischenStand);
		tvAdminView.getColumns().add(colStandExtras);
		
		// Button-Spalten
		
		tvAdminView.getColumns().add(colEditAction);
		tvAdminView.getColumns().add(colRemoveAction);

		// Observable List an die Table View anbinden
		
		DbHelper.getKindFromDB(ol);
		
		tvAdminView.setItems(ol);
		
	}
	
    @FXML
    private AnchorPane apAdminView;
	
    @FXML
    private TableView<Kinder> tvAdminView;
	
    @FXML
    private Button butButtonCloseAdministration;

    @FXML
    private Button butButtonAddNewDbEntry;

	// Hier findet der Wechsel der Ansicht nach dem drücken des Buttons statt
    
    @FXML
    void setOnActionCloseAdministration(ActionEvent event) {

    	URL location = Main.class.getResource("MainView.fxml");
    	
    	AnchorPane mainPane = null;
    	
		try {
			
			mainPane = FXMLLoader.load(location);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
    	apAdminView.getChildren().setAll(mainPane);
    	
    }

    @FXML
    void setOnActionAddNewDbEntry(ActionEvent event) {

    }
	
} // Ende der Klasse AdminController
