package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Clone a graph. Input is a Node pointer. Return the Node pointer of the cloned graph 
	A graph is defined below:
	struct Node {
	vector neighbors;
	}
 */
public class CloneGraph {

	private static class Node {
		public String name;
		public List<Node> neighbors;
		
		public Node(String name) {
			this.name = name;
			this.neighbors = new ArrayList<Node>();
		}
		
		public void print(Set<Node> visitedSet) {
			System.out.print(name + "->");
			visitedSet.add(this);
			for (Node neighbor : this.neighbors) {
				System.out.print(neighbor.name + ",");
			}
			System.out.println();
			for (Node neighbor : this.neighbors) {
				if (visitedSet.contains(neighbor)) {
					continue;
				} else {
					neighbor.print(visitedSet);
				}
			}
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	public static Node cloneGraph(Node graph) {
		if (graph == null) return null;
		Map<Node, Node> oldToNewMap = new HashMap<Node, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		
		Node clonedGraph = new Node(graph.name);
		oldToNewMap.put(graph, clonedGraph);
		queue.add(graph);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			Node clonedNode = oldToNewMap.get(node);
			for (Node neighbor : node.neighbors) {
				Node clonedNeighbor = oldToNewMap.get(neighbor);
				//Clone the neighbor if it doesn't exist. Also add it to the map and queue
				if (clonedNeighbor == null) {
					clonedNeighbor = new Node(neighbor.name);
					oldToNewMap.put(neighbor, clonedNeighbor);
					queue.add(neighbor);
				}
				//Add the cloned neighbor
				clonedNode.neighbors.add(clonedNeighbor);
			}
		}
		return clonedGraph;
	}
	
	public static Node cloneGraphDepthFirst(Node node, Map<Node, Node> oldToNewMap) {
		if (node == null) return null;
		Node clonedNode = oldToNewMap.get(node);
		if (clonedNode == null) {
			clonedNode = new Node(node.name);
			oldToNewMap.put(node, clonedNode);
		} else {
			return clonedNode;
		}
		for (Node neighbor : node.neighbors) {
			clonedNode.neighbors.add(cloneGraphDepthFirst(neighbor, oldToNewMap));
		}
		return clonedNode;
	}
	
	public static void main(String[] args) {
		Node node = new Node("a");
		Node node2 = new Node("b");
		Node node3 = new Node("c");
		
		node.neighbors.add(node2);
		node.neighbors.add(node3);
		
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		
		System.out.println("------");
		System.out.println("Before clone");
		node.print(new HashSet<CloneGraph.Node>());
		System.out.println("------");
		
		Node clonedNode = cloneGraph(node);
		System.out.println("------");
		System.out.println("After clone BFS");
		clonedNode.print(new HashSet<CloneGraph.Node>());
		System.out.println("------");
		
		
		Node clonedNodeDFS = cloneGraphDepthFirst(node, new HashMap<CloneGraph.Node, CloneGraph.Node>());
		System.out.println("------");
		System.out.println("After clone DFS");
		clonedNodeDFS.print(new HashSet<CloneGraph.Node>());
		System.out.println("------");
	}
}
