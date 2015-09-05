package first;

public class uniquePathSII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] f = new int[m][n];
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        else{
            f[0][0] = 1;
        }
        
        boolean isObR = false;
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                isObR = true;
            }
            f[0][j] = isObR? 0: 1;
        }
        
        boolean isObC = false;
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                isObC = true;
            }
            f[i][0] = isObC? 0: 1;
        }
        
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] ==1){
                    f[i][j] = 0;
                }
                else{
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

}
