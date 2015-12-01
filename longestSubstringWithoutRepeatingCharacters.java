package first;
import java.util.*;


public class longestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        int res = 0, cur = 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        
        for (int i = 0; i < len; i++){
        	if (map.containsKey(s.charAt(i))){
        		cur = Math.min(cur+1, i - map.get(s.charAt(i)));
        	}
        	else{        		
        		cur += 1;
        	}
        	map.put(s.charAt(i), i);
        	res = Math.max(res, cur);
        }
        return res;
        
    }
	public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int j = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            while (j < n && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            }
            set.remove(s.charAt(i));
        }
        return max;
    }

	public static void main (String[] args){
		longestSubstringWithoutRepeatingCharacters lw = new longestSubstringWithoutRepeatingCharacters();
		String s = "tmmzuxt";
		System.out.println(lw.lengthOfLongestSubstring(s));
	}
}
