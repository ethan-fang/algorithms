package Graph;

public class Graph {
	class EdgeNode {
		int index;
		int weight;
		EdgeNode next;
		
		int degree;
		
	}
	
	EdgeNode[] edges;
	int max = 8;
	int nedges;
	int nvertices;
	boolean directed;
	
	public Graph(boolean directed) {
		edges = new EdgeNode[max];
		nedges = 0;
		this.directed = directed;
		
		insertEdge(1, 2, 5, false);
		insertEdge(2, 3, 7, false);
		insertEdge(3, 4, 5, false);
		insertEdge(4, 5, 2, false);
		insertEdge(5, 6, 7, false);
		insertEdge(6, 7, 4, false);
		insertEdge(7, 1, 7, false);
		insertEdge(7, 2, 9, false);
		insertEdge(7, 3, 4, false);
		insertEdge(5, 3, 2, false);
		insertEdge(5, 7, 3, false);
		insertEdge(1, 6, 12, false);
	}
	
	public void insertEdge(int xIndex, int yIndex, int weight, boolean directed) {
		if (edges[xIndex] == null) {
			EdgeNode node = new EdgeNode();
			node.index = xIndex;
			edges[xIndex] = node;
		}
		EdgeNode node = (EdgeNode)edges[xIndex];
		node.degree++;
		while (node.next != null) {
			node = node.next;
		}
		EdgeNode nextNode = new EdgeNode();
		nextNode.index = yIndex;
		nextNode.weight = weight;
		node.next = nextNode;
		
		if (directed) {
			nedges++;
		} else {
			insertEdge(yIndex, xIndex, weight, true);
		}
	}
	
	public void printGraph() {
		for (int i = 0; i < max; i++) {
			System.out.println();
			EdgeNode node = edges[i];
			if (node == null) {
				continue;
			}
			System.out.print(node.index + ":");
			while (node.next != null) {
				node = node.next;
				System.out.print(node.index + "(" + node.weight + ")" + ",");
			}
		}
	}
}
