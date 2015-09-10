package first;

public class scrambleString {
	/**
	 * dp[n][i][j] means isScramble(s1[i:i+n], s2[j:j+n]), n is the length, 
	 * Not include i+n, j+n. 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2){
            return false;
        }
        if (n1 == 0 || s1.equals(s2)){
            return true;
        }
        
        boolean[][][] dp = new boolean[n1+1][n1][n1];
        for (int i = 0; i < n1; i++){
            for (int j = 0; j < n1; j++){
                dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        
        for (int len = 2; len <= n1; len++){
            for (int i = 0; i <= n1 - len; i++){
                for (int j = 0; j <= n1 - len; j++){
                    dp[len][i][j] = false;
                    for (int k = 1; k <= len; k++){
                        boolean cond1 = dp[k][i][j] && dp[len-k][i+k][j+k];
                        boolean cond2 = dp[k][i][j+len-k] && dp[len-k][i+k][j];
                        if (cond1 || cond2){
                            dp[len][i][j] = true;
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return dp[n1][0][0];
    }

}
