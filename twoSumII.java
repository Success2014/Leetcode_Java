import java.util.Arrays;

/** 
 * @author Neo
 * Assume input is already sorted.
 */
public class twoSumII {
	public int[] twoSum(int[] nums, int target){
		int L = 0;
		int R = nums.length - 1;
		
		while (L < R){
			if (nums[L] + nums[R] == target){
				return new int[] {L+1, R+1};
			}
			else if (nums[L] + nums[R] > target){
				R -= 1;
			}
			else{
				L += 1;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,5,8,10};
		int target = 13;
		twoSumII ts = new twoSumII();		
		int[] res = ts.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}

}
