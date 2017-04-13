package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.OrderedItemsData;
import pl.pwr.workshop.data.StoredItem;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.data.utils.TextFieldNumericValidation;
import pl.pwr.workshop.utils.WindowUtil;

public class SpecifyQuantityController extends CancelButtonController implements Initializable {

    @FXML
    private TextField quantity;
    @FXML
    private Button okButton;

    private ArrayList<TextField> list;
    private OrderedItemsData orderedItemsData;
    private StoredItem rowData;

    public SpecifyQuantityController() {
        list = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        configureTextField();
        configureButtons();
    }

    private void configureTextField() {
        list.add(quantity);
        quantity.textProperty().addListener(new TextFieldNumericValidation(okButton, list, quantity));
    }

    private void configureButtons() {
        okButton.setDisable(true);
        okButton.setOnAction(x -> {
            int requestedQuantity = Integer.parseInt(quantity.getText());
            int actualQuantity = rowData.getQuantity();
            if (requestedQuantity > actualQuantity) {
                WindowUtil.loadWindow(Strings.NOT_ENOUGH_ITEMS_LAYOUT_NAME, Strings.ERROR_ITEM_NAME);
            } else {
                StoredItem orderedDataItem = new StoredItem(rowData);
                orderedDataItem.setQuantity(requestedQuantity);
                rowData.setQuantity(actualQuantity - requestedQuantity);
                orderedItemsData.getOrderedItemsList().add(orderedDataItem);
                ((Stage) okButton.getScene().getWindow()).close();
            }
        });
    }

    public void getData(StoredItem rowData, OrderedItemsData orderedItemsData) {
        this.rowData = rowData;
        this.orderedItemsData = orderedItemsData;
    }

}
