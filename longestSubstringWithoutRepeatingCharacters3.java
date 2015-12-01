package first;
import java.util.*;
public class longestSubstringWithoutRepeatingCharacters3 {
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int curt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                curt++;
            } else {
                curt = Math.min(curt + 1, i - map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, curt);
        }
        return max;
    }

}
