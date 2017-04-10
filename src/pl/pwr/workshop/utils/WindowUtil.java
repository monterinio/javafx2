package pl.pwr.workshop.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.pwr.workshop.controller.ConnectionDataProvider;
import pl.pwr.workshop.controller.ProcessingController;
import pl.pwr.workshop.controller.SpecifyQuantityController;
import pl.pwr.workshop.data.ConnectionData;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.OrderedItemsData;
import pl.pwr.workshop.data.StoredItem;
import pl.pwr.workshop.data.controller.DataProvider;

public class WindowUtil {

	public void loadWindow(String path, String appName) {
		try {
			Stage subWindow = new Stage();
			subWindow.setResizable(false);
			subWindow.initModality(Modality.APPLICATION_MODAL);
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource(path));
			Scene scene = new Scene(parent);
			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendData(String path, String appName, ConnectionData connectionData) {
		try {
			Stage subWindow = new Stage();
			subWindow.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader();
			Parent parent = loader.load(getClass().getResource(path).openStream());
			ConnectionDataProvider controller = loader.getController();
			controller.getConnectionData(connectionData);
			Scene scene = new Scene(parent);
			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendData(String path, String appName, Data data) {
		try {
			Stage subWindow = new Stage();
			subWindow.setResizable(false);
			subWindow.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader();
			Parent parent = loader.load(getClass().getResource(path).openStream());
			DataProvider controller = loader.getController();
			controller.getData(data);
			Scene scene = new Scene(parent);
			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendData(String path, String appName, ConnectionData connectionData, Data data, OrderedItemsData orderedItemsList) {
		try {
			Stage subWindow = new Stage();
			subWindow.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader();
			Parent parent = loader.load(getClass().getResource(path).openStream());
			ProcessingController processingController = (ProcessingController) loader.getController();
			processingController.getData(connectionData, data, orderedItemsList);
			Scene scene = new Scene(parent);
			processingController.startConnection();
			subWindow.setScene(scene);
			subWindow.setTitle(appName);
			subWindow.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void loadWindowAndSendData(String path, String appName, StoredItem rowData, OrderedItemsData orderedItemsData) {
            try {
                    Stage subWindow = new Stage();
                    subWindow.initModality(Modality.APPLICATION_MODAL);
                    FXMLLoader loader = new FXMLLoader();
                    Parent parent = loader.load(getClass().getResource(path).openStream());
                    SpecifyQuantityController quantityController = (SpecifyQuantityController) loader.getController();
                    quantityController.getData(rowData, orderedItemsData);
                    Scene scene = new Scene(parent);
                    subWindow.setScene(scene);
                    subWindow.setTitle(appName);
                    subWindow.show();
            } catch(IOException e) {
                    e.printStackTrace();
            }
    }

}
