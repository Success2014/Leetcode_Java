package first;
import java.util.PriorityQueue;
import java.util.Comparator;

public class findMedianFromDataStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new newComparator());

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.offer(num);
        } else {
            int prevMedian = maxHeap.peek();
            if (num > prevMedian) {
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
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size () == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return maxHeap.peek() * 1.0;
        }
    }
};

class newComparator implements Comparator<Integer> {
    @Override
    public int compare (Integer x, Integer y) {
        return y - x;
    }
}