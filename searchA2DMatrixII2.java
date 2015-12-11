package first;

public class searchA2DMatrixII2 {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		searchA2DMatrixII2 sm = new searchA2DMatrixII2();
		int[][] matrix = {{1,1}};
		System.out.println(sm.searchMatrix(matrix, 2));
	}

}
