package easy;

import java.util.Arrays;
import java.util.Stack;

public class EvaluatePolishNotation {
	public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                int value = doOperation(value1, value2, tokens[i]);
                stack.push(value);
            }
        }
        return stack.pop();
    }
    
    public boolean isOperator(String s) {
        return Arrays.asList(new String[]{"+", "-", "*", "/"}).contains(s);
    }
    
    public int doOperation(int value1, int value2, String operation) {
        if (operation.equals("+")) {
            return value1 + value2;
        }
        if (operation.equals("-")) {
            return value1 - value2;
        }
        if (operation.equals("*")) {
            return value1 * value2;
        }
        if (operation.equals("/")) {
            return value1 / value2;
        }
        throw new RuntimeException("Operation not found");
    }
    
    public static void main(String[] args) {
		EvaluatePolishNotation notation = new EvaluatePolishNotation();
		String[] tokens = new String[]{"2", "1", "+", "3", "*"};
		System.out.println("Function correct " + (9 == notation.evalRPN(tokens)));
	}
}
