
# CityGraph Explorer

CityGraph Explorer is a JavaFX application designed to navigate and explore the shortest path between two points or places on a map. Utilizing **Dijkstra's algorithm**, this tool provides an intuitive interface for users to visualize and analyze the optimal route. CityGraph Explorer makes it easy to discover the most direct path between destinations on a customized map. Explore the city and find efficient routes with CityGraph Explorer!


## Features

- **Interactive Map Navigation:** Explore an interactive map interface by simply clicking on desired location.
- **Shortest Path Calculation:** Utilize Dijkstra's algorithm to find the shortest path between two selected points or places.
- **Visual Path Highlighting:** Visually trace the computed shortest path, step by step on the map.


## Screenshots
**Shortest path between two places:**
![betweenPlaces](https://github.com/Kamma121/CityGraph-Explorer/assets/109139766/36b2ac87-9ab4-4f16-ab0f-ba33a8613078)

**Shortest path between two points:**
![betweenPoints](https://github.com/Kamma121/CityGraph-Explorer/assets/109139766/b0a58c48-913c-4ac3-9930-ea733b685b1a)

**Shortest path between point and place:**
![betweenPointAndPlace](https://github.com/Kamma121/CityGraph-Explorer/assets/109139766/4a88c02b-de27-4cd3-a546-c7e345f62e63)



## Technologies and Techniques Used
- **Java**
- **JavaFX**
- **FXML**
- **CSS**

 **Graph and Dijkstra's Algorithm**

- Implemented a weighted graph as a city structure to show connections between places.
- Utilized Dijkstra's algorithm for efficient computation of the shortest path between two destinations on map.

**Multi-Threading**

- Implemented multi-threading techniques to efficently show shortest path. The use of *Thread.sleep()* introduces a delay for each iteration, contributing to a visually appealing animation effect.

**Unit Testing**

- Used JUnit for writing and executing unit tests to validate the functionality of *Graph* class.
- The unit tests aimed to validate the functionality of methods, especially the implementation of *Dijkstra's algorithm*.
## How to use
- Launch the application
- Select starting point
- Select destination point
- Click *Start* button
- Explore shortest path highlighted on map
- Try again!
## Installation

1. Clone the repository:

```bash
  git clone https://github.com/Kamma121/CityGraph-Explorer.git
```

2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build and run the application.
    
