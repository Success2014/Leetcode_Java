package first;

public class bestTimeStock2 {
	public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        
        int res = Integer.MIN_VALUE;
        int minToNow = prices[0];
        
        for (int i = 1; i < prices.length; i++){
            minToNow = Math.min(minToNow, prices[i]);
            res = Math.max(res, prices[i] - minToNow);
        }
        return res;
    }
}
