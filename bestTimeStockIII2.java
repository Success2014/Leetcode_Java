package first;

public class bestTimeStockIII2 {
	public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int n = prices.length;
        
        int[] forward = new int[n];
        int min = Integer.MAX_VALUE;
        int forwardMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            min = Math.min(min, prices[i]);
            forwardMax = Math.max(forwardMax, prices[i] - min);
            forward[i] = forwardMax;
        }
        
        int[] backward = new int[n];
        int max = Integer.MIN_VALUE;
        int backwardMax = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--){
            max = Math.max(max, prices[j]);
            backwardMax = Math.max(backwardMax, max - prices[j]);
            backward[j] = backwardMax;
        }
        
        int res = 0;
        for (int k = 0; k < n; k++){
            res = Math.max(res, forward[k] + backward[k]);
        }
        return res;
    }

}
