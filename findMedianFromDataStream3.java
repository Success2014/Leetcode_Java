package first;
import java.util.*;
public class findMedianFromDataStream3 {
	
    class newComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer x, Integer y) {
            return y - x;
        }
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new newComparator());

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        int temp = maxHeap.peek();
        if (num > temp) {
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
    	findMedianFromDataStream3 fm = new findMedianFromDataStream3();
    	fm.addNum(2);
    	System.out.println(fm.findMedian());
    	fm.addNum(3);
    	System.out.println(fm.findMedian());
    }

}
