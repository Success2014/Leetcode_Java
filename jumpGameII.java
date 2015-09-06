package first;

public class jumpGameII {
	/**
	 * DP. O(n^2). For each element i, look back from the start to find the number of steps it takes to
	 * reach current element. If we can do it from the start, then it would be the minimum steps
	 * to reach i, since later elements definitely would take more steps or at least the same steps.
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (j + nums[j] >= i){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n-1];
    }
	
	/**
	 * Greedy. O(n). Use res to track the minimum number of steps needed to get to current position.
	 * curMax records the farthest we can go using res steps. nxtMax 
	 * @param nums
	 * @return
	 */
	public int jump2(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int res = 0;
        int curMax = 0;
        int nxtMax = 0;
        
        for (int i = 0; i < nums.length; i++){
            if (i > curMax){
                res++;
                curMax = nxtMax;
            }
            nxtMax = Math.max(nxtMax, i + nums[i]);
            
            if (curMax >= nums.length - 1){
                break;
            }
        }
        return res;
    }

}
