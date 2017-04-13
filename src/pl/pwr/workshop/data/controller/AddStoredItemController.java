package pl.pwr.workshop.data.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.utils.SaveLoadUtil;

public abstract class AddStoredItemController {
    @FXML
    protected Button cancel;
    @FXML
    protected Button addItem;
    protected Data data;
    protected ArrayList<TextField> textFieldArray;

    protected void initializeButtons() {
        cancel.setOnAction(x -> ((Stage) cancel.getScene().getWindow()).close());
        addItem.setDisable(true);
    }
}
