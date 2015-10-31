package first;
import java.util.Stack;
public class largestRectangleInHistogram2 {
	public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i <= height.length; i++){
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
	public static void main(String[] args) {
		largestRectangleInHistogram2 lr = new largestRectangleInHistogram2();
		int[] h1 = {4, 2};
		System.out.println(lr.largestRectangleArea(h1));
	}

}
