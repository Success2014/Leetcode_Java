package first;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k < 1){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return helper(nums, 0, nums.length - 1, k);
    }
    
    public int helper(int[] nums, int start, int end, int k){
        if (start == end){ // only have 1 number
            return nums[start];
        }
        int pivot = nums[start];
        int j = start;
        for (int i = start + 1; i <= end; i++){
            if (nums[i] > pivot){
                swap(nums, i, j + 1);
                j++;
            }
        }
        swap(nums, start, j);
        if (k == j + 1){
            return nums[j];
        }
        else if (k > j + 1){
            return helper(nums, j + 1, end, k);
        }
        else{
            return helper(nums, start, j, k);
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	KthLargestElementInAnArray kle = new KthLargestElementInAnArray();
    	int[] nums1 = {3,2,1};
    	int[] nums2 = {4,2,8,1,3,5,6};
    	System.out.println(kle.findKthLargest(nums1, 2));
    	System.out.println(kle.findKthLargest(nums2, 5));
    }

}
