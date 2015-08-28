package first;

import java.util.Arrays;

public class spiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //int total = n * n;
        int i = 0, j = -1, t = 0;
        int row = n, col = n;
        
        while(n > 0){
            for (int c = 0; c < col; c++){
                t++;
                j++;
                matrix[i][j] = t;
            }
            
            row--;
            if (row <= 0) break;
            for (int c = 0; c < row; c++){
                t++;
                i++;
                matrix[i][j] = t;
            }
            
            col--;
            if (col <= 0) break;
            for (int c = 0; c < col; c++){
                t++;
                j--;
                matrix[i][j] = t;
            }
            
            row--;
            if (row <= 0) break;
            for (int c =0; c < row; c++){
                t++;
                i--;
                matrix[i][j] = t;
            }
            
            col--;
            if (col <= 0) break;
            
        }
        return matrix;
        
        
    }
	
	public static void main (String[] args){
		spiralMatrixII sm = new spiralMatrixII();
		System.out.println(Arrays.deepToString((sm.generateMatrix(3))));
	}

}
