package first;

public class bestTimeStockIII4 {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        
        int forwardMin = Integer.MAX_VALUE;
        int forwardMax = 0;
        int[] forward = new int[n];
        for (int i = 0; i < n; i++) {
            forwardMin = Math.min(forwardMin, prices[i]);
            forwardMax = Math.max(forwardMax, prices[i] - forwardMin);
            forward[i] = forwardMax;
        }
        
        int backwardMax = Integer.MIN_VALUE;
        int max = 0;
        int[] backward = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            backwardMax = Math.max(backwardMax, prices[i]);
            max = backwardMax - prices[i];
            backward[i] = max;
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(forward[i] + backward[i], res);
        }
        return res;
    }

}
