package first;
import java.util.*;
public class largestRectangleInHistogram4 {
	public int largestRectangleArea(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int curt = (i == n) ? -1 : height[i];
            while (!stack.isEmpty() && curt < height[stack.peek()]) {
                int index = stack.pop();
                int left = (stack.isEmpty()) ? -1 : stack.peek();
                int right = i;
                max = Math.max(max, height[index] * (right - left - 1));
            } 
            stack.push(i);
        }
        return max;
    }

}
