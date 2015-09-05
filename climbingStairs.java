package first;

public class climbingStairs {
	public int climbStairs(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i < n; i++){
            int temp = dp[1];
            dp[1] += dp[0];
            dp[0] = temp;
        }
        return dp[1];
    }

}
