package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.utils.SaveLoadUtil;
import pl.pwr.workshop.utils.WindowUtil;

public class MainController implements Initializable {

	private Data data;
	private ConnectionData connectionData;
	private WindowUtil windowUtil;
	private SaveLoadUtil saveLoadUtil;


	@FXML
	private MenuItem connectionSettingsItem;
	@FXML
	private MenuItem closeItem;
	@FXML
	private MenuItem aboutItem;

	public MainController() {
		data = new Data();
		saveLoadUtil = new SaveLoadUtil();
		windowUtil = new WindowUtil();
		connectionData = saveLoadUtil.loadApplicationState();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		configureMenuItems();
	}

	private void configureMenuItems() {
		connectionSettingsItem.setOnAction(x->windowUtil.loadWindowAndSendData(Strings.connectionLayoutName, Strings.connectionSettingsItemName, connectionData));
		aboutItem.setOnAction(x->windowUtil.loadWindow(Strings.aboutLayoutName,Strings.aboutItemName));
		closeItem.setOnAction(x->windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName));
	}



	public ConnectionData getConnectionData() {
		return connectionData;
	}
}
