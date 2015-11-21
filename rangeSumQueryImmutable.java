package first;


public class rangeSumQueryImmutable {
    int[] preSum;

    public rangeSumQueryImmutable(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2, 0, 3, -5, 2, 1};
    	rangeSumQueryImmutable rsq = new rangeSumQueryImmutable(nums);
    	System.out.println(rsq.sumRange(0, 2));
    	
    }
}
