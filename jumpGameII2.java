package first;

public class jumpGameII2 {
	public int jump(int[] nums) {
        int minStep = 0;
        int curt = 0;
        int next = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > curt) {
                minStep++;
                curt = next;
            }
            if (curt >= n - 1) {
                break;
            }
            next = Math.max(next, i + nums[i]);
        }
        return minStep;
    }

}
