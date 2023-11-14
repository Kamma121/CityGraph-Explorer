package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CityMapController {
    @FXML
    private Label welcomeText;
    //30 vertices

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}