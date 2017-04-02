package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPipeController implements Initializable {

    @FXML
    private TextField itemName;
    @FXML
    private TextField itemMaterial;
    @FXML
    private TextField itemDiameter;
    @FXML
    private TextField itemLength;
    @FXML
    private Button cancel;
    @FXML
    private Button addItem;
    private ArrayList<TextField> textFieldArray;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeTextFieldList();
		cancel.setOnAction(x->((Stage) cancel.getScene().getWindow()).close());
		addItem.setDisable(true);
		addItem.setOnAction(x-> {

		});
		textFieldValidator();
	}

	public void textFieldValidator() {
		itemLength.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemDiameter.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemMaterial.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
	}

	private void initializeTextFieldList() {
		textFieldArray = new ArrayList<>();
		textFieldArray.add(itemName);
		textFieldArray.add(itemMaterial);
		textFieldArray.add(itemDiameter);
		textFieldArray.add(itemLength);
	}
}


