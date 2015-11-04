package first;

public class bestTimeStock3 {
	public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            res = Math.max(prices[i] - min, res);
        }
        return res;
    }

}
