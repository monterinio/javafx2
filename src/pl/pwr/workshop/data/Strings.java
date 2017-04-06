package pl.pwr.workshop.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Strings {
	public final static String exitLayoutName = "/pl/pwr/workshop/view/ExitLayout.fxml";
	public final static String aboutLayoutName = "/pl/pwr/workshop/view/AboutLayout.fxml";
	public final static String connectionLayoutName = "/pl/pwr/workshop/view/ConnectionLayout.fxml";
	public final static String mainLayoutName = "/pl/pwr/workshop/view/MainLayout.fxml";
	public final static String processingLayoutName = "/pl/pwr/workshop/view/ProcessingLayout.fxml";
	public final static String IPErrorLayoutName = "/pl/pwr/workshop/view/IPErrorLayout.fxml";
	public final static String addItemLayoutName = "/pl/pwr/workshop/view/AddItemLayout.fxml";
	public final static String exitItemName = "Wyjœcie";
	public final static String aboutItemName = "O programie";
	public final static String connectionSettingsItemName = "Opcje pol¹czenia";
	public final static String processingItemName = "Nawi¹zywanie pol¹czenia";
	public final static String IPErrorItemName = "Blad!";
	public final static String appName = "Industrial Control v0.1";
	public final static String fileName = "connectionData.obj";
	public final static String addElementName = "Dodaj przedmiot";
	public final static ObservableList<String> choiceBox = FXCollections.observableArrayList("Rury i kable", "Elementy", "Zawory i silniki");
	public final static ObservableList<String> addItemBox = FXCollections.observableArrayList("Rury", "Kable", "Elementy", "Zawory", "Silniki");

	public final static String [] addItemLayouts = { "/pl/pwr/workshop/data/view/AddPipeLayout.fxml",
									  "/pl/pwr/workshop/data/view/AddCableLayout.fxml",
									  "/pl/pwr/workshop/data/view/AddElementLayout.fxml",
									  "/pl/pwr/workshop/data/view/AddValveLayout.fxml",
									  "/pl/pwr/workshop/data/view/AddMotorLayout.fxml" };

	public final static String [] addItemNames = { "Dodaj rure",
												"Dodaj kabel",
												"Dodaj srube/zakretke/podkladke",
												"Dodaj zawor",
												"Dodaj silnik"
	};

	public final static int portNumber = 9999;
}
