package pl.pwr.workshop.data.controller;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

class TextFieldEmptinessValidation implements ChangeListener<String> {
	private Button addItem;
	private ArrayList <TextField> textFieldArray;
	public TextFieldEmptinessValidation(Button addItem, ArrayList <TextField> textFieldArray) {
		this.addItem = addItem;
		this.textFieldArray = textFieldArray;
	}
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        addItem.setDisable(TextFieldsNotEmpty.textFieldsNotEmpty(textFieldArray));
    }
}