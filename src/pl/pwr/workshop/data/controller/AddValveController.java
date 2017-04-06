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
import pl.pwr.workshop.data.Valve;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddValveController implements Initializable, DataProvider, AddValveMotorController {

    @FXML
    private TextField itemName;
    @FXML
    private TextField itemType;
    @FXML
    private TextField itemSize;
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
			Valve valve = createValve();
			addItemAndCheckForExistence(valve, data);
			((Stage) addItem.getScene().getWindow()).close();
		});
		textFieldValidator();
	}

	private Valve createValve() {
		String valveName = itemName.getText();
		String valveType = itemType.getText();
		int valveSize = Integer.parseInt(itemSize.getText());
		int valveQuantity = Integer.parseInt(itemQuantity.getText());

		return new Valve(valveName, valveType, valveSize, valveQuantity);
	}

	public void textFieldValidator() {
		initializeTextFieldList();
		itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemType.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemSize.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemSize));
		itemQuantity.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemQuantity));
	}

	private void initializeTextFieldList() {
		textFieldArray = new ArrayList<>();
		textFieldArray.add(itemName);
		textFieldArray.add(itemType);
		textFieldArray.add(itemSize);
		textFieldArray.add(itemQuantity);
	}

	@Override
	public void getData(Data data) {
		this.data = data;
	}

}


