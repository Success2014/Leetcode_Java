package first;
import java.util.*;
public class maximalRectangle3 {
	public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            heights[0][j] = (matrix[0][j] == '1') ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i - 1][j] + 1;
                    }
            }
        }
                    
        int max = 0;
        for (int i = 0; i < m; i++) {
            int curt = largestRectangleArea(heights[i]);
            max = Math.max(max, curt);
        }
        return max;
    }
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

}
