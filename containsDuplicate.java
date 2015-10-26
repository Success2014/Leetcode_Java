package first;
import java.util.HashSet;

public class containsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1){
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

}
