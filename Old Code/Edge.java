/*
* Instructions:
* 1. Complete the constructor 
* 2. Create getter methods for all instance variables.
*/
public class Edge {

    private String name;
    private double weight;
    private Vertex sourceVertex;
    private Vertex targetVertex;
    //private Vertex startVertex;
    public Edge(Vertex startVertex, Vertex targetVertex, String name, double weight) {
      this.name = name;
      this.weight = weight;
      this.targetVertex = targetVertex;
      this.sourceVertex = startVertex;
    }

      public void setName(String name)
      {
        this.name = name;
      }
      public String getName() {
          return name;
      }

     public double getWeight() {
          return this.weight;
      }

    public void setWeight(int weight)
    {
      this.weight = weight;
    }

    public void setSource(Vertex source)
  {
    sourceVertex = source;
  }
  public Vertex getSource()
  {
    return sourceVertex;
  }
  public Vertex getVertex()
  {
    return sourceVertex;
  }

  public Vertex getTarget()
  {
    return targetVertex;
  }

  public void setTarget(Vertex target)
  {
    targetVertex = target;
  }
  



    @Override // Do not change the equals or toString methods.
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Edge other = (Edge) obj;
        return this.name.equals(other.name) && this.weight == other.weight &&
            this.sourceVertex.getName().equals(other.sourceVertex.getName()) && 
            this.targetVertex.getName().equals(other.targetVertex.getName());
    }
    
    @Override // Do not change the equals or toString methods.
    public String toString() {
        return String.format("%s -> %s: %s, %f",
            this.sourceVertex.getId(), this.targetVertex.getId(), this.name, this.weight);
    }
}
