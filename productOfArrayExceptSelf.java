package first;

import java.util.Arrays;

public class productOfArrayExceptSelf {
	/**
	 *  1      2      3     4      5
	 *         1     1*2   1*2*3  1*2*3*4
	 * 5*4*3*2 5*4*3 5*4    5 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = 1;
        int[] res = new int[n];
        Arrays.fill(res,1);
        
        for (int i = 0; i < n; i++){
            res[i] *= low;
            low *= nums[i];
            res[n-1-i] *= high;
            high *= nums[n-1-i];
        }
        return res;
    }
	
	public static void main(String[] args){
		productOfArrayExceptSelf poaes = new productOfArrayExceptSelf();
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(poaes.productExceptSelf(nums)));
	}

}
