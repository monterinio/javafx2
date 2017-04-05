package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.StoredItem;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.utils.SaveLoadUtil;
import pl.pwr.workshop.utils.WindowUtil;

public class MainController implements Initializable {

	private ConnectionData connectionData;
	private WindowUtil windowUtil;
	private SaveLoadUtil saveLoadUtil;
	private Data data;

	@FXML
    private Button confirmOrder;
    @FXML
    private Button addElement;
    @FXML
    private Button deleteOrderedItem;
    @FXML
    private ChoiceBox<String> choiceBox;
	@FXML
	private MenuItem connectionSettingsItem;
	@FXML
	private MenuItem closeItem;
	@FXML
	private MenuItem aboutItem;

	@FXML
	private TableView<StoredItem> workshopList;
    @FXML
    private TableColumn<StoredItem, String> nameColumn;
    @FXML
    private TableColumn<StoredItem, Integer> quantityColumn;

	public MainController() {
		saveLoadUtil = new SaveLoadUtil();
		windowUtil = new WindowUtil();
		connectionData = saveLoadUtil.loadApplicationState();
		data = new Data();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeTable();
		configureMenuItems();
		configureButtons();
		configureChoiceBox();
		choiceBox.setItems(Strings.choiceBox);
	}

	private void initializeTable() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<StoredItem, String>("fullName"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<StoredItem, Integer>("quantity"));
	}

	private void configureMenuItems() {
		connectionSettingsItem.setOnAction(x->windowUtil.loadWindowAndSendData(Strings.connectionLayoutName, Strings.connectionSettingsItemName, connectionData));
		aboutItem.setOnAction(x->windowUtil.loadWindow(Strings.aboutLayoutName,Strings.aboutItemName));
		closeItem.setOnAction(x->windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName));
	}

	private void configureButtons() {
		addElement.setOnAction(x-> {
			workshopList.refresh();
			windowUtil.loadWindowAndSendData(Strings.addItemLayoutName, Strings.addElementName, data);
		});
	}

	private void configureChoiceBox() {
		choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
			if(newValue.intValue() == 0) {
				Bindings.bindContent(workshopList.getItems(), data.getPipeCableList());
			}
			else if(newValue.intValue() == 1) {
				Bindings.bindContent(workshopList.getItems(), data.getElementList());
			}
		});
	}

	public ConnectionData getConnectionData() {
		return connectionData;
	}
}
