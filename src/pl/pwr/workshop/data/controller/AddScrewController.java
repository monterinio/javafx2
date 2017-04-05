package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Screw;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;

public class AddScrewController implements Initializable, DataProvider {

	    @FXML
	    private TextField itemName;
	    @FXML
	    private TextField itemType;
	    @FXML
	    private TextField itemThreadType;
	    @FXML
	    private TextField itemQuantity;

	    @FXML
	    private Button cancel;
	    @FXML
	    private Button addItem;
	    private Data data;
	    private ArrayList<TextField> textFieldArray;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			cancel.setOnAction(x->((Stage) cancel.getScene().getWindow()).close());
			addItem.setDisable(true);
			addItem.setOnAction(x-> {
				data.getElementList().add(new Screw(itemName.getText(), itemType.getText(),
													itemThreadType.getText(),
													Integer.parseInt(itemQuantity.getText())
																			));
				 ((Stage) addItem.getScene().getWindow()).close();
			});
			textFieldValidator();
		}

		public void textFieldValidator() {
			initializeTextFieldList();
			itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
			itemType.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
			itemThreadType.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
			itemQuantity.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		}

		private void initializeTextFieldList() {
			textFieldArray = new ArrayList<>();
			textFieldArray.add(itemName);
			textFieldArray.add(itemType);
			textFieldArray.add(itemThreadType);
			textFieldArray.add(itemQuantity);
		}

		@Override
		public void getData(Data data) {
			this.data = data;
		}
}
