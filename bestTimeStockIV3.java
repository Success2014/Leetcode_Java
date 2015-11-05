package first;

public class bestTimeStockIV3 {
	public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k < 1) {
            return 0;
        }
        if (2 * k >= n) {
            return quickSolver(k, prices);
        }
        int[][] local = new int[n][k + 1];
        int[][] global = new int[n][k + 1];
        
        for (int i = 1; i < n; i++) {
            int gain = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(local[i-1][j] + gain, global[i-1][j-1] + Math.max(gain, 0));
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[n-1][k];
    }
    
    public int quickSolver(int k, int[] prices) {
        int res = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
    
    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k < 1) {
            return 0;
        }
        if (2 * k >= n) {
            return quickSolver(k, prices);
        }
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        
        for (int i = 1; i < n; i++) {
            int gain = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(local[j] + gain, global[j-1] + Math.max(gain, 0));
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    public static void main(String[] args) {
    	bestTimeStockIV3 bs3 = new bestTimeStockIV3();
    	int[] p1 = {3,2,6,5,0,3};
    	System.out.println(bs3.maxProfit2(2, p1));
    }

}
