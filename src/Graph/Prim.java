package Graph;

public class Prim extends Graph{
	
	int MAX_DISTANCE = 10000;

	public Prim(boolean directed) {
		super(directed);
		// TODO Auto-generated constructor stub
	}

	public void prim(int start) {
		
		boolean[] intree = new boolean[max];
		int[] distance = new int[max];
		int[] parent = new int[max];
		
		for (int i = 0; i < distance.length; i++) {
			distance[i] = MAX_DISTANCE;
		}
		
		distance[start] = 0;
		int v = start;
		EdgeNode p;
		int neighborIndex;
		int maxDistance;
		
		while (intree[v] == false) {
			intree[v] = true;
			
			System.out.print(parent[v] + "-" + v + "(" + distance[v] + "),");
			
			p = edges[v];
			while (p != null) {
				neighborIndex = p.index;
				if (p.weight < distance[neighborIndex]) {
					distance[neighborIndex] = p.weight;
					parent[neighborIndex] = v;
				}
				p = p.next;
			}
			
			maxDistance = MAX_DISTANCE;
			for (int i = 0; i < max; i++) {
				if (!intree[i] && distance[i] < maxDistance) {
					maxDistance = distance[i];
					v = i;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Prim prim = new Prim(false);
		prim.printGraph();
		System.out.println("---");
		prim.prim(1);
	}
}
