package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Motor;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddMotorController extends AddValveMotorController implements Initializable, DataProvider {

    @FXML
    private TextField itemPower;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeButtons();
        textFieldValidator();
    }

    @Override
    protected void initializeButtons() {
        super.initializeButtons();
        addItem.setOnAction(x -> {
            Motor motor = createMotor();
            addItemAndCheckForExistence(motor, data);
            ((Stage) addItem.getScene().getWindow()).close();
        });
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

    @Override
    protected void initializeTextFieldList() {
        super.initializeTextFieldList();
        textFieldArray.add(itemPower);
    }

    @Override
    public void getData(Data data) {
        this.data = data;
    }

}
