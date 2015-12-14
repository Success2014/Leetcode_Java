package first;

public class jumpGameII3 {
	public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int curt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > curt) {
                step++;
                curt = max;
            } 
            max = Math.max(max, i + nums[i]);
            if (curt >= n - 1) {
                return step;
            }
        }
        return step;
    }

}
