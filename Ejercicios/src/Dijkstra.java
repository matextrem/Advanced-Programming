import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;



public class Dijkstra {
	private final int MAX = 10005;
	private final int INF =Integer.MIN_VALUE;
	
	private ArrayList<List<Node>> ady =  new ArrayList<List <Node>>();
	private int distancia[] = new int[MAX];
	private boolean visitado[] = new boolean[MAX];
	private PriorityQueue<Node> Q = new PriorityQueue<Node>();
	private int V;
	private int previo[] = new int[MAX];
	
	public Dijkstra(int V) {
		this.setVertices(V);
		Arrays.fill(distancia, INF);
		Arrays.fill(visitado, false);
		Arrays.fill(previo, -1);
		for(int i = 0; i<V; i++)
			ady.add(new ArrayList<Node>());
	}
	
	void dijkstra(int inicial) {
		Q.add(new Node(inicial, 0));
		distancia[inicial] = 0;
		int actual, adyacente,peso;
		while(!Q.isEmpty()) {
			actual = Q.element().first;
			Q.remove();
			if(visitado[actual]) continue;
			visitado[actual] = true;
			for(int i=0; i<ady.get(i).size(); i++) {
				adyacente = ady.get(actual).get(i).first;
				peso = ady.get(actual).get(i).weigth;
				if(!visitado[adyacente])
					relajacion(actual,adyacente,peso);
			}
			
		}
		
	}
	
	private void relajacion(int actual, int adyacente,int peso) {
		if(distancia[actual] + peso < distancia[adyacente]) {
			distancia[adyacente] = distancia[actual] + peso;
			previo[adyacente] = actual;
			Q.add(new Node(adyacente,distancia[adyacente]));
		}
	}
	
	void addEdge(int origen, int destino, int peso, boolean dirigido) {
		ady.get(origen).add(new Node(destino,peso));
		if(!dirigido)
			ady.get(destino).add(new Node(origen,peso));
	}
	
	void printShortestPath(){
        
        // print( destino );
    }
	
	//Impresion del camino mas corto desde el vertice inicial y final ingresados
    void print( int destino ){
        if( previo[ destino ] != -1 )    //si aun poseo un vertice previo
            print( previo[ destino ] );  //recursivamente sigo explorando
        System.out.printf("%d " , destino );        //terminada la recursion imprimo los vertices recorridos
    }

	/**
	 * @return the v
	 */
	public int getVertices() {
		return V;
	}

	/**
	 * @param v the v to set
	 */
	public void setVertices(int v) {
		V = v;
	}
	
}

class Node implements Comparable<Node> {
	int first, weigth;
	public Node(int f,int w) {
		this.first = f;
		this.weigth = w;
	}
	
	@Override
	public int compareTo(Node other) {
		if(weigth > other.weigth) return 1;
		if(weigth == other.weigth) return 0;
		return -1;
	}
}
