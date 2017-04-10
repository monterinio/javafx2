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
    private WindowUtil windowUtil;
    private SaveLoadUtil saveLoadUtil;
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
        saveLoadUtil = new SaveLoadUtil();
        windowUtil = new WindowUtil();
        data = saveLoadUtil.loadApplicationState(new Data());
        connectionData = saveLoadUtil.loadApplicationState();
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
        choiceBox.setItems(Strings.choiceBox);
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

    private TableRow<PipeCable> setRowFactory() {
        storedItemsList.setRowFactory(tv -> {
            TableRow<StoredItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    StoredItem rowData = getRowElement(row);
                    windowUtil.loadWindowAndSendData(Strings.specifyQuantityLayoutName, Strings.specifyQuantityName,
                            rowData, orderedItemsData);
                }
            });
            return row;
        });
        return null;
    }

    private StoredItem getRowElement(TableRow<StoredItem> row) {
        StoredItem rowData = null;
        if (choiceBox.getSelectionModel().getSelectedIndex() == 0) {
            rowData = (PipeCable) row.getItem();
            System.out.println(rowData.getFullName());
        } else if (choiceBox.getSelectionModel().getSelectedIndex() == 1) {
            rowData = (Element) row.getItem();
        } else if (choiceBox.getSelectionModel().getSelectedIndex() == 2) {
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

    private void configureMenuItems() {
        connectionSettingsItem.setOnAction(x -> windowUtil.loadWindowAndSendData(Strings.connectionLayoutName,
                Strings.connectionSettingsItemName, connectionData));
        aboutItem.setOnAction(x -> windowUtil.loadWindow(Strings.aboutLayoutName, Strings.aboutItemName));
        closeItem.setOnAction(x -> windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName));
    }

    private void configureButtons() {
        addElement.addEventHandler(MouseEvent.MOUSE_CLICKED, x -> {
            windowUtil.loadWindowAndSendData(Strings.addItemLayoutName, Strings.addElementName, data);
        });
        refresh.setOnAction(x -> {
            storedItemsList.refresh();
        });
        confirmOrder.setOnAction(x -> {
            saveLoadUtil.saveApplicationState(data);
            windowUtil.loadWindowAndSendData(Strings.processingLayoutName, Strings.processingItemName, connectionData,
                    data, orderedItemsData);
        });
        deleteItem.setOnAction(x -> {
            int selectedItemIndex = storedItemsList.getSelectionModel().getSelectedIndex();
            if(choiceBox.getSelectionModel().getSelectedIndex() == 0) {
                data.getPipeCableList().remove(selectedItemIndex);
            } else if(choiceBox.getSelectionModel().getSelectedIndex() == 1) {
                data.getElementList().remove(selectedItemIndex);
            } else if(choiceBox.getSelectionModel().getSelectedIndex() == 2) {
                data.getValveMotorList().remove(selectedItemIndex);
            }
        });
    }

    private void refreshTable() {
        storedItemsList.addEventHandler(MouseEvent.MOUSE_ENTERED, x -> {
            storedItemsList.refresh();
        });
    }

    private void configureChoiceBox() {
        choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
            if (newValue.intValue() == 0) {
                Bindings.bindContent(storedItemsList.getItems(), data.getPipeCableList());
            } else if (newValue.intValue() == 1) {
                Bindings.bindContent(storedItemsList.getItems(), data.getElementList());
            } else if (newValue.intValue() == 2) {
                Bindings.bindContent(storedItemsList.getItems(), data.getValveMotorList());
            }
        });
    }

    public ConnectionData getConnectionData() {
        return connectionData;
    }
}
