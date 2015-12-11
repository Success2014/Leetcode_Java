package first;

public class searchInsertPosition2 {
	public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        }
        return end + 1;
    }

}
