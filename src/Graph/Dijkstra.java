package Graph;

public class Dijkstra extends Graph{

	public Dijkstra(boolean directed) {
		super(directed);
		// TODO Auto-generated constructor stub
	}

	static int MAX = 10000;
	
	
	public void dijkstra(int start) {
		boolean[] intree = new boolean[max];
		int[] distance = new int[max];
		int[] parent = new int[max];
		
		for (int i = 1; i < max; i++) {
			distance[i] = MAX;
			parent[i] = -1;
		}
		
		distance[start] = 0;
		int v = start;
		EdgeNode p;
		int neighbor;
		
		while (intree[v] == false) {
			intree[v] = true;
			p = edges[v];
			
			while (p != null) {
				neighbor = p.index;
				if (distance[neighbor] > (distance[v] + p.weight)) {
					distance[neighbor] = distance[v] + p.weight;
					parent[neighbor] = v;
				}
				p = p.next;
			}
			
			int dist = MAX;
			for (int i=1; i<max; i++)
			      if ((!intree[i]) && (dist > distance[i])) {
			               dist = distance[i];
			               v = i; 
			      }
		}
		
		for (int i = 1; i < max; i++) {
			System.out.println("to " + i + ":" + distance[i]);
		}
	}
	
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra(false);
		d.dijkstra(1);
		
		
	}
}
