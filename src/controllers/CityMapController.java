package controllers;

import graph.Graph;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;

import java.awt.event.ActionEvent;

public class CityMapController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    private int selectedVertexCounter = 0;
    @FXML
    public void vertexClick(Event event) {
        Circle clickedCircle = (Circle) event.getSource();
        if(selectedVertexCounter == 0){
            clickedCircle.getStyleClass().add("first-clicked");
        }else{
            clickedCircle.getStyleClass().add("second-clicked");
        }
        selectedVertexCounter = (selectedVertexCounter + 1) % 2;
        System.out.println(clickedCircle.getId());
    }

    private Graph connections = new Graph(30);

    public void initializeConnections() {
        this.connections.addEdge(0, 1, 1);
        this.connections.addEdge(1, 2, 1);
        this.connections.addEdge(2, 3, 2);
        this.connections.addEdge(3, 4, 3);
        this.connections.addEdge(4, 5, 4);
        this.connections.addEdge(0, 6, 2);
        this.connections.addEdge(2, 8, 2);
        this.connections.addEdge(3, 9, 3);
        this.connections.addEdge(3, 10, 2);
        this.connections.addEdge(10, 11, 1);
        this.connections.addEdge(4, 11, 1);
        this.connections.addEdge(11, 5, 3);
        this.connections.addEdge(11, 17, 5);
        this.connections.addEdge(6, 7, 2);
        this.connections.addEdge(7, 8, 2);
        this.connections.addEdge(8, 9, 2);
        this.connections.addEdge(9, 15, 2);
        this.connections.addEdge(15, 16, 1);
        this.connections.addEdge(16, 17, 3);
        this.connections.addEdge(16, 20, 1);
        this.connections.addEdge(17, 21, 2);
        this.connections.addEdge(6, 12, 2);
        this.connections.addEdge(7, 13, 4);
        this.connections.addEdge(8, 14, 1);
        this.connections.addEdge(14, 9, 1);
        this.connections.addEdge(9, 19, 1);
        this.connections.addEdge(12, 18, 4);
        this.connections.addEdge(13, 18, 3);
        this.connections.addEdge(19, 23, 4);
        this.connections.addEdge(19, 20, 3);
        this.connections.addEdge(20, 21, 2);
        this.connections.addEdge(21, 26, 2);
        this.connections.addEdge(18, 22, 3);
        this.connections.addEdge(18, 23, 3);
        this.connections.addEdge(22, 23, 3);
        this.connections.addEdge(22, 27, 4);
        this.connections.addEdge(23, 27, 3);
        this.connections.addEdge(23, 24, 2);
        this.connections.addEdge(24, 20, 2);
        this.connections.addEdge(27, 28, 4);
        this.connections.addEdge(28, 29, 4);
        this.connections.addEdge(29, 25, 2);
        this.connections.addEdge(25, 26, 2);
        this.connections.addEdge(25, 20, 3);
    }
}