package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AboutController extends OkButtonController {

    @FXML
    private TextArea tArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        tArea.setEditable(false);
    }

}
