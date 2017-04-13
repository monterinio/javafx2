package pl.pwr.workshop.data.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Pipe;
import pl.pwr.workshop.data.utils.TextFieldEmptinessValidation;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;
import pl.pwr.workshop.utils.SaveLoadUtil;

public class AddPipeController extends AddPipeCableController implements Initializable, DataProvider {

    @FXML
    private TextField itemMaterial;
    @FXML
    private TextField itemDiameter;

    public AddPipeController() {
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
            Pipe pipe = createPipe();
            addItemAndCheckForExistence(pipe, data);
            SaveLoadUtil.saveApplicationState(data);
            ((Stage) addItem.getScene().getWindow()).close();
        });
    }

    private Pipe createPipe() {
        String pipeName = itemName.getText();
        String pipeMaterial = itemMaterial.getText();
        int pipeDiameter = Integer.parseInt(itemDiameter.getText());
        int pipeLength = Integer.parseInt(itemLength.getText());

        return new Pipe(pipeName, pipeMaterial, pipeDiameter, pipeLength);
    }

    public void textFieldValidator() {
        initializeTextFieldList();
        itemName.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
        itemMaterial.textProperty().addListener(new TextFieldEmptinessValidation(addItem, textFieldArray));
        itemDiameter.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemDiameter));
        itemLength.textProperty().addListener(new TextFieldNumericValidation(addItem, textFieldArray, itemLength));
    }

    @Override
    protected void initializeTextFieldList() {
        super.initializeTextFieldList();
        textFieldArray.add(itemMaterial);
        textFieldArray.add(itemDiameter);
    }

    @Override
    public void getData(Data data) {
        this.data = data;
    }
}
