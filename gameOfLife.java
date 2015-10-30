package first;
import java.util.Arrays;
public class gameOfLife {
	public void gameOfLifeM(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives =0;
                boolean liveFlag = (board[i][j] == 1) ? true : false;
                for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
                    for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                        lives += (board[x][y] & 1);
                    }
                }
                lives -= board[i][j]; // only consider neighbors
                if (((lives == 2) && liveFlag) || (lives == 3)) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
	public static void main(String[] args) {
		gameOfLife gl = new gameOfLife();
		int[][] board = {{0}};
		gl.gameOfLifeM(board);
		System.out.println(Arrays.deepToString(board));
	}

}
