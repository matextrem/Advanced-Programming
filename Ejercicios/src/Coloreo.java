import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Coloreo {
	private Graph graph;
	private String path;
	private Map<Integer, Integer> vertexColor = new HashMap<Integer, Integer>();
	private int cantColores = 0;
	private int colorMax = 1;
	private int[] nodosColoreados; // el indice coincide con el numero de nodo,
	private int mejorColor = 0;
	private int[] solucion;
	private int[] mejoresColores;


	public Coloreo(String path) {
		this.path = path;
		this.leerArchivo();
	}
	class Graph {
		private int V;
		private ArrayList<Integer> adj[];
		private List<Vertex> vertices;

		@SuppressWarnings("unchecked")
		public Graph(int v) {
			this.V = v;
			this.vertices =  new ArrayList<Vertex>();
			this.adj = new ArrayList[v];
			for(int i=0; i<v;i++){
				adj[i] = new ArrayList<Integer>();
			}
		}
		
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}
	}
	
	/*
	 * Implementation of the Welsh-Powell Algorithm
	 */
	
	public void resolver(int corridas) {
		int nroCorrida = 0;
		for (int i = 0; i < corridas; i++) {
			Collections.shuffle(this.graph.vertices);
			this.colorear();

			if (this.colorMax < this.mejorColor || this.mejorColor == 0) {
				this.mejorColor = this.colorMax;
				nroCorrida = i + 1;
				this.solucion = this.nodosColoreados.clone(); // copio la mejor solucion hasta el momento.													
			}

			this.mejoresColores[this.colorMax]++;
		}
		
		System.out.print("WELSH-POWELL: ");
		System.out.println("Menor cantidad de colores: " + this.mejorColor + ", en numero de iteracion: " + nroCorrida);

		this.mejorColor = 0;
		for (int i = 0; i < this.graph.V; i++) // me aseguro de limpiar el vector estadistico.
			this.mejoresColores[i] = 0;
	}
	
	private void colorear() {
		int color = 1;
		int nodo;
		int j;

		this.colorMax = 1;
		for (int i = 0; i < this.graph.V; i++)
			this.nodosColoreados[i] = 0;

		nodosColoreados[this.graph.vertices.get(0).node] = color; // coloreo el primer nodo de la lista
		for (int i = 1; i < this.graph.V; i++) {
			nodo = this.graph.vertices.get(i).node;
			this.nodosColoreados[nodo] = color;
			j = 0;
			while (j < this.graph.V) {
				if (nodo != j) {
					if((this.graph.vertices.get(j).neighbors.contains(nodo) || this.graph.vertices.get(nodo).neighbors.contains(j)) && this.nodosColoreados[nodo] == this.nodosColoreados[j]) {
						color++;
						if (color > colorMax)
							colorMax = color;
						this.nodosColoreados[nodo] = color;
						j = -1;	
					}
					
				}
				j++;
			}
			color = 1;
		}
	}
	
	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new FileReader(new File(this.path + ".in")));
			sc.useLocale(Locale.ENGLISH);
			int vertices = sc.nextInt();
			int aristas = sc.nextInt();
			this.graph = new Graph(vertices);
			this.nodosColoreados = new int[vertices];
			this.solucion = new int[5];
			this.mejoresColores = new int[vertices + 1];
			for(int i=0;i<aristas;i++) {
				int origen = sc.nextInt(); 
				int destino = sc.nextInt();
				graph.addEdge(origen, destino);
			}
			sc.close();
			int i = 0;
			for(ArrayList<Integer> neighbors : this.graph.adj ) 
				this.graph.vertices.add(new Vertex(i++, neighbors));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirArchivo() {
		
	}
	
	private static class Vertex{
		private Integer node;
		private List<Integer> neighbors = new ArrayList<Integer>();
		
		public Vertex(Integer node, ArrayList<Integer> neighbors){
			this.node = node;
			this.neighbors = neighbors;
		}
		
	}
	
	class VertexComparator implements Comparator<Vertex>{

		@Override
		public int compare(Vertex a, Vertex b) {
			return a.neighbors.size() < b.neighbors.size() ? 1 : a.neighbors.size() == b.neighbors.size() ? 0 : -1;
		}
	}
}
