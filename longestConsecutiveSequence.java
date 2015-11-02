package first;
import java.util.HashMap;
public class longestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int num: nums) {
            map.put(num, false);
        }
        int maxLen = 0;
        for (int num: nums) {
            if (map.get(num)) {
                continue;
            }
            
            int temp = num;
            int curtMax = 1;
            while (map.containsKey(temp + 1)) {
                curtMax++;
                map.put(temp + 1, true);
                temp++;
            }
            
            temp = num;
            while (map.containsKey(temp - 1)) {
                curtMax++;
                map.put(temp - 1, true);
                temp--;
            }
            maxLen = Math.max(maxLen, curtMax);
        }
        return maxLen;
    }

}
