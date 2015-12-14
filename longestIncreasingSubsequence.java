package first;

public class longestIncreasingSubsequence {
	/**
	 * O(nlogn)
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] tailTable = new int[n];
        tailTable[0] = nums[0];
        int len = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < tailTable[0]) {//case 1, less than minimum
                tailTable[0] = nums[i]; // new smallest value
            } else if (nums[i] > tailTable[len - 1]) {//case 2, greater than current maximum
                len++;
                tailTable[len - 1] = nums[i]; //nums[i] extends largest subsequence
            } else {
                // nums[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                int index = biSearch(tailTable, 0, len - 1, nums[i]);//tailTable is monotone increasing
                tailTable[index] = nums[i];
            }
        }
        return len;
    }
    public int biSearch(int[] nums, int start, int end, int key) { //find first index whose value greater than key
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= key) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= key) {
            return start;
        } else {
            return end;
        }
    }
    /**
     * DP. O(n^2)
     * @param nums
     * @return
     */
	public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
	public static void main(String[] args) {
		longestIncreasingSubsequence lis = new longestIncreasingSubsequence();
		int[] nums1 = {10,9,2,5,3,4};
		System.out.println(lis.lengthOfLIS(nums1));
	}

}
