package first;

/**
 * http://blog.csdn.net/linhuanmars/article/details/20748761
 * http://blog.csdn.net/linhuanmars/article/details/20748171
 * �����ķ�����������N-Queens�н��ܵĳ�����·���򵥵�˵˼·����ѭ�����������⣬����ÿ�����ӣ����벻ͬ��9������Ȼ���кϷ�����������͵ݹ������
 * �������������ؿա���ҿ��Կ�������ṹ��N-Queens����ȫһ���ġ��кϷ�������Valid Sudoku��Ϊsubroutine��������ʵ��������Ϊÿ�ν���ʱ�Ѿ�
 * ��֤֮ǰ��board�����ͻ�����Բ���Ҫ�ж������̣�ֻ��Ҫ����ǰ��������ֺ�֮ǰ�Ƿ��ͻ�Ϳ��ԣ��������Դ���������Ч�ʣ��Ͼ��кϷ��ڳ����б���ε��á�
 * 
 * ��ǿ��һ�¹������Ϸ�����һ���ǳ����͵���·���󲿷�NP����Ķ��ǿ����������������N-Queens��Combination Sum��Combinations��Permutations�ȡ�
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
