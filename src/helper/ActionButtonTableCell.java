package helper;

import java.util.function.Function;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ActionButtonTableCell<T> extends TableCell<T, Button> {

	// Private Attribute
	
    private final Button actionButton;

    // Konstruktor
    
    public ActionButtonTableCell(String label, Function<T, T> function) {
        
        this.actionButton = new Button(label);
        
        this.actionButton.setOnAction((ActionEvent e) -> {
        	
            function.apply(getCurrentItem());
            
        });
        
        this.actionButton.setMaxWidth(Double.MAX_VALUE);
        
    }

    // Methoden
    
    public T getCurrentItem() {
    	
        return (T) getTableView().getItems().get(getIndex());
        
    }

    public static <T> Callback<TableColumn<T, Button>, TableCell<T, Button>> forTableColumn(String label, Function<T, T> function) {
    	
        return param -> new ActionButtonTableCell<>(label, function);
        
    }

    @Override
    public void updateItem(Button item, boolean empty) {

    	super.updateItem(item, empty);

        if (empty) {
        	
            setGraphic(null);
            
        } else {
        	
            setGraphic(actionButton);
            
        }
        
    }
    
} // Ende der Klasse ActionButtonTableCell
