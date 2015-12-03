package first;

public class maximumProductSubarray {
	public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int global = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            int tempMax = max;
            int tempMin = min;
            max = Math.max(tempMax * nums[i], Math.max(tempMin * nums[i], nums[i]));
            min = Math.min(tempMax * nums[i], Math.min(tempMin * nums[i], nums[i]));
            global = Math.max(global, max);
        }
        return global;
    }

}
