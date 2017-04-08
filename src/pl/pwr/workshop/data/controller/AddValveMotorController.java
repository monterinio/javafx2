package pl.pwr.workshop.data.controller;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.ValveMotor;

public abstract class AddValveMotorController extends AddStoredItemController {

    @FXML
    protected TextField itemName;
    @FXML
    protected TextField itemType;
    @FXML
    protected TextField itemQuantity;

    public void addItemAndCheckForExistence(ValveMotor valveMotor, Data data) {
        boolean itemAdded = true;
        ObservableList<ValveMotor> valveMotorList = data.getValveMotorList();
        for (int i = 0; i < valveMotorList.size(); i++) {
            ValveMotor currentValveMotor = valveMotorList.get(i);
            if (currentValveMotor.equals(valveMotor)) {
                currentValveMotor.addQuantity(valveMotor);
                itemAdded = false;
            }
        }
        if (itemAdded) {
            valveMotorList.add(valveMotor);
        }
    }

    protected void initializeTextFieldList() {
        textFieldArray = new ArrayList<>();
        textFieldArray.add(itemName);
        textFieldArray.add(itemType);
        textFieldArray.add(itemQuantity);
    }
}
