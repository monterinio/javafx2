package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Valve;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddValveController extends AddValveMotorController implements Initializable, DataProvider {

    @FXML
    private TextField itemSize;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeButtons();
        textFieldValidator();
    }

    @Override
    protected void initializeButtons() {
        super.initializeButtons();
        addItem.setOnAction(x -> {
            Valve valve = createValve();
            addItemAndCheckForExistence(valve, data);
            ((Stage) addItem.getScene().getWindow()).close();
        });
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

    @Override
    protected void initializeTextFieldList() {
        super.initializeTextFieldList();
        textFieldArray.add(itemSize);
    }

    @Override
    public void getData(Data data) {
        this.data = data;
    }

}
