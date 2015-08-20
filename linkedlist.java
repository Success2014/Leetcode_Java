
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;
//ArrayList		add set contains get remove indexOf isEmpty size toArray
//LinkedList	add element peek poll pop offer push indexOf isEmpty getFirst getLast
//Stack			peek pop push, empty search
//Queue			peek poll offer, add element remove isEmpty
//Iterator		hasNext next remove
public class linkedlist {
	public static void main(String[] args){
		//Stack, push at front, peek/pop at front; add at front
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);stack.push(2);stack.add(3);//if stack1.add(3); 3 is added at front, same with push(3);
		System.out.print(stack.peek());
		System.out.print(stack.pop());
		System.out.print(stack.peek());
		System.out.println();
		//queue, 
		Queue<Integer> queue=new LinkedList<Integer>();
		//LinkedList.stack, push at front, peek/pop at front; (add at end)
		LinkedList<Integer> stack1=new LinkedList<Integer>();
		stack1.push(1);stack1.push(2);stack1.push(3);//if stack1.add(3); 3 is added at end
		System.out.print(stack1.peek());
		System.out.print(stack1.pop());
		System.out.print(stack1.peek());
		System.out.println();
		//LinkedList.queue, offer at end, peek/poll at front; (push at front, add at end, element at front, pop at front, remove at front)
			//a bad method, push at front, getLast at last;
		LinkedList<Integer> queue1=new LinkedList<Integer>();
		queue1.offer(1);queue1.offer(2);queue1.add(3);
		System.out.print(queue1.peek());
		System.out.print(queue1.element());
		System.out.print(queue1.getLast());
		System.out.print(queue1.poll());
		System.out.print(queue1.pop());
		System.out.println();
		//Iterator
		queue1.offer(1);queue1.offer(2);queue1.add(3);
		Iterator ite=queue1.iterator();
		while(ite.hasNext()){
			System.out.print(ite.next());
		}
		System.out.println();
		System.out.print(queue1.indexOf(2));
	}

}
