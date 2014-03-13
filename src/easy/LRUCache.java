package easy;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LRUCache {

	private static class Node implements Comparable<Node>{
        public int key;
        public int currentCounter;
        public int value;
        
        public Node(int key, int currentCounter, int value) {
            this.key = key;
            this.currentCounter = currentCounter;
            this.value = value;
        }
        
        public boolean equals(Object obj) {
            if (this == obj) {
              return true;
            } else if (obj instanceof Node) {
              Node other = (Node) obj;
              return other.key == this.key;
            } else {
              return false;
            }
        }
        
        @Override
        public int compareTo(Node other){
        	if (this.key == other.key) return 0;
            return this.currentCounter - other.currentCounter;
        }
        
        @Override
        public String toString() {
        	return "Key " + key + " counter " + currentCounter;
        }
    }
    
	private HashMap<Integer, Node> nodesMap;
	private TreeSet<Node> nodes;
    
    private int capacity;
    private int currentCounter;
    
    public LRUCache(int capacity) {
        this.nodesMap = new HashMap<Integer, Node>();
        this.nodes = new TreeSet<Node>();
        this.capacity = capacity;
        this.currentCounter = 0;
    }
    
    public int get(int key) {
    	if (nodesMap.containsKey(key)) {
    		Node node = nodesMap.get(key);
    		nodes.remove(node);
    		node.currentCounter = ++currentCounter;
    		nodes.add(node);
    		return node.value;
    	} else {
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if (nodesMap.containsKey(key)) {
    		Node node = nodesMap.get(key);
    		nodes.remove(node);
    		node.value = value;
    		node.currentCounter = ++currentCounter;
    		nodes.add(node);
    	} else {
    		if (nodesMap.size() == capacity) {
    			Node leastUsedNode = nodes.pollFirst();
    			int leastNodeKey = leastUsedNode.key;
    			nodesMap.remove(leastNodeKey);
    		}
			Node newNode = new Node(key, ++currentCounter, value);
			nodes.add(newNode);
			nodesMap.put(key, newNode);
    	}
    }
    
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		
		
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		
		cache.set(5, 5);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
		
	}
}
