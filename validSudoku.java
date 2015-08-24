package first;
/**
 * http://blog.csdn.net/linhuanmars/article/details/20748171
 * @author Neo
 *
 */
public class validSudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        //check row
        for (int i = 0; i < 9; i++){
            boolean[] rowcheck = new boolean[9];
            for (int j = 0; j < 9; j++){
                if(board[i][j] != '.') {
                    if (rowcheck[(int) (board[i][j] - '1')]){
                        return false;
                    }
                    rowcheck[(int) (board[i][j] - '1')] = true;
                }
            }
        }
        //check column
        for (int j = 0; j < 9; j++){
            boolean[] colcheck = new boolean[9];
            for (int i = 0; i < 9; i++){
                if(board[i][j] != '.') {
                    if (colcheck[(int)(board[i][j] - '1')]){
                        return false;
                    }
                    colcheck[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        //check subboard
        for (int block = 0; block < 9; block++){
            boolean[] scheck = new boolean[9];
            for (int i = block/3*3; i < block/3*3 + 3; i++){
                for (int j = block%3*3; j < block%3*3 + 3; j++){
                    if(board[i][j] != '.'){
                        if (scheck[(int)(board[i][j] - '1')]){
                            return false;
                        }
                        scheck[(int)(board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
        
    }

}
