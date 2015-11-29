package first;
import java.util.*;
public class slidingWindowMaximum2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i ++) {
            if (deque.isEmpty()) {
                deque.offer(i);
            } else {
                // remove smaller numbers in k range as they are useless
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                // remove numbers out of range k
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

}
