package first;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * https://leetcode.com/discuss/46578/java-o-n-solution-using-deque-with-explanation
 * idea:
 * We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) 
 * as each element is put and polled once.At each i, we keep "promising" elements, which are potentially max 
 * number in window [i-(k-1),i] or any subsequent window. This means 
 * 1. If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the 
 * head, as we are using a deque and elements are ordered as the sequence in the array 
 * 2. Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than 
 * a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" 
 * in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.
 * 3. As a result elements in the deque are ordered in both sequence in array and their value. 
 * At each step the head of the deque is the max element in [i-(k-1),i]
 * @author Neo
 *
 */
public class slidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
        int n  = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0; // index of the result
        Deque<Integer> q = new ArrayDeque<Integer>();//q stores index
        
        for (int i = 0; i < n; i++){
        	// remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - (k - 1)) {
            	q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
            	q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
            	res[ri++] = nums[q.peek()];
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		slidingWindowMaximum swm = new slidingWindowMaximum();
		int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
		System.out.println(Arrays.toString(swm.maxSlidingWindow(nums1, 3)));
	}

}
