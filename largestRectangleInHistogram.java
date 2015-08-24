package first;
import java.util.Arrays;
/**
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * http://chaoren.is-programmer.com/posts/42674.html
 * idea:
 * Keep the indices in the stack, which represents a monotone nondecreasing sequence. 
 * So push the element of the histogram into the stack
 * if the element is greater than or equal to the top element in the stack. If the element in the histogram
 * is less than the top element in the stack, we should pop out the elements with greater value, and 
 * calculate the area using the popped out element as the shortest element. Keep doing this, until the top
 * element of the stack is less than current element or stack is empty.
 * Note adding 0 at the end so that all the element in the stack will be popped out.
 * @author Neo
 *
 */
import java.util.Stack;

public class largestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1); // the last element is 0 by default
        int i = 0;
        int maxArea = 0;
        while (i < h.length){
        	if (stack.isEmpty() || h[i] >= h[stack.peek()]){
        		stack.push(i);
        		i++;
        	}
        	else{
        		int smallestHeight = h[stack.pop()];
        		int width = (stack.isEmpty())? i : (i - stack.peek() - 1);
        		maxArea = Math.max(maxArea, smallestHeight * width);
        	}
        }
        return maxArea;
    }
	
	public static void main(String[] args){
		largestRectangleInHistogram lrh = new largestRectangleInHistogram();
		int[] height1 = {2,1,5,6,2,3};
		int[] height2 = {1,1};
		System.out.println(lrh.largestRectangleArea(height1));
		System.out.println(lrh.largestRectangleArea(height2));
	}

}
