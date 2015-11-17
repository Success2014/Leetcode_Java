package first;
import java.util.*;
public class longestConsecutiveSequence2 {
	public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], false);
        }
        
        int max = 0;
        for (int key: nums) {
            if (map.get(key)) {
                continue;
            }
            int left = key - 1;
            int right = key + 1;
            while (map.containsKey(left)) {
                map.put(left, true);
                left--;
            }
            while (map.containsKey(right)) {
                map.put(right, true);
                right++;
            }
            max = Math.max(max, right - left - 1);
        }
        return max;
    }
	public static void main(String[] args) {
		longestConsecutiveSequence2 lcs = new longestConsecutiveSequence2();
		int[] nums = {1,2,3,5,6,7,8,20,21};
		System.out.println(lcs.longestConsecutive(nums));
	}

}
