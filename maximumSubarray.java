package first;

public class maximumSubarray {
	/**
	 * DP
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }
	/**
	 * Use prefix sum
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int minSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
        
    }
	
	public static void main(String[] args) {
		maximumSubarray ms = new maximumSubarray();
		int[] nums = {2,-3,-1,-4};
		System.out.println(ms.maxSubArray2(nums));
	}

}
