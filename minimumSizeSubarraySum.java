package first;

public class minimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (s > nums[0])  {
                return 0;
            } else {
                return 1;
            }
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                min = Math.min(min, j - i);
            }
            sum -= nums[i];
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }
	public static void main(String[] args) {
		minimumSizeSubarraySum mss = new minimumSizeSubarraySum();
		int[] nums1 = {2,3,1,2,4,3};
		System.out.println(mss.minSubArrayLen(7, nums1));
	}

}
