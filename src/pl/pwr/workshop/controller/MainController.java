package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
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
import pl.pwr.workshop.data.Pipe;
import pl.pwr.workshop.data.PipeCable;
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
	private TableView<PipeCable> workshopList;
    @FXML
    private TableColumn<PipeCable, SimpleStringProperty> nameColumn;
    @FXML
    private TableColumn<PipeCable, Integer> quantityColumn;

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
		nameColumn.setCellValueFactory(new PropertyValueFactory<PipeCable, SimpleStringProperty>("fullName"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<PipeCable, Integer>("quantity"));
		workshopList.setItems(data.getPipeCableList());
	}

	private void configureMenuItems() {
		connectionSettingsItem.setOnAction(x->windowUtil.loadWindowAndSendData(Strings.connectionLayoutName, Strings.connectionSettingsItemName, connectionData));
		aboutItem.setOnAction(x->windowUtil.loadWindow(Strings.aboutLayoutName,Strings.aboutItemName));
		closeItem.setOnAction(x->windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName));
	}

	private void configureButtons() {
		addElement.setOnAction(x-> {
			windowUtil.loadWindowAndSendData(Strings.addItemLayoutName, Strings.addElementName, data);
		});
	}

	private void configureChoiceBox() {
		choiceBox.setOnAction(x-> {
			for(int i=0;i<data.getPipeCableList().size();i++) {
				Pipe pipe = (Pipe) data.getPipeCableList().get(i);
				System.out.println(pipe.getFullName());
			}
		});
	}

	public ConnectionData getConnectionData() {
		return connectionData;
	}
}
