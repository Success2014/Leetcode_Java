package first;

public class bestTimeStock {
	public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }
	public static void main(String[] args){
		bestTimeStock bts = new bestTimeStock();
		int[] p1 = {5, 9, 3, 1, 5, 8, 7};
		System.out.println(bts.maxProfit(p1));
	}

}
