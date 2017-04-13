package pl.pwr.workshop.data.utils;

import java.util.ArrayList;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TextFieldNumericValidation extends TextFieldEmptinessValidation {
    private TextField txtField;

    public TextFieldNumericValidation(Button addItem, ArrayList<TextField> textFieldArray, TextField txtField) {
        super(addItem, textFieldArray);
        this.txtField = txtField;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        super.changed(observable, oldValue, newValue);
        if (newValue.matches("\\d*")) {
        } else {
            txtField.setText(oldValue);
        }

    }
}
