package first;
import java.util.*;
public class minimumWindowSubstring {
	public String minWindow(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!tmap.containsKey(c)) {
                tmap.put(c, 0);
            }
            tmap.put(c, tmap.get(c) + 1);
        }
        
        int minLen = Integer.MAX_VALUE;
        String res = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !isValid(smap, tmap)) {
                if (!smap.containsKey(s.charAt(j))) {
                    smap.put(s.charAt(j), 0);
                }
                smap.put(s.charAt(j), smap.get(s.charAt(j)) + 1);
                j++;
            }
            if (isValid(smap, tmap)) {
            	if (j - i < minLen) {
            		minLen = j - i;
            		res = s.substring(i, j);
            	}
            }
            char toRemove = s.charAt(i);
            if (smap.get(toRemove) > 1) {
                smap.put(toRemove, smap.get(toRemove) - 1);
            } else {
                smap.remove(toRemove);
            }
        }
        return res;
    }
    public boolean isValid(HashMap<Character, Integer> smap, HashMap<Character, Integer> tmap) {
        for (Character c: tmap.keySet()) {
            if (!smap.containsKey(c)) {
                return false;
            }
            if (smap.get(c) < tmap.get(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	minimumWindowSubstring mws = new minimumWindowSubstring();
    	String s1 = "a";
    	String t1 = "aa";
    	String s2 = "cabwefgewcwaefgcf";
    	String t2 = "cae";
    	System.out.println(mws.minWindow(s2, t2));
    }

}
