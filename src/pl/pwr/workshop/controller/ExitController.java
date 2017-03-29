package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitController implements Initializable {

	@FXML
    private Button yesButton;

    @FXML
    private Button noButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		yesButton.setOnAction(x->{
			Platform.exit();
		});
		noButton.setOnAction(x-> ((Stage) noButton.getScene().getWindow()).close()); //najpierw pobiera sie stage z kontekstu noButton a potem zamyka to okno
	}

}
