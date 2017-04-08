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
    private RegexUtil regexUtil;
    private WindowUtil windowUtil;
    private SaveLoadUtil saveLoadUtil;

    @FXML
    private Button cancel;

    @FXML
    private Button saveAndExit;

    @FXML
    private TextField serverIP;

    @FXML
    private TextField coComputerIP;

    public ConnectionController() {
        saveLoadUtil = new SaveLoadUtil();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveAndExit.setOnAction(x -> {
            regexUtil = new RegexUtil();
            if (regexUtil.checkIP(serverIP.getText())) {
                connectionData.setServerIP(serverIP.getText());
                connectionData.setCoComputerIP(coComputerIP.getText());
                saveLoadUtil.saveApplicationState(getConnectionData());
                ((Stage) saveAndExit.getScene().getWindow()).close();
            } else {
                windowUtil = new WindowUtil();
                windowUtil.loadWindow(Strings.IPErrorLayoutName, Strings.IPErrorItemName);
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
