package first;
import java.util.*;
public class palindromePartition2 {
	public List<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        ArrayList<String> list = new ArrayList<String>();
        helper(s, res, list, 0);
        return res;
    }
    public void helper(String s, ArrayList<List<String>> res, ArrayList<String> list, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            if (!isPal(s, pos, i - 1)) {
                continue;
            } 
            list.add(s.substring(pos, i));
            helper(s, res, list, i);
            list.remove(list.size() - 1);
        }
        
    }
    public boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	palindromePartition2 pp = new palindromePartition2();
    	String s = "bb";
    	System.out.println(pp.partition(s));
    }

}
