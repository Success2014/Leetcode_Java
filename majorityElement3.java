package first;

public class majorityElement3 {
	public int majorityElement(int[] nums) {
        int n = nums.length;
        int cand = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == cand) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                cand = nums[i];
                count = 1;
            }
        }
        return cand;
    }

}
