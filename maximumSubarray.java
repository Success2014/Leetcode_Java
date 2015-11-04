package first;

public class maximumSubarray {
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

}
