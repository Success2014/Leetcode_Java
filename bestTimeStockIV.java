import java.util.Arrays;


public class bestTimeStockIV {
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (len <= 1){
			return 0;
		}
		if (2*k > len){
			return quickSolve(k, prices);
		}
		int[] dp = new int[2*k + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		for (int i = 0; i < len; i++){
			for (int j = 1; j < Math.min(2*k, i+1)+1; j++){
				if (j % 2 == 1){
					dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
				}
				else{
					dp[j] = Math.max(dp[j], dp[j-1] + prices[i]);
				}
			}
		}
		return dp[2*k];


	}
	
	public int quickSolve(int k, int[] prices){
		int sum = 0;
		for (int i = 1; i < prices.length; i++){
			if (prices[i] > prices[i-1]){
				sum += prices[i] - prices[i-1];
			}
		}
		return sum;
	}
	
	public static void main (String[] args){
		int[] prices = {5, 3, 1, 8, 9, 7, 1, 9};
		bestTimeStockIV bts = new bestTimeStockIV();
		System.out.println(bts.maxProfit(2,prices));
	}

}
