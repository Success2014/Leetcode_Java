package first;

public class bestTimeStockIII {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1){
            return 0;
        }
        
        int min = prices[0];
        int forwardMax = 0;
        int[] forward = new int[n];
        for (int i = 0; i < n; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            forwardMax = Math.max(forwardMax, prices[i] - min);
            forward[i] = forwardMax;
        }
        
        int max = prices[n - 1];
        int backwardMax = 0;
        int[] backward = new int[n];
        for (int i = n - 1; i >= 0; i--){
            if (prices[i] > max){
                max = prices[i];
            }
            backwardMax = Math.max(backwardMax, max - prices[i]);
            backward[i] = backwardMax;
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, forward[i] + backward[i]);
        }
        return maxProfit;
    }

}
