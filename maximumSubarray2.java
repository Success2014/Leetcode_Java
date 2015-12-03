package first;

public class maximumSubarray2 {
	public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] prefix = new int[n + 1];
        prefix[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int max = Integer.MIN_VALUE;
        int minSoFar = prefix[0];
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, prefix[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prefix[i]);
        }
        return max;
    }

}
