package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import application.Main;
import helper.DbHelper;
import helper.DialogHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import model.Kinder;

public class KinderController implements Initializable {

	// Private Attribute

	private final static Logger logger = LogManager.getLogger(KinderController.class);

	private static ObservableList<Kinder> ol = FXCollections.observableArrayList();
	
	// Methoden
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        
		logger.debug("Initializing KinderController...");
		
		// Observeable List leeren, damit beim zurückspringen zu dieser View keine doppelten Inhalte erstellt werden
		
		ol.clear();
		
		// Table Columns erstellen
		
		TableColumn<Kinder, Integer> colKindId = new TableColumn<Kinder, Integer>("ID des Kindes");
		TableColumn<Kinder, Integer> colAlterKindes = new TableColumn<Kinder, Integer>("Alter des Kindes");
		TableColumn<Kinder, Integer> colStandAngenehm = new TableColumn<Kinder, Integer>("Pkt. Angenehme Aktivitäten");
		TableColumn<Kinder, Integer> colStandUnangenehm = new TableColumn<Kinder, Integer>("Pkt.unktestand Unangenehme Aktivitäten");
		TableColumn<Kinder, Integer> colZwischenStand = new TableColumn<Kinder, Integer>("Zwischenstand");
		TableColumn<Kinder, Integer> colHabenExtras = new TableColumn<Kinder, Integer>("Haben Extras");
		TableColumn<Kinder, Integer> colAbziehenExtras = new TableColumn<Kinder, Integer>("Abziehen Extras");
		
		// Nested Column erstellen
		
		TableColumn colExtras = new TableColumn("Extras");
		
		// Table Columns an Attribute (Properties) der Klasse Kinder anbinden
		
		colKindId.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("KindId"));
		colAlterKindes.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("AlterKindes"));
		colStandAngenehm.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandAngenehm"));
		colStandUnangenehm.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandUnangenehm"));
		colZwischenStand.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("ZwischenStand"));
		colHabenExtras.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("HabenExtras"));
		colAbziehenExtras.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("AbziehenExtras"));
		
		// Der Nested Column zwei andere Spalten zuordnen
		
		colExtras.getColumns().addAll(colHabenExtras, colAbziehenExtras);
		
		// Table Columns in die Table View einbinden
		
		tvKinderView.getColumns().add(colKindId);
		tvKinderView.getColumns().add(colAlterKindes);
		tvKinderView.getColumns().add(colStandAngenehm);
		tvKinderView.getColumns().add(colStandUnangenehm);
		tvKinderView.getColumns().add(colZwischenStand);
		tvKinderView.getColumns().add(colExtras);
		
		// Doppelklick auf eine Row abfangen und das entsprechende Objekt zurückgeben
		
		tvKinderView.setRowFactory(tv -> {
			
			TableRow<Kinder> row = new TableRow<>();
			
			row.setOnMouseClicked(event -> {
		        
				if (event.getClickCount() == 2 && (!row.isEmpty())) {

					Kinder rowData = row.getItem();
		            
					DialogHelper.Dialog(AlertType.INFORMATION, "KindID: " + rowData.getKindId(), "Content", rowData.toString(), Modality.APPLICATION_MODAL);
					
				}
		            
		    });
	    
			return row;
		
		});
		
		DbHelper.getKindFromDB(ol);

		// Observable List an die Table View anbinden
		
		tvKinderView.setItems(ol);
		
	}
	
    @FXML
    private AnchorPane apMainView;
	
	@FXML
	private TableView<Kinder> tvKinderView;

	@FXML
	private Button butButtonCloseApplication;

    @FXML
    private Button butButtonOpenAdministration;
	
	@FXML
	void setOnActionCloseApplication(ActionEvent event) {

		System.exit(0);
		
	}
	
	// Hier findet der Wechsel der Ansicht nach dem drücken des Buttons statt
	
    @FXML
    void setOnActionOpenAdministration(ActionEvent event) {
    	
    	URL location = Main.class.getResource("AdminView.fxml");
    	
    	AnchorPane adminPane = null;
    	
		try {
			
			adminPane = FXMLLoader.load(location);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
    	apMainView.getChildren().setAll(adminPane);

    }
    
    @FXML
    void setOnMouseClicked(MouseEvent event) { }
    
} // Ende der Klasse KinderController
