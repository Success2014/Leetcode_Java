package first;

public class bestTimeStockII3 {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i -1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
