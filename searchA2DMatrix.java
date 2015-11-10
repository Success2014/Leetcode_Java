package first;

public class searchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int row = 0;
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        start = 0;
        end = n - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target){
            return true;
        } else {
            return false;
        }
    }
	
	public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		searchA2DMatrix sm = new searchA2DMatrix();
		int[][] m1 = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(sm.searchMatrix(m1, 5));
	}
}

