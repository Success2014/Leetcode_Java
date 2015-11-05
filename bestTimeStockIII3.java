package first;

public class bestTimeStockIII3 {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        
        int forwardMin = Integer.MAX_VALUE;
        int forwardMaxRes = Integer.MIN_VALUE;
        int[] forward = new int[n];
        for (int i = 0; i < n; i++) {
            forwardMin = Math.min(forwardMin, prices[i]);
            forwardMaxRes = Math.max(forwardMaxRes, prices[i] - forwardMin);
            forward[i] = forwardMaxRes;
        }
        
        int backwardMax = Integer.MIN_VALUE;
        int backwardMaxRes = Integer.MIN_VALUE;
        int[] backward = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            backwardMax = Math.max(backwardMax, prices[i]);
            backwardMaxRes = Math.max(backwardMaxRes, backwardMax - prices[i]);
            backward[i] = backwardMaxRes;
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, forward[i] + backward[i]);
        }
        return res;
    }

}
