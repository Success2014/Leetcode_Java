package first;

public class removeDuplicatedFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length <= 2){
            return nums.length;
        }
        int j = 1;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] == nums[j] && nums[i] == nums[j-1]){
                continue;
            }
            else{
            	j++;
                nums[j] = nums[i];                
            }
        }
        return j + 1;
        
    }

}
