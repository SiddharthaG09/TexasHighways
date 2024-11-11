import java.util.*;

/*
* Instructions:
* 1. Complete the constructor 
* 2. Set distance to Integer.MAX_VALUE and previous to null.
* 3. Create getter methods for all instance variables.
* 4. Create setter methods for setPrevious and setDistance. 
* 5. You will also need an addEdge method that will add a 
*    given edge to the edgeList.
* 6. Implement the interface Comparable using distance for
*    the compareTo method.
*/
public class Vertex implements Comparable<Vertex> {

    private int id;           // Vertex ID which is also it's key in your Map
    private String name;      // Friendly name to identify the location
    private double latitude;   
    private double longitude;
    private List<Edge> edgeList;
    private double distance = Integer.MAX_VALUE;  // distance from the starting vertex (source)
    private Vertex previous;  // the previous vertex on the shortest path

    public Vertex(int id, String name, double latitude, double longitude) {
          this.name = name;
          this.latitude = latitude;
          this.longitude = longitude;
      edgeList = new ArrayList<>();
          this.id = id;
        
    }
  public int getId()
  {
    return id;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  public void setLatitude(double latitude)
  {
    this.latitude = latitude;
  }
  public double getLatitude()
  {
    return latitude;
  }

  public void setLongitude(double longitude)
  {
    this.longitude = longitude;
  }
  public double getLongitude()
  {
    return longitude;
  }

  public void setName(String name)
    {
    this.name = name;
    }

    public String getName()
    {
    return name;
    }

  /*  public void setVisited(boolean visited)
    {
    this.visited = visited;
    }
  

    public boolean getVisited()
    {
    return visited;
    }
  */
    public void setList(List<Edge> list)
    {
    edgeList = list;
    }
    public List<Edge> getList()
    {
    return edgeList;
    }

    public void addEdge(Edge edge)
    {
    edgeList.add(edge);
    }

    public Vertex getPrevious()
    {
    return previous;
    }

    public void setPrevious(Vertex previous)
    {
    this.previous = previous;
    }

    public void setDistance(double distance)
    {
    this.distance = distance;
    }

    public double getDistance()
    {
    return distance;
    }

    
    
    

    @Override // Do not change the equals or toString methods.
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (this.id != other.id || !
            this.name.equals(other.name) || 
            this.edgeList.size() != other.edgeList.size()) {
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++) {
            if(!this.edgeList.get(i).equals(other.edgeList.get(i))) {
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
     if(this.distance > other.getDistance()){
       return 1;
     }
    else if(other.getDistance() > this.distance)
    {
      return -1;
    }
    return 0;
  }
}
