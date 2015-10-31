package first;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Method 1, O(n) for push, O(1) for pop, top and empty.
 * @author Neo
 *
 */
public class implementStackUsingQueues {
	Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if (empty()) {
            queue1.offer(x);
        }
        else{
            if (queue1.size() > 0) {
                int size = queue1.size();
                queue2.offer(x);
                while (size > 0) {
                    queue2.offer(queue1.poll());
                    size--;
                }
            }
            else if (queue2.size() > 0) {
                int size = queue2.size();
                queue1.offer(x);
                while (size > 0) {
                    queue1.offer(queue2.poll());
                    size--;
                }
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.size() > 0){
            queue1.poll();
        }
        else if (queue2.size() > 0){
            queue2.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (queue1.size() > 0){
            return queue1.peek();
        }
        else if (queue2.size() > 0){
            return queue2.peek();
        }
        return Integer.MIN_VALUE;//impossible
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}

/**
 * Method 2, O(1) push, empty; O(n) pop, top
 * @author Neo
 *
 */
class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        int top = queue.peek();
        queue.offer(queue.poll());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}