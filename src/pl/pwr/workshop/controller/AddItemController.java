package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.data.controller.DataProvider;
import pl.pwr.workshop.utils.WindowUtil;

public class AddItemController implements Initializable, DataProvider {

    private Stage stage;
    private WindowUtil windowUtil;
    private Data data;

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button next;

    public AddItemController() {
        windowUtil = new WindowUtil();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(Strings.addItemBox);
        next.setDisable(true);
        choiceBox.setTooltip(new Tooltip("Wybierz kategorie"));
        choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
            next.setDisable(false);
            int choosedOption = newValue.intValue();
            next.setOnAction(x -> {
                stage = (Stage) choiceBox.getScene().getWindow();
                windowUtil.loadWindowAndSendData(Strings.addItemLayouts[choosedOption],
                        Strings.addItemNames[choosedOption], data);
                stage.close();
            });
        });
    }

    @Override
    public void getData(Data data) {
        this.data = data;
    }
}
