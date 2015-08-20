import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class twoSum {
	public int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
        	if (map.containsKey(target - nums[i])){
        		return new int[] {map.get(target - nums[i]) + 1, i + 1}; 
        	}
        	map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution!");
    }
	
	public static void main (String[] args){
		int[] nums = {1,2,3,4};
		int target = 6; 
		twoSum ts = new twoSum();	
		int[] res = ts.twoSums(nums, target);
		System.out.println(Arrays.toString(res));		
	}

}
