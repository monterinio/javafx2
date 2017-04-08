package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public abstract class OkButtonController implements Initializable {
    @FXML
    protected Button okButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        okButton.setOnAction(x -> ((Stage) okButton.getScene().getWindow()).close());
    }
}
