package first;

public class longestIncreasingSubsequence3 {
	public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
	public static void main(String[] args) {
		longestIncreasingSubsequence3 lis = new longestIncreasingSubsequence3();
		int[] nums1 = {2,5,7,3};
		System.out.println(lis.lengthOfLIS(nums1));
	}

}
