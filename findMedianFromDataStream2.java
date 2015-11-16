package first;
import java.util.*;
public class findMedianFromDataStream2 {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new newComparator2());

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == 0) {
            maxHeap.offer(num);
        } else if (num > maxHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return 0.5 * (maxHeap.peek() + minHeap.peek());
        } else {
            return 1.0 * maxHeap.peek();
        }
    }
    
    public static void main(String[] args) {
    	findMedianFromDataStream2 ff = new findMedianFromDataStream2();
    	ff.addNum(1);
    	ff.addNum(2); 
    	System.out.println(ff.findMedian());
    	ff.addNum(3);
    	System.out.println(ff.findMedian());
    }

}
class newComparator2 implements Comparator<Integer> {
	@Override
	public int compare (Integer x, Integer y) {
		return y - x;
	}
}
