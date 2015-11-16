package first;

public class palindromePartitionII3 {
	public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = getIsPal(s);
        int[] dp = new int[n + 1];
        dp[0] = -1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
    public boolean[][] getIsPal(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || res[i + 1][j - 1])) {
                    res[i][j] = true;
                }
            }
        }
        return res;
    }

}
