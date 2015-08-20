
public class thirdLargest {
	public int thirdLarge (int[] nums){
		int l1 = Integer.MIN_VALUE;
		int l2 = Integer.MIN_VALUE;
		int l3 = Integer.MIN_VALUE;		
		
		for (int i = 0; i < nums.length; i++){
			if (nums[i] > l1){
				l3 = l2;
				l2 = l1;
				l1 = nums[i];				
			}
			else if (nums[i] > l2) {
				l3 = l2;
				l2 = nums[i];				
			}
			else if (nums[i] > l3) {
				l3 = nums[i];
			}
		}
		return l3;
		
	}

	public static void main(String[] args) {
		int[] nums1 = {1,3,0,2,4,6,6,9};
		thirdLargest tl = new thirdLargest();
		System.out.println(tl.thirdLarge(nums1));

	}

}
