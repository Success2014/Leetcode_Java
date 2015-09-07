package first;

public class palindromePartitionII {
	public int minCut(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int n = s.length();
        boolean[][] isPalA = isPal(s);
        int[] dp = new int[n+1];
        for (int i = 0; i < n + 1; i++){
            dp[i] = i - 1;
        }
        
        for (int i = 1; i < n + 1; i++){
            for (int j = 0; j < i; j++){
                if (isPalA[j][i-1]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
        
    }
    
    public boolean[][] isPal(String s){
        int n = s.length();
        boolean[][] isPalA = new boolean[n][n];
        //distance is 0
        for (int i = 0; i < n; i++){
            isPalA[i][i] = true;
        }
        //distance is 1
        for (int i = 0; i < n - 1; i++){ //note here i < n - 1 
            if (s.charAt(i) == s.charAt(i+1)){
                isPalA[i][i+1] = true;
            }
        }
        //distance >= 2, move to upper-right corner diagonally
        for (int len = 2; len < n; len++){
            for (int start = 0; start + len < n; start++){
                isPalA[start][start+len] = isPalA[start+1][start+len-1] &&(s.charAt(start)==s.charAt(start+len));
            }
        }
        return isPalA;
    }

}
