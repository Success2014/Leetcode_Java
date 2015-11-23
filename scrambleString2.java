package first;

public class scrambleString2 {
	public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        if (m != n) {
            return false;
        }
        if (m == 0 || s1.equals(s2)) {
            return true;
        }
        
        boolean[][][] dp = new boolean[m + 1][m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        
        for (int len = 2; len <= m; len++) {
            for (int i = 0; i <= m - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    for (int k = 1; k <= len; k++) {
                        boolean cond1 = dp[k][i][j] && dp[len - k][i + k][j + k];
                        boolean cond2 = dp[k][i][j + len - k] && dp[len - k][i + k][j];
                        if (cond1 || cond2) {
                            dp[len][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[m][0][0];
    }

}
