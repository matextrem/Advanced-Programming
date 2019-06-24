import java.util.Iterator;
import java.util.LinkedList;

public class BfsAndDfs {
	public static void main(String[] args) {
		GraphDfsAndBfs g = new GraphDfsAndBfs(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
        
        System.out.println("Following is Depth First Traversal "+ 
                "(starting from vertex 2)"); 

        g.DFS(2); 
	}
}

class GraphDfsAndBfs {
	private int V;
	private LinkedList<Integer> adj[];
	
	public GraphDfsAndBfs(int v) {
		this.V = v;
		for(int i=0; i<v;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public void BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[s] = true;
		queue.add(s);
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}
	
	public void DFS(int v) {
		boolean visited[] = new boolean[V];
		DfsUtil(v,visited);
		
	}
	
	public void DfsUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(v+ " ");
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n  = i.next();
			if(!visited[n])
				DfsUtil(n,visited);
		}
	}
}