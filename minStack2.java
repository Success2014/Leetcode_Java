package first;
import java.util.Stack;

public class minStack2 {
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || (x <= minStack.peek())){
            minStack.push(x);
        }
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
