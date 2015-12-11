package first;

public class findPeakElement4 {
	public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }

}
