import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
		graph.bfs(1);
	}
	
	public void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[max];
		boolean[] processed = new boolean[max];
		
		System.out.println();
		System.out.println("----");
		queue.add(start);
		System.out.print(edges[start].index + ",");
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int index = queue.poll();
			if (processed[index]) {
				continue;
			}
			EdgeNode node = edges[index];
			node = node.next;
			while (node != null) {
				if (!visited[node.index]) {
					System.out.print(node.index + ",");
					queue.add(node.index);
					visited[node.index] = true;
				}
				node = node.next;
			}
			processed[index] = true;
		}
	}
}
