package pl.pwr.workshop.data.controller;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.PipeCable;

public abstract class AddPipeCableController extends AddStoredItemController {

    @FXML
    protected TextField itemName;
    @FXML
    protected TextField itemLength;

    public void addItemAndCheckForExistence(PipeCable pipeCable, Data data) {
        boolean itemAdded = true;
        ObservableList<PipeCable> pipeCableList = data.getPipeCableList();
        for (int i = 0; i < pipeCableList.size(); i++) {
            PipeCable currentPipeCable = pipeCableList.get(i);
            if (currentPipeCable.equals(pipeCable)) {
                currentPipeCable.addQuantity(pipeCable);
                itemAdded = false;
            }
        }
        if (itemAdded) {
            pipeCableList.add(pipeCable);
        }
    }

    protected void initializeTextFieldList() {
        textFieldArray = new ArrayList<>();
        textFieldArray.add(itemName);
        textFieldArray.add(itemLength);
    }

}
