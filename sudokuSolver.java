package first;

/**
 * http://blog.csdn.net/linhuanmars/article/details/20748761
 * http://blog.csdn.net/linhuanmars/article/details/20748171
 * 这道题的方法就是用在N-Queens中介绍的常见套路。简单地说思路就是循环处理子问题，对于每个格子，带入不同的9个数，然后判合法，如果成立就递归继续，
 * 结束后把数字设回空。大家可以看出代码结构和N-Queens是完全一样的。判合法可以用Valid Sudoku做为subroutine，但是其实在这里因为每次进入时已经
 * 保证之前的board不会冲突，所以不需要判断整个盘，只需要看当前加入的数字和之前是否冲突就可以，这样可以大大提高运行效率，毕竟判合法在程序中被多次调用。
 * 
 * 再强调一下哈，以上方法是一个非常典型的套路，大部分NP问题的都是可以这个方法，比如N-Queens，Combination Sum，Combinations，Permutations等。
 * @author Neo
 *
 */
public class sudokuSolver {
	public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    for (int t = 1; t <= 9; t++){
                        board[i][j] = (char) (t + '0');
                        if (isValid(board, i, j) && solve(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    // Since the board is filled in sequentially, there is no
    // need to check the whole board each time.
    // Only check row i, column j, and the subboard it is in
    public boolean isValid(char[][] board, int i, int j){
        //check row
        for (int k = 0; k < 9; k++){
            if (k!=j && board[i][k] == board[i][j]) return false;
        }
        //check column
        for (int k = 0; k < 9; k++){
            if (k!=i && board[k][j] == board[i][j]) return false;
        }
        //check subboard
        for (int x = i/3*3; x < i/3*3+3; x++){
            for (int y = j/3*3; y < j/3*3+3; y++){
                if ((x!=i || y!=j) && board[x][y] == board[i][j]) return false;
            }
        }
        return true;
    }

}
