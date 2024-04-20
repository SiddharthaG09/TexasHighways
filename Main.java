import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String verticesFile = "TX-dfw50.vertices.txt";
        String edgesFile = "TX-dfw50.edges.txt";
        Map<Integer, Vertex> graph = getGraph(readFile(verticesFile), readFile(edgesFile));

        Vertex start = graph.get(740); //Coppell (TX121@DenTapRd)
        Vertex end = graph.get(1328);  //Midlothian (US67/US287)

        DijkstrasAlgorithm.computePath(start, end);
        List<Vertex> path = DijkstrasAlgorithm.getPath(end);

        System.out.printf("\nPath from %s to %s = %s\n", start, end, path);
        System.out.printf("\nDistance from %s to %s = %.3f miles\n", start, end, end.getDistance());
        System.out.printf("Path size = %d\n", path.size());
        System.out.printf("Poll count = %,d\n", DijkstrasAlgorithm.pollCount);
    }

    /*
    * Refer to the the assignment instructions for completing the getGraph method
    */
    public static Map<Integer, Vertex> getGraph(List<String> verticesList, List<String> edgesList) {
        Map<Integer, Vertex> map = new HashMap<>();
      int id = 0;
      for(String vertex : verticesList)
        {
          String[] split = vertex.split(" ");
          String name = split[0];
          double latitude = Double.parseDouble(split[1]);
          double longitude = Double.parseDouble(split[2]);
          Vertex v = new Vertex(id, name, latitude, longitude);
          map.put(id, v); 
          id++;
        }
      for(String edge : edgesList)
        {
          
          String[] split = edge.split(" "); 
          String name = split[2];
          Vertex source = map.get(Integer.parseInt(split[0]));
          Vertex target = map.get(Integer.parseInt(split[1]));
  

        double weight = 0;
        double lat1 = source.getLatitude();
        double lon1 = source.getLongitude();
          double lat2;
          double lon2;
          for(int i = 3; i<split.length; i+=2)
            {
              lat2 = Double.parseDouble(split[i]);
              lon2 = Double.parseDouble(split[i+1]);
              weight += calculateDistance(lat1, lon1, lat2, lon2);
              lat1 = lat2;
              lon1 = lon2;
            }
          lat2 = target.getLatitude();
          lon2 = target.getLongitude();
          weight += calculateDistance(lat1, lon1, lat2, lon2);
          source.addEdge(new Edge(source, target, name, weight));
           target.addEdge(new Edge(target, source, name, weight));
        }  
      
        return map;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 0.621371192; // convert to miles

        return distance;
    }


    public static void resetGraph(Map<Integer, Vertex> graph) {
        DijkstrasAlgorithm.pollCount = 0;
        for (Vertex v : graph.values()) {
            v.setPrevious(null);
            v.setDistance(Integer.MAX_VALUE);
        }
    }

    public static List<String> readFile(String filename) {
        List<String> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                list.add(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Find not found");
        }
        return list;
    }
}
