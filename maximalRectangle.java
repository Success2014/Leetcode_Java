package first;

/**
 * http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
 * idea: Leverage the code in Largest Rectangle In Histogram.
 * Use a dynamic programming to calculate the height of each row, O(n^2).
 * For each row find the largest rectangle, O(n^2).
 * The subroutine maxAreaInHist is O(n).
 * @author Neo
 *
 */
import java.util.Stack;
import java.util.Arrays;
public class maximalRectangle {
	public int maximalRectangleC(char[][] matrix) {
        int m = matrix.length;
        int n = (m == 0)? 0 : matrix[0].length;
        int areaMax = 0;
        int[][] height = new int[m][n+1];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){ //leave the last one as 0 in each row
                if (matrix[i][j] != '0'){
                    if (i == 0) height[i][j] = 1;
                    else height[i][j] = height[i-1][j] + 1;
                }
            }
        }
        
        for (int i = 0; i < m; i++){
            int rowMax = maxAreaInHist(height[i]);
            areaMax = Math.max(areaMax, rowMax);
        }
        return areaMax;
        
    }
    
    public int maxAreaInHist(int[] height){
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i = 0;
        int[] h = new int[height.length]; // already added 0 before
        h = Arrays.copyOf(height,height.length); // remember to copy
        
        while (i < h.length){
            if (stack.isEmpty() || h[i] >= h[stack.peek()]){
                stack.push(i++);
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
    	maximalRectangle mr = new maximalRectangle();
    	char[][] matrix1 = {{'1'}};
    	char[][] matrix2 = {{'1','0','1','0','0'},{'1','0','1','1','1'},
				{'1','0','1','1','1'},{'1','0','0','1','0'}};
    	System.out.println(mr.maximalRectangleC(matrix1));
    	System.out.println(mr.maximalRectangleC(matrix2));
    }

}
