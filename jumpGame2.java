package first;

public class jumpGame2 {
	public boolean canJump(int[] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (max >= i) {
                max = Math.max(nums[i] + i, max);
            } else {
                return false;
            }
            if (max >= n - 1) {
                return true;
            }
        }
        
        if (max >= n - 1) {
            return true;
        } else {
            return false;
        }
    }

}
