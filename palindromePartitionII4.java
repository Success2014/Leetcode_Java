package first;

public class palindromePartitionII4 {
	public int minCut(String s) {
        int n = s.length();
        boolean[][] flag = getIsPal(s);
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n];
    }
    public boolean[][] getIsPal(String s) {
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            flag[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag[i][i + 1] = true;
            }
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                flag[i][i + len] = (s.charAt(i) == s.charAt(i + len) && flag[i + 1][i + len - 1]);
            }
        }
        return flag;
    }
    public boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	palindromePartitionII4 pp = new palindromePartitionII4();
    	String s1 = "bb";
    	System.out.println(pp.minCut(s1));
    }

}
