package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ExitController extends CancelButtonController implements Initializable {

    @FXML
    private Button yesButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        yesButton.setOnAction(x -> {
            Platform.exit();
        });

    }
}
