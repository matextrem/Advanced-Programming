import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

public class PaisesLimitrofes {
	private int nodes;
	private TreeMap<String,Integer> countries = new TreeMap<String, Integer>();

	private Graph countryGraph;
	
	public void armarGrafo() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("countries.txt"));
		int i = 0;
		sc.useLocale(Locale.ENGLISH);
		nodes = sc.nextInt();
		countryGraph = new Graph(nodes);
		while (sc.hasNext()){
		   String country_1 = sc.next();
		   String country_2 = sc.next();
		   if(!countries.containsKey(country_1)) 
			   countries.put(country_1,i++);
		   if(!countries.containsKey(country_2))
			   countries.put(country_2,i++);
		   
		   addEdge(countryGraph, countries.get(country_1), countries.get(country_2));

		}
		sc.close();
	}
	
	public void escribirPaises() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter("countriesOut.txt"));
			paisesLimitrofes(salida);
			paisesTranslimitrofes(salida);
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paisesLimitrofes(PrintWriter salida) {
		for (Map.Entry<String, Integer> entry : countries.entrySet()) {
			salida.println(entry.getKey() + " " + this.countryGraph.adjListArray[entry.getValue()].size());
		}
	}
	
	public void paisesTranslimitrofes(PrintWriter salida) {
		boolean countryFlag = false;
        Vector<Integer> translimitVisited = new Vector<Integer>();
		for (Map.Entry<String, Integer> entry : countries.entrySet()) {
			translimitVisited.add(entry.getValue());
			Vector<Integer> paisesT = sonLimitrofes(entry.getValue());
			for(int j = 0; j< translimitVisited.size(); j++) {
				if(paisesT.contains(translimitVisited.elementAt(j)))
					paisesT.remove(translimitVisited.elementAt(j));
			}	
			for(int i=0; i<paisesT.size(); i++){
				countryFlag = true;
				salida.println(entry.getKey() + " " + getKeyFromValue(countries,paisesT.elementAt(i)));
	        }
		}
		if(!countryFlag)
			salida.println("No hay países translimítrofes");
	}
	
	public Vector<Integer> sonLimitrofes(int origin){
		Vector<Boolean> visited = new Vector<Boolean>(nodes);
        Vector<Integer> layerTwo = new Vector<Integer>();
        for (int i = 0; i < nodes; i++) { 
            visited.addElement(false); 
        }
        
        // queue to do BFS. 
        Queue<Integer> Q = new LinkedList<>(); 
        visited.set(origin, true);
        
        
        for(int neighbour : countryGraph.adjListArray[origin]) {
        	   Q.add(neighbour);
        	   visited.set(neighbour, true);
        }
        
        while(!Q.isEmpty()) {
        	int node = Q.peek();
        	Q.poll();
        	for(int neighbour : countryGraph.adjListArray[node]) {
        		if(!visited.elementAt(neighbour)) {
        			visited.set(neighbour, true);
        			layerTwo.add(neighbour);
        		}		
        	}
        }
        
        return layerTwo;
	} 
	
	
	// hm is the map you are trying to get value from it
	
    @SuppressWarnings("rawtypes")
	public static Object getKeyFromValue(TreeMap hm, Object value) {
      for (Object o : hm.keySet()) {
        if (hm.get(o).equals(value)) {
          return o;
        }
      }
      return null;
    }
	// Adds an edge to an undirected graph 
	static void addEdge(Graph graph, int src, int dest) { 
		    // Add an edge from src to dest.  
		    graph.adjListArray[src].add(dest); 
		      
		    // Since graph is undirected, add an edge from dest 
		    // to src also 
		    graph.adjListArray[dest].add(src); 
		} 

	// A utility function to print the adjacency list  
	// representation of graph 
	static void printGraph(Graph graph) {        
	    for(int v = 0; v < graph.V; v++) 
	    { 
	        System.out.println("Adjacency list of vertex "+ v); 
	        System.out.print("head"); 
	        for(Integer pCrawl: graph.adjListArray[v]){ 
	            System.out.print(" -> "+pCrawl); 
	        } 
	        System.out.println("\n"); 
	    } 
	}

}



//A user define class to represent a graph. 
//A graph is an array of adjacency lists. 
//Size of array will be V (number of vertices  
//in graph) 
class Graph { 
 int V; 
 LinkedList<Integer> adjListArray[]; 
   
 // constructor  
 @SuppressWarnings("unchecked")
	public Graph(int V) { 
     this.V = V; 
       
     // define the size of array as  
     // number of vertices 
     adjListArray = new LinkedList[V]; 
       
     // Create a new list for each vertex 
     // such that adjacent nodes can be stored 
     for(int i = 0; i < V ; i++){ 
         adjListArray[i] = new LinkedList<>(); 
     } 
 } 
}
