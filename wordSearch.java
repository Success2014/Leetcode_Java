package first;

public class wordSearch {
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(board, i, j, word, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int x, int y, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(k)) {
            return false;
        }
        board[x][y] = '#';
        if (dfs(board, x + 1, y, word, k + 1) || dfs(board, x -1 , y, word, k + 1) || dfs(board, x , y + 1, word, k + 1) || dfs(board, x , y - 1, word, k + 1)) {
            return true;
        }
        board[x][y] = word.charAt(k);
        return false;
    }
    public static void main(String[] args) {
    	wordSearch ws = new wordSearch();
    	char[][] board = {{'a','b'}};
    	String word = "ba";
    	System.out.println(ws.exist(board, word));
    }

}
