package first;

public class bestTimeStock5 {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

}
