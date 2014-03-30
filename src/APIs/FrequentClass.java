package APIs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class FrequentClass {
	
	public void map() {
		Map<String, String> map = new HashMap<String, String>();
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
		}
		
		map.put("Key", "Value");
	}
	
	public void queue() {
		Queue<String> queue = new LinkedList<String>();
		queue.add("Test");
		queue.peek();
		queue.poll();
	}
	
	public void set() {
		Set<String> set = new HashSet<String>();
		set.add("test");
		set.remove("test");
	}
	
	public void stack() {
		Stack<String> stack = new Stack<String>();
		stack.push("Test");
		stack.peek();
		stack.pop();
	}
	
	//Chris Whoo
	
	//How many people work in this office/department/project?
	//What do you like about working here?
	//How would you describe the company’s culture and leadership philosophy?
	//What specific qualities and skills are you looking for in the job candidate?
	
}
