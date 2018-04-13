package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import helper.DbHelper;
import model.Kinder;

public class KinderController implements Initializable {

	// Private attributes

	private final static Logger logger = LogManager.getLogger(KinderController.class);

	ObservableList<Kinder> ol1 = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        
		DbHelper.getKindFromDB(ol1);

		// (1) Observable List and Table View anbinden
		tabView1.setItems(ol1);

		// (2) Table Columns an Attribute (Properties) der Klasse Kinder anbinden
		colKindId.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("KindId"));
		colAlterKindes.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("AlterKindes"));
		colStandAngenehm.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandAngenehm"));
		colStandUnangenehm.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandUnangenehm"));
		colZwischenStand.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("ZwischenStand"));
		colStandExtras.setCellValueFactory(new PropertyValueFactory<Kinder, Integer>("StandExtras"));
		
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane idTableView;

	@FXML
	private TableView<Kinder> tabView1;

	@FXML
	private TableColumn<Kinder, Integer> colKindId;

	@FXML
	private TableColumn<Kinder, Integer> colAlterKindes;

	@FXML
	private TableColumn<Kinder, Integer> colStandAngenehm;

	@FXML
	private TableColumn<Kinder, Integer> colStandUnangenehm;

	@FXML
	private TableColumn<Kinder, Integer> colZwischenStand;

	@FXML
	private TableColumn<Kinder, Integer> colStandExtras;

	@FXML
	private Button idButtonSchließen;

	@FXML
	void butSchließenOnAction(ActionEvent event) {

	}

} // Ende class KinderController
