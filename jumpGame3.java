package first;

public class jumpGame3 {
	public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
            } else {
                return false;
            }
            if (max >= n - 1) {
                return true;
            }
        }
        return false;
    }

}
