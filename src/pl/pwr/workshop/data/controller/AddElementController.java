package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Element;
import pl.pwr.workshop.data.Nut;
import pl.pwr.workshop.data.Screw;
import pl.pwr.workshop.data.Washer;
import pl.pwr.workshop.data.utils.TextFieldChoiceBoxEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddElementController implements Initializable, DataProvider {

	    @FXML
	    private ChoiceBox<String> itemName;
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
			configureChoiceBox();
			configureButtons();
			textFieldValidator();
		}

		private void configureChoiceBox() {
			ObservableList<String> elementItemNames =  FXCollections.observableArrayList("Sruba", "Nakretka", "Podkladka");
			itemName.setItems(elementItemNames);
			itemName.getSelectionModel().selectFirst();
		}

		private void configureButtons() {
			cancel.setOnAction(x->((Stage) cancel.getScene().getWindow()).close());
			addItem.setDisable(true);
			addItem.setOnAction(x-> {
				Element element = createElement();
				addItemAndCheckForExistence(element, data);
				 ((Stage) addItem.getScene().getWindow()).close();
			});
		}

		private Element createElement() {
			Element element;
			String elementName = itemName.getValue();
			String elementType = itemType.getText();
			String elementThreadType = itemThreadType.getText();
			int elementQuantity = Integer.parseInt(itemQuantity.getText());

			switch(itemName.getSelectionModel().getSelectedIndex()) {
			case 0:
				element = new Screw(elementName, elementType, elementThreadType, elementQuantity);
				break;
			case 1:
				element = new Nut(elementName, elementType, elementThreadType, elementQuantity);
				break;
			case 2:
				element = new Washer(elementName, elementType, elementThreadType, elementQuantity);
				break;
				default:
					element = null;
					break;
			}
			return element;
		}

		public void textFieldValidator() {
			initializeTextFieldList();
			itemType.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
			itemThreadType.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
			itemQuantity.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemQuantity));
		}

		private void initializeTextFieldList() {
			textFieldArray = new ArrayList<>();
			textFieldArray.add(itemType);
			textFieldArray.add(itemThreadType);
			textFieldArray.add(itemQuantity);
		}

		private void addItemAndCheckForExistence(Element element, Data data) {
			boolean itemAdded = true;
			ObservableList<Element> elementList = data.getElementList();
			for(int i=0;i<elementList.size();i++) {
				Element currentElement = elementList.get(i);
				if(currentElement.equals(element)) {
					currentElement.addQuantity(element);
					itemAdded = false;
				}
			}
			if(itemAdded) {
				elementList.add(element);
			}
		}

		@Override
		public void getData(Data data) {
			this.data = data;
		}
}
