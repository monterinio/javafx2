package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Cable;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Pipe;

public class AddCableController implements Initializable, DataProvider {

    @FXML
    private TextField itemName;
    @FXML
    private TextField itemNoOfWires;
    @FXML
    private TextField itemCrossSection;
    @FXML
    private TextField itemLength;
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
			data.getPipeCableList().add(new Cable(itemName.getText(), Integer.parseInt(itemNoOfWires.getText()),
												Double.parseDouble(itemCrossSection.getText()),
												Integer.parseInt(itemLength.getText())
																		));
			 ((Stage) addItem.getScene().getWindow()).close();
		});
		textFieldValidator();
	}

	public void textFieldValidator() {
		initializeTextFieldList();
		itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemNoOfWires.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemNoOfWires));
		itemCrossSection.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemCrossSection));
		itemLength.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemLength));
	}

	private void initializeTextFieldList() {
		textFieldArray = new ArrayList<>();
		textFieldArray.add(itemName);
		textFieldArray.add(itemNoOfWires);
		textFieldArray.add(itemCrossSection);
		textFieldArray.add(itemLength);
	}

	@Override
	public void getData(Data data) {
		this.data = data;
	}
}


