package pl.pwr.workshop.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.utils.WindowUtil;

public class WorkshopManagement extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(Strings.MAIN_LAYOUT_NAME));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Strings.APP_NAME);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(x -> {
            x.consume();
            WindowUtil.loadWindow(Strings.EXIT_LAYOUT_NAME, Strings.EXIT_ITEM_NAME);
        });
    }

}
