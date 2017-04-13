package pl.pwr.workshop.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Strings {
    public final static String EXIT_LAYOUT_NAME = "/pl/pwr/workshop/view/ExitLayout.fxml";
    public final static String ABOUT_LAYOUT_NAME = "/pl/pwr/workshop/view/AboutLayout.fxml";
    public final static String CONNECTION_LAYOUT_NAME = "/pl/pwr/workshop/view/ConnectionLayout.fxml";
    public final static String MAIN_LAYOUT_NAME = "/pl/pwr/workshop/view/MainLayout.fxml";
    public final static String PROCESSING_LAYOUT_NAME = "/pl/pwr/workshop/view/ProcessingLayout.fxml";
    public final static String IP_ERROR_LAYOUT_NAME = "/pl/pwr/workshop/view/IPErrorLayout.fxml";
    public final static String ADD_ITEM_LAYOUT_NAME = "/pl/pwr/workshop/view/AddItemLayout.fxml";
    public final static String SPECIFY_QUANTITY_LAYOUT_NAME = "/pl/pwr/workshop/view/SpecifyQuantityLayout.fxml";
    public final static String NOT_ENOUGH_ITEMS_LAYOUT_NAME = "/pl/pwr/workshop/view/NotEnoughItemsLayout.fxml";
    public final static String EXIT_ITEM_NAME = "Wyjœcie";
    public final static String ABOUT_ITEM_NAME = "O programie";
    public final static String CONNECTION_SETTINGS_ITEM_NAME = "Opcje pol¹czenia";
    public final static String PROCESSING_ITEM_NAME = "Nawi¹zywanie pol¹czenia";
    public final static String ERROR_ITEM_NAME = "Blad!";
    public final static String APP_NAME = "Industrial Control v0.1";
    public final static String CONNECTION_FILE_NAME = "connectionData.obj";
    public final static String DATA_PIPECABLE_FILE_NAME = "dataPipeCable.obj";
    public final static String DATA_ELEMENT_FILE_NAME = "dataElement.obj";
    public final static String DATA_VALVEMOTOR_FILE_NAME = "dataValveMotor.obj";
    public final static String ADD_ELEMENT_NAME = "Dodaj przedmiot";
    public final static String SPECIFY_QUANTITY_NAME = "Okresl ilosc";
    public final static ObservableList<String> CHOICE_BOX = FXCollections.observableArrayList("Rury i kable", "Elementy",
            "Zawory i silniki");
    public final static ObservableList<String> ADD_ITEM_BOX = FXCollections.observableArrayList("Rury", "Kable",
            "Elementy", "Zawory", "Silniki");

    public final static String[] ADD_ITEM_LAYOUTS = { "/pl/pwr/workshop/data/view/AddPipeLayout.fxml",
            "/pl/pwr/workshop/data/view/AddCableLayout.fxml", "/pl/pwr/workshop/data/view/AddElementLayout.fxml",
            "/pl/pwr/workshop/data/view/AddValveLayout.fxml", "/pl/pwr/workshop/data/view/AddMotorLayout.fxml" };

    public final static String[] ADD_ITEM_NAMES = { "Dodaj rure", "Dodaj kabel", "Dodaj srube/zakretke/podkladke",
            "Dodaj zawor", "Dodaj silnik" };
    public final static int PIPE_CABLE = 0;
    public final static int ELEMENT = 1;
    public final static int VALVE_MOTOR = 2;

    public final static int PORT_NUMBER = 9999;
}
