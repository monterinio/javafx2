package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.OrderedItemsData;
import pl.pwr.workshop.utils.ConnectionUtil;

public class ProcessingController implements Initializable {

    private ConnectionData connectionData;
    private Data data;
    private OrderedItemsData orderedItemsData;

    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitButton.setOnAction(x -> {
            ((Stage) exitButton.getScene().getWindow()).close();
        });
    }

    public void getData(ConnectionData connectionData, Data data, OrderedItemsData orderedItemsData) {
        this.connectionData = connectionData;
        this.data = data;
        this.orderedItemsData = orderedItemsData;
    }

    public void startConnection() {
        ConnectionUtil.run(connectionData, data, orderedItemsData);
    }

}
