package application;

import controller.CityMapController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class CityGraphExplorerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/CityMap.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600, 900);
        stage.setTitle("CityGraph Explorer");
        stage.getIcons().add(new Image("/images/borderIcon.png"));
        stage.setScene(scene);
        stage.show();
        CityMapController.initializeConnections();
    }

    public static void main(String[] args) {
        launch();
    }
}