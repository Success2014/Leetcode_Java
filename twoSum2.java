package first;
import java.util.HashMap;
public class twoSum2 {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]) + 1;
                res[1] = i + 1;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

}
