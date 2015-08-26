package first;

public class missingNumber {
	/**
	 * idea: from the beginning, it is always 0. Then it is always -1.
	 * @param nums
	 * @return
	 */
	public int missingNumber1(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i];
        }
        return result;
    }
	
	
	public static void main(String[] args){
		missingNumber mn = new missingNumber();
		int[] nums1 = {0,1,2,3};
		int[] nums2 = {0,1,3};
		int[] nums3 = {0};
		int[] nums4 = {1};
		int[] nums5 = {0,1,2,3,5,6};
		int[] nums6 = {0,1,2,4,5};
		System.out.println(mn.missingNumber1(nums1));
		System.out.println(mn.missingNumber1(nums2));
		System.out.println(mn.missingNumber1(nums3));
		System.out.println(mn.missingNumber1(nums4));
		System.out.println(mn.missingNumber1(nums5));
		System.out.println(mn.missingNumber1(nums6));
	}

}
