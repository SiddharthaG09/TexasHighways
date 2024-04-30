import java.util.*;

/*
* Copy the constructor and methods from your previous assignment.
* You may add additional instance variables to help your optimization.
*/
public class Vertex implements Comparable<Vertex> {

    private int id; // Vertex ID which is also it's key in your Map
    private String name; // Friendly name to identify the location
    private double latitude;
    private double longitude;
    private List<Edge> edgeList;
    private double distance; // distance from the starting vertex (source)
    private Vertex previous; // the previous vertex on the shortest path
    private double distanceTillEnd;

    public Vertex(int id, String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        edgeList = new ArrayList<>();
        this.id = id;
        this.distanceTillEnd = 0;
        distance = Integer.MAX_VALUE;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*
     * public void setVisited(boolean visited)
     * {
     * this.visited = visited;
     * }
     * 
     * 
     * public boolean getVisited()
     * {
     * return visited;
     * }
     */
    public void setList(List<Edge> list) {
        edgeList = list;
    }

    public List<Edge> getList() {
        return edgeList;
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setEnd(Vertex end) {
        this.distanceTillEnd = Main.calculateDistance(this.latitude, this.longitude, end.latitude, end.longitude);
    }

    @Override // Do not change the equals or toString methods.
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (this.id != other.id || !this.name.equals(other.name) ||
                this.edgeList.size() != other.edgeList.size()) {
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++) {
            if (!this.edgeList.get(i).equals(other.edgeList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // Do not change the equals or toString methods.
    public String toString() {
        return id + "(" + name + ")";
    }

    public int compareTo(Vertex other) {
        if (this.distance + distanceTillEnd > other.getDistance() + other.distanceTillEnd) {
            return 1;
        } else if (other.getDistance() + other.distanceTillEnd > this.distance + distanceTillEnd) {
            return -1;
        }
        return 0;
    }
}