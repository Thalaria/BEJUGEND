package helper;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

public class DialogHelper {

	// Private Attribute
	
	private static final Logger logger = LogManager.getLogger(DialogHelper.class);
	
	// Methoden
	
	public static void Dialog(AlertType alertType, String title, String headerText, String contentText, Modality modalityOption) {
		
		logger.debug("Dialog wird angezeigt...");
		
		Alert alert = new Alert(alertType);
		
		if (headerText.isEmpty()) {
			
			headerText = null;
			
		}
		
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.initModality(modalityOption);
		
		if (alertType.equals(AlertType.CONFIRMATION)) {
			
			Optional<ButtonType> result = alert.showAndWait();
			
			if (result.get() == ButtonType.OK) {
				
				// User choose OK -> Functionality has to be added
				
			} else {
				
				// User choose Abort -> Functionality has to be added
				
			}
			
		} else {
		
			alert.showAndWait();
			
		}
		
	} // Ende der Methode Dialog()
	
	public static void CustomConfirmationDialog() {
		
		// Functionality has to be added
		
	} // Ende der Methode CustomConfirmationDialog()
	
	public static void TextInputDialog() {
		
		// Functionality has to be added
		
	} // Ende der Methode TextInputDialog()
	
	public static void ChoiceDialog() {
		
		// Functionality has to be added
		
	} // Ende der Methode ChoiceDialog()
	
} // Ende der Klasse DialogHelper
