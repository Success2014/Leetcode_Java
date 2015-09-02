package first;

public class findPeakElement {
	public int findPeakElementM(int[] nums) {
		int start = 0, end = nums.length - 1;
        
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]){//ascending, judge < also works
                start = mid;
            }
            else if (nums[mid] > nums[mid + 1]){//descending, judge < also works
                end = mid;
            }
            else{
                start = mid;
            }
        }
        
        if (nums[start] > nums[end]){
            return start;
        }
        else{
            return end;
        }
    }
	
	public static void main(String[] args){
		findPeakElement fpe = new findPeakElement();
		int[] nums1 = {2,1,2};
		System.out.println(fpe.findPeakElementM(nums1));
		int[] nums2 = {100,102,104,7,9,11,4,3};
		System.out.println(fpe.findPeakElementM(nums2));
	}
	

}
