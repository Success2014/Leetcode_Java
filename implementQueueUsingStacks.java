package first;

import java.util.Stack;

public class implementQueueUsingStacks {
	Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if (s2.isEmpty()){
        	int size = s1.size();
            for (int i = 0; i < size; i++){
                int temp = s1.pop();
                s2.push(temp);
            }
        }
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public static void main(String[] args){
    	implementQueueUsingStacks iq = new implementQueueUsingStacks();
    	iq.push(1);iq.push(2);
    	System.out.println(iq.peek());
    }

}
