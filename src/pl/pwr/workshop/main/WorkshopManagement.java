package pl.pwr.workshop.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pwr.workshop.data.Strings;
import pl.pwr.workshop.utils.WindowUtil;

public class WorkshopManagement extends Application {
	private WindowUtil windowUtil;

	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		windowUtil = new WindowUtil();
		Parent parent = FXMLLoader.load(getClass().getResource(Strings.mainLayoutName));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setTitle(Strings.appName);
		primaryStage.show();
		primaryStage.setOnCloseRequest(x->{
			x.consume();
			windowUtil.loadWindow(Strings.exitLayoutName, Strings.exitItemName);
		});
	}

}
