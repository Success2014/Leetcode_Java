package first;

import java.util.List;

public class triangle {
	/**
	 * Top-down. f[i][j] is the minimum sum till row i, column j.
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i + 1; j++){
                if (j == 0){
                    f[i][j] = f[i-1][0] + triangle.get(i).get(j);
                }
                else if (j == i){
                    f[i][j] = f[i-1][i-1] + triangle.get(i).get(j);
                }
                else{
                    f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++){
            min = Math.min(min, f[n-1][k]);
        }
        return min;                
    }
	
	/**
	 * Bottom up.
	 * @param triangle
	 * @return
	 */
	public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[][] f = new int[n][n];
        //bottom up
        for (int k = 0; k < n; k++){
            f[n-1][k] = triangle.get(n-1).get(k);
        }
        
        for (int i = n - 2; i >= 0 ; i--){
            for (int j = 0; j < i + 1; j++){
                f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        
        return f[0][0];
    }

}
