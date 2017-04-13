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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.Element;
import pl.pwr.workshop.data.OrderedItemsData;
import pl.pwr.workshop.data.OrderedStoredItemsParameters;
import pl.pwr.workshop.data.PipeCable;
import pl.pwr.workshop.data.StoredItem;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.data.ValveMotor;
import pl.pwr.workshop.utils.SaveLoadUtil;
import pl.pwr.workshop.utils.WindowUtil;

public class MainController implements Initializable {

    private ConnectionData connectionData;
    private Data data;
    private OrderedItemsData orderedItemsData;

    @FXML
    private Button confirmOrder;
    @FXML
    private Button addElement;
    @FXML
    private Button refresh;
    @FXML
    private Button deleteItem;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private MenuItem connectionSettingsItem;
    @FXML
    private MenuItem closeItem;
    @FXML
    private MenuItem aboutItem;

    @FXML
    private TableView<StoredItem> storedItemsList;
    @FXML
    private TableColumn<StoredItem, String> nameColumnStored;
    @FXML
    private TableColumn<StoredItem, Integer> quantityColumnStored;

    @FXML
    private TableView<StoredItem> orderedItemsList;
    @FXML
    private TableColumn<StoredItem, String> nameColumnOrdered;
    @FXML
    private TableColumn<StoredItem, Integer> quantityColumnOrdered;

    public MainController() {
        data = SaveLoadUtil.loadApplicationState(new Data());
        connectionData = SaveLoadUtil.loadApplicationState();
        orderedItemsData = new OrderedItemsData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeStoredItemsTable();
        initializeOrderedItemsTable();
        configureMenuItems();
        configureButtons();
        configureChoiceBox();
        refreshTable();
        choiceBox.setItems(Strings.CHOICE_BOX);
    }

    private void initializeStoredItemsTable() {
        nameColumnStored.setCellValueFactory(new PropertyValueFactory<StoredItem, String>("fullName"));
        quantityColumnStored.setCellValueFactory(new PropertyValueFactory<StoredItem, Integer>("quantity"));
        setRowFactory();
    }

    private void initializeOrderedItemsTable() {
        nameColumnOrdered.setCellValueFactory(new PropertyValueFactory<StoredItem, String>("fullName"));
        quantityColumnOrdered.setCellValueFactory(new PropertyValueFactory<StoredItem, Integer>("quantity"));
        Bindings.bindContent(orderedItemsList.getItems(), orderedItemsData.getOrderedItemsList());
        orderedItemsRowFactory();
    }

    private void configureMenuItems() {
        connectionSettingsItem.setOnAction(x -> WindowUtil.loadWindowAndSendData(Strings.CONNECTION_LAYOUT_NAME,
                Strings.CONNECTION_SETTINGS_ITEM_NAME, connectionData));
        aboutItem.setOnAction(x -> WindowUtil.loadWindow(Strings.ABOUT_LAYOUT_NAME, Strings.ABOUT_ITEM_NAME));
        closeItem.setOnAction(x -> WindowUtil.loadWindow(Strings.EXIT_LAYOUT_NAME, Strings.EXIT_ITEM_NAME));
    }

    private void configureButtons() {
        addElement.addEventHandler(MouseEvent.MOUSE_CLICKED, x -> {
            WindowUtil.loadWindowAndSendData(Strings.ADD_ITEM_LAYOUT_NAME, Strings.ADD_ELEMENT_NAME, data);
        });
        refresh.setOnAction(x -> {
            storedItemsList.refresh();
        });
        confirmOrder.setOnAction(x -> {
            SaveLoadUtil.saveApplicationState(data);
            WindowUtil.loadWindowAndSendData(Strings.PROCESSING_LAYOUT_NAME, Strings.PROCESSING_LAYOUT_NAME, connectionData,
                    data, orderedItemsData);
        });
        deleteItem.setOnAction(x -> {
            int selectedItemIndex = storedItemsList.getSelectionModel().getSelectedIndex();
            if(choiceBox.getSelectionModel().getSelectedIndex() == Strings.PIPE_CABLE) {
                data.getPipeCableList().remove(selectedItemIndex);
            } else if(choiceBox.getSelectionModel().getSelectedIndex() == Strings.ELEMENT) {
                data.getElementList().remove(selectedItemIndex);
            } else if(choiceBox.getSelectionModel().getSelectedIndex() == Strings.VALVE_MOTOR) {
                data.getValveMotorList().remove(selectedItemIndex);
            }
        });
    }

    private void configureChoiceBox() {
        choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
            if (newValue.intValue() == Strings.PIPE_CABLE) {
                Bindings.bindContent(storedItemsList.getItems(), data.getPipeCableList());
            } else if (newValue.intValue() == Strings.ELEMENT) {
                Bindings.bindContent(storedItemsList.getItems(), data.getElementList());
            } else if (newValue.intValue() == Strings.VALVE_MOTOR) {
                Bindings.bindContent(storedItemsList.getItems(), data.getValveMotorList());
            }
        });
    }

    private void refreshTable() {
        storedItemsList.addEventHandler(MouseEvent.MOUSE_ENTERED, x -> {
            storedItemsList.refresh();
        });
    }

    private TableRow<PipeCable> setRowFactory() {
        storedItemsList.setRowFactory(tv -> {
            TableRow<StoredItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    StoredItem rowData = getRowElement(row);
                    WindowUtil.loadWindowAndSendData(Strings.SPECIFY_QUANTITY_LAYOUT_NAME, Strings.SPECIFY_QUANTITY_NAME,
                            rowData, orderedItemsData);
                }
            });
            return row;
        });
        return null;
    }

    private StoredItem getRowElement(TableRow<StoredItem> row) {
        StoredItem rowData = null;
        if (choiceBox.getSelectionModel().getSelectedIndex() == Strings.PIPE_CABLE) {
            rowData = (PipeCable) row.getItem();
            System.out.println(rowData.getFullName());
        } else if (choiceBox.getSelectionModel().getSelectedIndex() == Strings.ELEMENT) {
            rowData = (Element) row.getItem();
        } else if (choiceBox.getSelectionModel().getSelectedIndex() == Strings.VALVE_MOTOR) {
            rowData = (ValveMotor) row.getItem();
        }
        return rowData;
    }

    private TableRow<PipeCable> orderedItemsRowFactory() {
        orderedItemsList.setRowFactory(tv -> {
            TableRow<StoredItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    StoredItem rowData = row.getItem();
                    updateStoredItemsList(new OrderedStoredItemsParameters(rowData));
                    orderedItemsData.getOrderedItemsList().remove(rowData);
                }
            });
            return row;
        });
        return null;
    }

    private void updateStoredItemsList(OrderedStoredItemsParameters orderedStoredItemsParameters) {
        // TODO: Improve this in the future
        data.fillStoredItemsList();
        for (int i = 0; i < data.getStoredItemsList().size(); i++) {
            orderedStoredItemsParameters.setStoredItemFullName(data.getStoredItemsList().get(i).getFullName());
            if (orderedStoredItemsParameters.isEqual()) {
                orderedStoredItemsParameters.setStoredItemQuantity(data.getStoredItemsList().get(i).getQuantity());
                data.getStoredItemsList().get(i).setQuantity(orderedStoredItemsParameters.calculateSum());
            }
        }

    }

    public ConnectionData getConnectionData() {
        return connectionData;
    }
}
