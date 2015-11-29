package first;
import java.util.*;
public class evaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = tokens.length;
        if (n == 0) {
            return 0;
        }
        String operators = "+-*/";
        for (int i = 0; i < n; i++) {
            String curt = tokens[i];
            if (!operators.contains(curt)) {
                stack.push(Integer.valueOf(curt));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (curt.equals("+")) {
                    stack.push(a + b);
                } else if (curt.equals("-")) {
                    stack.push(a - b);
                } else if (curt.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
	public static void main(String[] args) {
		evaluateReversePolishNotation erp = new evaluateReversePolishNotation();
		String[] tokens1 = {"4", "13", "5", "/", "+"};
		String[] tokens2 = {"4","-2","/","2","-3","-","-"};
		System.out.println(erp.evalRPN(tokens1));
		System.out.println(erp.evalRPN(tokens2));
	}

}
