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
import pl.pwr.workshop.data.Motor;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddMotorController implements Initializable, DataProvider, AddValveMotorController {

    @FXML
    private TextField itemName;
    @FXML
    private TextField itemType;
    @FXML
    private TextField itemPower;
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
			Motor motor = createMotor();
			addItemAndCheckForExistence(motor, data);
			((Stage) addItem.getScene().getWindow()).close();
		});
		textFieldValidator();
	}

	private Motor createMotor() {
		String motorName = itemName.getText();
		String motorType = itemType.getText();
		double motorPower = Double.parseDouble(itemPower.getText());
		int motorQuantity = Integer.parseInt(itemQuantity.getText());

		return new Motor(motorName, motorType, motorPower, motorQuantity);
	}

	public void textFieldValidator() {
		initializeTextFieldList();
		itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemType.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemPower.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemPower));
		itemQuantity.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemQuantity));
	}

	private void initializeTextFieldList() {
		textFieldArray = new ArrayList<>();
		textFieldArray.add(itemName);
		textFieldArray.add(itemType);
		textFieldArray.add(itemPower);
		textFieldArray.add(itemQuantity);
	}

	@Override
	public void getData(Data data) {
		this.data = data;
	}

}
