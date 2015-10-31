package first;
import java.util.Stack;
public class maximalRectangle2 {
	public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        int[][] height = new int[m][n+1]; // put extra -1 at the end
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    height[i][j] = -1;
                }
                else if (matrix[i][j] != '0') {
                    height[i][j] = (i == 0) ? 1 : height[i-1][j] + 1;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++){
            int area = maxRectHist(height[i]);
            res = Math.max(res, area);
        }
        
        return res;
    }
    public int maxRectHist(int[] row) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < row.length; i++) {
            int curt = row[i];
            while (!stack.isEmpty() && curt <= row[stack.peek()]) {
                int h = row[stack.pop()];
                int w = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }

}
