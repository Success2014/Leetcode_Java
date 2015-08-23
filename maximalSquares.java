package first;

public class maximalSquares {
	/**
	 * idea: dynamic programming. Use dp[i][j] to record the largest square using (i,j) as the 
	 * lower right corner. The relationship is:
	 * dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1
	 * if dp[i][j] is 1; otherwise it would be 0.
	 *  Tags: Dynamic Programming
		Similar Problems (H) Maximal Rectangle

	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        
        for (int j = 0; j < n; j++){
            if (matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                } 
            }
        }
        return max * max;
    }
	
	public static void main(String[] args){
		maximalSquares ms = new maximalSquares();
		char[][] matrix1 = {{'1','1'},{'1','1'}};
		char[][] matrix2 = {{'1','0','1','0','0'},{'1','0','1','1','1'},
				{'1','0','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(ms.maximalSquare(matrix1));
		System.out.println(ms.maximalSquare(matrix2));
	}

}
