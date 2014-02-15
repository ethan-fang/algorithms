package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Kruskal extends Graph {
	
	
	public Kruskal(boolean directed) {
		super(directed);
		// TODO Auto-generated constructor stub
	}

	public void kruskal() {
		
		SetUnion s = new SetUnion();
		
		List<EdgePair> edgePairs = new ArrayList<EdgePair>();
		for (int i = 1; i < max; i++) {
			EdgeNode node = edges[i];
			node = node.next;
			while (node != null) {
				edgePairs.add(new EdgePair(i, node.index, node.weight));
				node = node.next;
			}
		}
		
		Collections.sort(edgePairs, new Comparator<EdgePair>() {

			@Override
			public int compare(EdgePair o1, EdgePair o2) {
				return o1.weight - o2.weight;
			}
		});
		
		for (int i = 0; i < edgePairs.size(); i++) {
			System.out.println(s);
			System.out.println(edgePairs.get(i));
			System.out.println("-----");
			
			
			int start = edgePairs.get(i).startIndex;
			int end = edgePairs.get(i).endIndex;
			if (!s.isSameComponent(start, end)) {
				s.unionSets(start, end);
			}
		}
		
		System.out.println(s);
	}
	
	public class EdgePair {
		int startIndex;
		int endIndex;
		int weight;
		
		public EdgePair(int start, int end, int weight) {
			// TODO Auto-generated constructor stub
			this.startIndex = start;
			this.endIndex = end;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return startIndex + "-" + endIndex + "(" + weight + ")";
		}
	}
	
	public class SetUnion {
		int[] parent;
		int[] size;
		int n;
		
		public SetUnion() {
			parent = new int[max];
			size = new int[max];
			
			for (int i = 1; i < size.length; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		
		public int find(int x) {
			if (parent[x] == x) {
				return x;
			} else {
				return find(parent[x]);
			}
		}
		
		public boolean isSameComponent(int start, int end) {
			return find(start) == find(end);
		}
		
		public void unionSets(int start, int end) {
			int r1 = find(start);
			int r2 = find(end);
			if (r1 == r2) return;
			
			System.out.println(start + " size: " + size[r1] + ", " + end + " size: " + size[r2]);
			
			if (size[r1] >= size[r2]) {
				size[r1] = size[r1] + size[r2];
				parent[r2] = start;
			} else {
				size[r2] = size[r2] + size[r1];
				parent[r1] = end;
			}
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < parent.length; i++) {
				sb.append(i + "-" + parent[i] + ",");
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Prim prim = new Prim(false);
		System.out.println("----------");
		System.out.println("The following is prim sorting");
		prim.prim(1);
		System.out.println();
		
		System.out.println("----------");
		
		Kruskal k = new Kruskal(false);
		k.printGraph();
		k.kruskal();
		
	}

}
