package first;

public class jumpGame {
	/**
	 * DP. O(n^2). Will time out on leetcode.
	 * For each element, check how far it can go from it.
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return true;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;//1 means yes.
        for (int i = 0; i < n - 1; i++){//no need to calculate the last one
            if (dp[i] == 1){
                int j = 1;
                while (j <= nums[i] && i+j < n){
                    dp[i+j] = 1;
                    j++;
                }
            }
            else{
                break;
            }
        }
        return dp[n-1] == 1;
    }
	/**
	 * DP. For each element, check if any of the past elements can reach it.
	 * @param nums
	 * @return
	 */
	public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0){
            return true;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] == 1 && j + nums[j] >= i){//element j must be valid.
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n-1] == 1;
    }
	
	
	/**
	 * Greedy. O(n).
	 * @param nums
	 * @return
	 */
	public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0){
            return true;
        }
        int n = nums.length;
        int step = nums[0];
        for (int i = 1; i < n; i++){
            if (step > 0){
                step--;
                step = Math.max(step, nums[i]);
            }
            else{
                return false;
            }
        }
        return true;
        
    }

}
