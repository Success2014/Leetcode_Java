package first;

public class houseRobber {
	/**
	 * O(n) time, O(n) space.
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
	
	/**
	 * O(n) time, O(1) space.
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp0 = Math.max(dp1, dp0 + nums[i - 1]);
            } else {
                dp1 = Math.max(dp0, dp1 + nums[i - 1]);
            }
        }
        return Math.max(dp0, dp1);
    }

}
