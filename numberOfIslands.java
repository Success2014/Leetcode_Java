package first;

public class numberOfIslands {
	public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    removeOnes(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    public void removeOnes(char[][] grid, int x, int y, int m, int n) {
        grid[x][y] = '0';
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == '1') {
                    removeOnes(grid, nextX, nextY, m, n);
                }
            }
        }
    }

}
