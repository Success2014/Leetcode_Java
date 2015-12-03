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
	
	public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int minSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
    }
	
	public int maxSubArray3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < n; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

}
