package first;

import java.util.Arrays;

public class rotateArray {
	public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
    	rotateArray ra = new rotateArray();
    	int[] nums = {1};
    	ra.rotate(nums, 3);
    	System.out.println(Arrays.toString(nums));
    }

}
