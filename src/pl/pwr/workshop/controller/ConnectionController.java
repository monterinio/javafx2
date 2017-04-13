package pl.pwr.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.utils.RegexUtil;
import pl.pwr.workshop.utils.SaveLoadUtil;
import pl.pwr.workshop.utils.WindowUtil;

public class ConnectionController implements Initializable, ConnectionDataProvider {

    private ConnectionData connectionData;

    @FXML
    private Button cancel;

    @FXML
    private Button saveAndExit;

    @FXML
    private TextField serverIP;

    @FXML
    private TextField coComputerIP;

    public ConnectionController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveAndExit.setOnAction(x -> {
            if (RegexUtil.checkIP(serverIP.getText())) {
                connectionData.setServerIP(serverIP.getText());
                connectionData.setCoComputerIP(coComputerIP.getText());
                SaveLoadUtil.saveApplicationState(getConnectionData());
                ((Stage) saveAndExit.getScene().getWindow()).close();
            } else {
                WindowUtil.loadWindow(Strings.IP_ERROR_LAYOUT_NAME, Strings.ERROR_ITEM_NAME);
            }
        });
        cancel.setOnAction(x -> ((Stage) cancel.getScene().getWindow()).close());
    }

    public void getConnectionData(ConnectionData connectionData) {
        setConnectionData(connectionData);
        serverIP.setText(connectionData.getServerIP());
        coComputerIP.setText(connectionData.getCoComputerIP());
    }

    public ConnectionData getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(ConnectionData connectionData) {
        this.connectionData = connectionData;
    }

}
