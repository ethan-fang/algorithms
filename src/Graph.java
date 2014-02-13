import java.util.ArrayList;
import java.util.List;


public class Graph {

	class EdgeNode {
		int index;
		int weight;
		EdgeNode next;
		
		int degree;
		
	}
	
	EdgeNode[] edges;
	
	int max = 6;
	int nedges;
	boolean directed;
	
	public Graph(boolean directed) {
		edges = new EdgeNode[max];
		nedges = 0;
		this.directed = directed;
		
		insertEdge(1, 2, false);
		insertEdge(1, 5, false);
		insertEdge(2, 5, false);
		insertEdge(5, 4, false);
		insertEdge(4, 2, false);
		insertEdge(2, 3, false);
		insertEdge(4, 3, false);
	}
	
	public void insertEdge(int xIndex, int yIndex, boolean directed) {
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
		node.next = nextNode;
		
		if (directed) {
			nedges++;
		} else {
			insertEdge(yIndex, xIndex, true);
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
				System.out.print(node.index + ",");
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(false);
		graph.printGraph();
	}
}
