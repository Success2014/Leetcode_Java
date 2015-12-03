package first;

public class bestTimeStockIII5 {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int[] forward = new int[n];
        int forwardMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            forwardMax = Math.max(forwardMax, prices[i] - min);
            forward[i] = forwardMax;
        }
        
        int max = Integer.MIN_VALUE;
        int[] backward = new int[n];
        int backwardMax = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            backwardMax = Math.max(backwardMax, max - prices[i]);
            backward[i] = backwardMax;
        }
        
        int global = 0;
        for (int i = 0; i < n; i++) {
            global = Math.max(global, forward[i] + backward[i]);
        }
        return global;
    }

}
