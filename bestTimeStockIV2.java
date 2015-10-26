package first;

public class bestTimeStockIV2 {
	public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k == 0){
            return 0;
        }
        int n = prices.length;
        
        if (2 * k >= n){
            return quickSolve(k , prices);
        }
        
        int[][] local = new int[n + 1][k + 1];
        int[][] global = new int[n + 1][k + 1];
        
        for (int i = 2; i <= n; i++){
            int diff = prices[i - 1] - prices[i - 2];
            for (int j = 1; j <= k; j++){
                local[i][j] = Math.max(local[i - 1][j] + diff, global[i - 1][j - 1] + Math.max(diff, 0));
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n][k];
    }
    
    public int quickSolve(int k, int[] prices){
        int res = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

}
