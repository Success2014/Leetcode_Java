package first;

public class majorityElement {
	public int majorityElementM(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == candidate){
                count++;
                if (count > nums.length / 2){
                    return candidate;
                }
            }
            else{
                count--;
            }
            if (count < 0){
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

}
