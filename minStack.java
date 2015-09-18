package first;
import java.util.Stack;

public class minStack {
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()){
            minstack.push(x);
        }
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == minstack.peek()){
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }

}
