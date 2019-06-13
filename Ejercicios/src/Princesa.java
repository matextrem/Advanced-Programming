import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Princesa {
	private String path;
	private Dijkstra graph;
	private int initialPrince;
	private int finalPrincess;
	private List<Integer> dragonPositions = new ArrayList<Integer>();

	public Princesa(String path) {
		this.path = path;
		this.leerArchivo();
	}
	
	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new FileReader(new File(this.path + ".in")));
			sc.useLocale(Locale.ENGLISH);
			int vertices = sc.nextInt();
			int aristas = sc.nextInt();
			int dragones = sc.nextInt();
			finalPrincess = sc.nextInt();
			initialPrince = sc.nextInt();
			this.graph = new Dijkstra(vertices);
			for(int i = 0;i<dragones;i++) 
				dragonPositions.add(sc.nextInt());
			for(int i=0;i<aristas;i++) {
				int origen = sc.nextInt(); 
				int destino = sc.nextInt();
				int peso = sc.nextInt();
				graph.addEdge(origen, destino, peso, false);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(this.path + ".out"));
			for(Integer node : this.graph.getShortestPath()) {
				salida.print(node);
				salida.print(" ");
			}
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resolverCamino() {
		this.graph.dijkstra(initialPrince,dragonPositions);
		this.graph.calculateShortestPath(finalPrincess);
	}

}
