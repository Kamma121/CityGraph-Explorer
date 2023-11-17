package controllers;

import graph.Graph;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CityMapController {

    private int selectedVertexCounter = 0;
    private List<Integer> destinations = new ArrayList<>();
    private static Graph connections;
    @FXML
    private Pane map;

    @FXML
    private Button startBtn;
    @FXML
    private Label startingPointLabel;
    @FXML
    private Label destinationPointLabel;
    @FXML
    private Label chooseStartingPointLabel;
    @FXML
    private Label chooseDestinationLabel;
    @FXML
    private Label firstFinalCommunicate;
    @FXML
    private Label secondFinalCommunicate;
    @FXML
    private Button tryAgainBtn;


    @FXML
    private Line l01, l12, l23, l34, l45, l411, l511, l06, l67, l78, l28, l39, l310, l1011, l1117, l89, l814, l915, l1516, l1617, l1620,
            l2021, l1721, l2126, l2025, l2526, l2529, l2024, l919, l1920, l1923, l713, l612, l1218, l1318, l1823, l1822, l2223,
            l2324, l2327, l2227, l2728, l2829;
    @FXML
    private Circle c0, c2, c3, c4, c6, c7, c8, c10, c11, c12, c13, c14, c15, c16, c19, c21, c22, c23, c24, c25;
    private static Set<Integer> places;


    @FXML
    public void vertexClick(Event event) {
        Circle clickedCircle = (Circle) event.getSource();
        if (selectedVertexCounter == 0) {
            clickedCircle.getStyleClass().add("first-clicked");
        } else {
            clickedCircle.getStyleClass().add("second-clicked");
        }
        destinations.add(Integer.parseInt(clickedCircle.getId()));
        selectedVertexCounter = (selectedVertexCounter + 1) % 2;
        if (selectedVertexCounter == 1) {
            this.startingPointLabel.setText("Point on the street");
            this.chooseStartingPointLabel.setText("Starting point: ");
            this.chooseDestinationLabel.setVisible(true);
        } else {
            this.destinationPointLabel.setText("Point on the street");
            this.chooseDestinationLabel.setText("Destination point: ");
            this.startBtn.setVisible(true);
        }
    }

    @FXML
    public void placeClick(Event event) {
        ImageView place = (ImageView) event.getSource();
        place.getStyleClass().add("selected-image");
        destinations.add(Integer.parseInt(place.getId()));
        selectedVertexCounter = (selectedVertexCounter + 1) % 2;
        if (selectedVertexCounter == 1) {
            this.startingPointLabel.setText(place.getAccessibleText());
            this.chooseStartingPointLabel.setText("Starting point: ");
            this.chooseDestinationLabel.setVisible(true);
        } else {
            this.destinationPointLabel.setText(place.getAccessibleText());
            this.chooseDestinationLabel.setText("Destination point: ");
            this.startBtn.setVisible(true);
        }
    }

    public static void initializeConnections() {
        connections = new Graph(30);
        places = new HashSet<>();
        places.add(1);
        places.add(5);
        places.add(9);
        places.add(17);
        places.add(18);
        places.add(20);
        places.add(26);
        places.add(27);
        places.add(28);
        places.add(29);
        connections.addEdge(0, 1, 1);
        connections.addEdge(1, 2, 1);
        connections.addEdge(2, 3, 2);
        connections.addEdge(3, 4, 3);
        connections.addEdge(4, 5, 4);
        connections.addEdge(0, 6, 2);
        connections.addEdge(2, 8, 2);
        connections.addEdge(3, 9, 3);
        connections.addEdge(3, 10, 3);
        connections.addEdge(10, 11, 1);
        connections.addEdge(4, 11, 1);
        connections.addEdge(11, 5, 4);
        connections.addEdge(11, 17, 5);
        connections.addEdge(6, 7, 2);
        connections.addEdge(7, 8, 2);
        connections.addEdge(8, 9, 2);
        connections.addEdge(9, 15, 2);
        connections.addEdge(15, 16, 1);
        connections.addEdge(16, 17, 3);
        connections.addEdge(16, 20, 1);
        connections.addEdge(17, 21, 2);
        connections.addEdge(6, 12, 2);
        connections.addEdge(7, 13, 4);
        connections.addEdge(8, 14, 1);
        connections.addEdge(14, 9, 1);
        connections.addEdge(9, 19, 1);
        connections.addEdge(12, 18, 4);
        connections.addEdge(13, 18, 3);
        connections.addEdge(19, 23, 4);
        connections.addEdge(19, 20, 3);
        connections.addEdge(20, 21, 2);
        connections.addEdge(21, 26, 2);
        connections.addEdge(18, 22, 3);
        connections.addEdge(18, 23, 3);
        connections.addEdge(22, 23, 3);
        connections.addEdge(22, 27, 4);
        connections.addEdge(23, 27, 3);
        connections.addEdge(23, 24, 2);
        connections.addEdge(24, 20, 2);
        connections.addEdge(27, 28, 4);
        connections.addEdge(28, 29, 4);
        connections.addEdge(29, 25, 2);
        connections.addEdge(25, 26, 2);
        connections.addEdge(25, 20, 3);
    }

    public void findShortestPath() {
        int startVertex = this.destinations.get(0);
        int endVertex = this.destinations.get(1);
        List<Integer> vertices = connections.dijkstra(startVertex, endVertex);
        Thread animationThread = new Thread(() -> {
            int i = 0;
            while (i + 1 < vertices.size()) {
                int start = Math.min(vertices.get(i), vertices.get(i + 1));
                int end = Math.max(vertices.get(i), vertices.get(i + 1));
                String path = "l" + Integer.toString(start) + Integer.toString(end);
                String circlePath = "c" + Integer.toString(vertices.get(i + 1));
                Line line = null;
                Circle circle = null;
                try {
                    line = (Line) this.getClass().getDeclaredField(path).get(this);
                    line.getStyleClass().add("color-line");
                    if (end != vertices.getLast() && !places.contains(vertices.get(i + 1))) {
                        circle = (Circle) this.getClass().getDeclaredField(circlePath).get(this);
                        circle.getStyleClass().add("color-vertex");
                    }
                    Thread.sleep(400);
                } catch (IllegalAccessException | NoSuchFieldException | InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    i++;
                }
            }
            this.firstFinalCommunicate.setVisible(true);
            this.secondFinalCommunicate.setVisible(true);
            this.tryAgainBtn.setVisible(true);
        });
        animationThread.start();
        this.startBtn.setVisible(false);
    }

    public void tryAgainAction() {
        Platform.runLater(() -> {
            try {
                Stage currentStage = (Stage) map.getScene().getWindow();
                currentStage.close();
                application.CityGraphExplorerApplication newApp = new application.CityGraphExplorerApplication();
                newApp.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}