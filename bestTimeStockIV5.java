package first;

public class bestTimeStockIV5 {
	public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k == 0) {
            return 0;
        }
        if (n < 2 * k) {
            return quickSolve(prices);
        }
        int[][] local = new int[n + 1][k + 1];
        int[][] global = new int[n + 1][k + 1];
        for (int i = 2; i <= n; i++) {
            int diff = prices[i - 1] - prices[i -2];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(local[i - 1][j] + diff, global[i - 1][j - 1] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[n][k];
    }
	
	public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k == 0) {
            return 0;
        }
        if (n < 2 * k) {
            return quickSolve(prices);
        }
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 2; i <= n; i++) {
            int diff = prices[i - 1] - prices[i -2];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(local[j] + diff, global[j - 1] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
    public int quickSolve(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

}
