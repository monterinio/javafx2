package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public abstract class CancelButtonController implements Initializable {
    @FXML
    protected Button cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancel.setOnAction(x -> ((Stage) cancel.getScene().getWindow()).close());
    }
}
