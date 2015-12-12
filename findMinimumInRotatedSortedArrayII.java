package first;

public class findMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

}
