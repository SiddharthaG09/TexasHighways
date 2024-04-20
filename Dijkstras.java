import java.util.*;

public class DijkstrasAlgorithm {

    // increment pollCount when you poll a Vertex from your priority queue.
    public static int pollCount = 0;

    public static void computePath(Vertex start, Vertex end) {
      start.setDistance(0);

      PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
      vertexQueue.add(start);
      while (!vertexQueue.isEmpty())
        {
          Vertex current = vertexQueue.poll();
            pollCount++;
          for (Edge edge : current.getList())
            {
              Vertex neighbor = edge.getTarget();
              if (neighbor.getDistance() > current.getDistance() + edge.getWeight())
              {
                neighbor.setDistance(current.getDistance() + edge.getWeight());
                neighbor.setPrevious(current);
                vertexQueue.add(neighbor);
              }

           }
          //System.out.println(vertexQueue);
        }

        
    }


    
    public static List<Vertex> getPath(Vertex end) {
      List<Vertex> path = new ArrayList<>();
        Vertex current = end;
        while (current != null)
          {
            path.add(current);
            current = current.getPrevious();
          }
        Collections.reverse(path);
        return path;
    }
}
