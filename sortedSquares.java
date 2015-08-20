
public class sortedSquares {
	public int[] sortedSquare(int[] nums) {		
		// all positive
		if (nums[0] > 0) {
			for (int i = 0; i < nums.length; i++){
				nums[i] = nums[i] * nums[i];
			}
			return nums;
		}
		else if (nums[nums.length-1] <= 0){
			// all negative
			for (int i = nums.length - 1; i >= 0; i--){
				nums[i] = nums[i] * nums[i];
			}
			//reverse the array
			for (int j = 0; j < nums.length/2; j++){
				int tmp = nums[j];
				nums[j] = nums[nums.length-1-j];
				nums[nums.length-1-j] = tmp;
			}
			return nums;
		}
		else{
			int t = findPositive(nums);
			int[] newnums = new int[nums.length];
			
			//like merge sort, use two pointers
			int p1 = t - 1; // left pointer
			int p2 = t; // right pointer
			for (int i = 0; i < newnums.length; i ++){
				if (p1 >= 0 && p2 < nums.length){
					if (Math.abs(nums[p1]) < nums[p2]){
						newnums[i] = nums[p1] * nums[p1];
						p1 -= 1;
					}
					else{
						newnums[i] = nums[p2] * nums[p2];
						p2 += 1;
					}
				}
				else if (p1 < 0){
					newnums[i] = nums[p2] * nums[p2];
					p2 += 1;
				}
				else{
					newnums[i] = nums[p1] * nums[p1];
					p1 -= 1;
				}
			}
			return newnums;
		}
			
	}
	
	public int findPositive(int[] nums) {
		// duplicate 0 ²»ÓÃ¿¼ÂÇ
		int L = 0;
		int R = nums.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (nums[M] == 0){
				return M + 1;
			}
			else if (nums[M] > 0){
				R = M - 1;
			}
			else {
				L = M + 1;
			}
		}
		return L;
	}

	public static void main(String[] args) {
		//int[] nums1 = {1,2,3,4};
		//int[] nums2 = {-4,-3,-2,-1};
		int[] nums3 = {-5,-4,-3,-2,-1,0,0,0,0,1,2,6};
		sortedSquares st = new sortedSquares();
		int[] res = st.sortedSquare(nums3);
		for (int i = 0; i < res.length; i++){
			System.out.print(res[i]);
			System.out.print(' ');
		}

	}

}
