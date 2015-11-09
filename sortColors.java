package first;

public class sortColors {
	/**
	 * Two passes.
	 * @param nums
	 */
	public void sortColorsM1(int[] nums) {
        int n = nums.length;
        int prev = -1;
        for (int i = 0; i < 2; i++) {
            int start = prev + 1;
            int j = start;
            while (start < n) {
                if (nums[start] == i) {
                    int temp = nums[start];
                    nums[start] = nums[j];
                    nums[j] = temp;
                    j++;
                }
                start++;
            }
            prev = j - 1;
        }
    }
	
	/**
	 * One pass
	 * @param nums
	 */
	public void sortColorsM2(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            } else {
                i++;
            }
        }
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
