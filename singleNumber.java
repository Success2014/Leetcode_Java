package first;

public class singleNumber {

	public int singleNumberM(int[] nums) {
        int num = 0;
        for (int x: nums){
            num ^= x;
        }
        return num;
        
    }
	
	public static void main (String[] args){
		int[] nums1 = {1,2,3,4,1,2,3};
		int[] nums2 = {1,2,3,1,2,3,1,2,3,4,1,2,3,4,1,2,3,4};
		singleNumber sn = new singleNumber();
		System.out.println(sn.singleNumberM(nums1));
		System.out.println(sn.singleNumberM(nums2));
	}

}
