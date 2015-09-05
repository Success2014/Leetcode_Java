package first;

public class uniquePaths {
	public int uniquePathsM(int m, int n) {
        if (m == 0 || n == 0){
            return 0;
        }
        
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int k = 1; k < n; k++){
            f[0][k] = 1;
        }
        for (int k = 1; k < m; k++){
            f[k][0] = 1;
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
        
    }

}
