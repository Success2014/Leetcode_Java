package first;
/**
 * http://bookshadow.com/weblog/2015/01/07/leetcode-dungeon-game/
 * http://www.programcreek.com/2014/03/leetcode-dungeon-game-java/
 * idea:
 * Work from the where the princess is to the beginning.
 * The minimum HP for the knight is 1 at each room.
 * 
 * If room is negative, we should add that amount;
 * If room is nonnegative, we should minus that amount but keep at least 1
 * 
 * -1 -1  0
 * -2  1 -2
 *  1  0  -1
 *  
 *  3  2  4
 *  3  1  4
 *  1  2  2
 * 
 * 
 * 
 * @author Neo
 *
 */
public class dungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n]; // dp[i][j] stores the minimum HP before entering room[i][j]
        
        dp[m-1][n-1] = Math.max(0, -dungeon[m-1][n-1]) + 1;
        //last row
        for (int j = n - 2; j >= 0; j--) dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
        //last column
        for (int i = m - 2; i >= 0; i--) dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        
        for (int i = m - 2; i >= 0; i--){
            for (int j = n - 2; j >= 0; j--){
                int down = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }

}
