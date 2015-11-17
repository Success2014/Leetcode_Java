package first;
import java.util.*;
public class largestRectangleInHistogram3 {
	public int largestRectangleArea(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int curt =  (i == n) ? -1 : height[i];
            
        	while (!stack.isEmpty() && curt < height[stack.peek()]) {
                int h = height[stack.pop()];
                int left = (stack.isEmpty()) ? -1 : stack.peek();
                int right = i;
                max = Math.max(max, (right - left - 1) * h);
            }
        	stack.push(i);
        }
        return max;
    }
	public static void main(String[] args) {
		largestRectangleInHistogram3 lr = new largestRectangleInHistogram3();
		int[] height1 = {1,1};
		int[] height2 = {4,2};
		int[] height3 = {2,0,2};
		System.out.println(lr.largestRectangleArea(height1));
	}

}
