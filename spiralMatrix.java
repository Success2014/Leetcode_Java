package first;

import java.util.List;
import java.util.ArrayList;

public class spiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length, n = (m==0)?0:matrix[0].length;
        if (m == 0) return res;
        
        
        int i = 0, j = -1;
        
        while (true){
            
            for (int c = 1; c <= n; c++){
                j ++;
                res.add(matrix[i][j]);
            }
            
            
            m--;
            if (m <= 0) break;
            for (int c = 1; c <= m; c++){
                i ++;
                res.add(matrix[i][j]);
            }
            
            
            n--;
            if (n <= 0) break;
            for (int c = 1; c <= n; c++){
                j --;
                res.add(matrix[i][j]);
            }
            
            m--;
            if(m <= 0) break;
            for (int c = 1; c <= m; c++){
                i --;
                res.add(matrix[i][j]);
            }
            
            n--;
            if(n <= 0) break;
        }
        return res;
        
    }
	
	public static void main(String[] args){
		int[][] matrix1 = {{2,3}};
		spiralMatrix sm = new spiralMatrix();
		System.out.println(sm.spiralOrder(matrix1));
	}

}
