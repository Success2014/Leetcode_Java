package first;
import java.util.TreeSet;
public class containsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0){
            return false;
        }
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            int c = nums[i];
            if ((ts.floor(c) != null && c <= ts.floor(c) + t) || (ts.ceiling(c) != null && c >= ts.ceiling(c) - t)){
                return true;
            }
            ts.add(c);
            
            if (i >= k){
                ts.remove(nums[i-k]);
            }
        }
        return false;
    }

}
