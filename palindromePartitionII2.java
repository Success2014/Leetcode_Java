package first;

public class palindromePartitionII2 {
	public int minCut(String s) {
        int n = s.length();
        
        int[] dp = new int[n + 1];
        boolean[][] isPalA = getIsPalindrome(s);
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalA[j][i-1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
    public boolean[][] getIsPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalA =  new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            isPalA[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalA[i][i + 1] = true;
            }
        }
        
        for (int len = 2; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                isPalA[start][start + len] = isPalA[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }
        return isPalA;
    }

}
