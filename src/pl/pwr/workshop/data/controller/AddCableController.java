package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Cable;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;

public class AddCableController extends AddPipeCableController implements Initializable, DataProvider {

    @FXML
    private TextField itemNoOfWires;
    @FXML
    private TextField itemCrossSection;

    public AddCableController() {
        super();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeButtons();
        textFieldValidator();
    }

    @Override
    protected void initializeButtons() {
        super.initializeButtons();
        addItem.setOnAction(x -> {
            Cable cable = createCable();
            addItemAndCheckForExistence(cable, data);
            saveLoadUtil.saveApplicationState(data);
            ((Stage) addItem.getScene().getWindow()).close();
        });
    }

    private Cable createCable() {
        String cableName = itemName.getText();
        int cableNoOfWires = Integer.parseInt(itemNoOfWires.getText());
        double cableCrossSection = Double.parseDouble(itemCrossSection.getText());
        int cableLength = Integer.parseInt(itemLength.getText());

        return new Cable(cableName, cableNoOfWires, cableCrossSection, cableLength);
    }

    public void textFieldValidator() {
        initializeTextFieldList();
        itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
        itemNoOfWires.textProperty()
                .addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemNoOfWires));
        itemCrossSection.textProperty()
                .addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemCrossSection));
        itemLength.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemLength));
    }

    @Override
    protected void initializeTextFieldList() {
        super.initializeTextFieldList();
        textFieldArray.add(itemNoOfWires);
        textFieldArray.add(itemCrossSection);
    }

    @Override
    public void getData(Data data) {
        this.data = data;
    }
}
