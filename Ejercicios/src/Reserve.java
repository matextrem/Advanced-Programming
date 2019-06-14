import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Reserve {
	private String path;
	private GraphReserve reserve;
	private int nodoInicial;
	private int nodoFinal;
	private int totalPaths;
	public Reserve(String path) {
		this.path = path;
		this.leerArchivo();
	}
	
	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new File(this.path + ".in"));
			int vertices = sc.nextInt();
			this.nodoInicial = 1;
			this.nodoFinal = vertices;
			int aristas = sc.nextInt();
			this.reserve = new GraphReserve(vertices);
			for(int i = 0; i<aristas;i++) {
				int inicio = sc.nextInt();
				int destino = sc.nextInt();
				this.reserve.addEdge(inicio, destino);
			}
			sc.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resolverCamino() {
		this.totalPaths = this.reserve.countPaths(nodoInicial, nodoFinal);
	}
	
	public void escribirArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(this.path + ".out"));
			salida.println(this.totalPaths);
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class GraphReserve {
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public GraphReserve(int v) {
		this.V = v;
		adj = new LinkedList[v+1];
		for(int i=1; i<=v; i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	public int countPathsUtil(int u, int d, boolean visited[], int pathCount) {
		visited[u] = true;
		if(u == d)
			pathCount++;
		else {
			Iterator<Integer> i = adj[u].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) 
					pathCount = countPathsUtil(n, d, visited, pathCount);
			}
		}
		visited[u] = false;
		return pathCount;
	}
	
	public int countPaths(int s, int d) {
		boolean visited[] = new boolean[V+1];
		Arrays.fill(visited, false);
		int pathCount = 0;
		pathCount = countPathsUtil(s, d, visited, pathCount);
		return pathCount;
	}
}
