package first;
import java.util.Stack;
public class implementQueueUsingStacks2 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack2.isEmpty() && !stack1.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

}
