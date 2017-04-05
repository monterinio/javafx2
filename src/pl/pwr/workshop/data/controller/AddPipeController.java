package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Pipe;
import pl.pwr.workshop.data.PipeCable;
import pl.pwr.workshop.data.StoredItem;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddPipeController implements Initializable, DataProvider {

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
    private Data data;
    private ArrayList<TextField> textFieldArray;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancel.setOnAction(x->((Stage) cancel.getScene().getWindow()).close());
		addItem.setDisable(true);
		addItem.setOnAction(x-> {
			Pipe pipe = createPipe();
			addItemWithCheckingForExistence(pipe, data.getPipeCableList());
			((Stage) addItem.getScene().getWindow()).close();
		});
		textFieldValidator();
	}

	private Pipe createPipe() {
		String pipeName = itemName.getText();
		String pipeMaterial = itemMaterial.getText();
		int pipeDiameter = Integer.parseInt(itemDiameter.getText());
		int pipeLength = Integer.parseInt(itemLength.getText());

		return new Pipe(pipeName, pipeMaterial, pipeDiameter, pipeLength);
	}

	private void refreshList(ObservableList<PipeCable> pipeCableList) {
		pipeCableList.add(null);
		pipeCableList.remove(null);
	}

	private void addItemWithCheckingForExistence(Pipe pipe, ObservableList<PipeCable> pipeCableList) {
		boolean itemAdded = true;

		for(int i=0;i<pipeCableList.size();i++) {
			Pipe currentPipe = (Pipe) data.getPipeCableList().get(i);
			if(currentPipe.equals(pipe)) {
				currentPipe.addQuantity(pipe);
				itemAdded = false;
				refreshList(pipeCableList);
			}
		}
		if(itemAdded) {
			pipeCableList.add(pipe);
		}
	}

	public void textFieldValidator() {
		initializeTextFieldList();
		itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemMaterial.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
		itemDiameter.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemDiameter));
		itemLength.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemLength));
	}

	private void initializeTextFieldList() {
		textFieldArray = new ArrayList<>();
		textFieldArray.add(itemName);
		textFieldArray.add(itemMaterial);
		textFieldArray.add(itemDiameter);
		textFieldArray.add(itemLength);
	}

	@Override
	public void getData(Data data) {
		this.data = data;
	}
}


