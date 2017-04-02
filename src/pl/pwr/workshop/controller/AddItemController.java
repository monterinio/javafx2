package pl.pwr.workshop.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.utils.WindowUtil;

public class AddItemController implements Initializable {

	private Stage stage;
	private WindowUtil windowUtil;

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
			next.setOnAction(x-> {
			stage = (Stage) choiceBox.getScene().getWindow();
			windowUtil.loadWindow(Strings.addItemLayouts[newValue.intValue()], Strings.addItemNames[newValue.intValue()]);
			stage.close();
		});
	});
  }



}
