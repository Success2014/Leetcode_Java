package first;

public class findMinimumInRotatedSortedArray2 {
	public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
	
	public int findMin2(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

}
