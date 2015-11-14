package first;

public class longestCommonPrefix {
	public String longestCommonPrefixM(String[] strs) {
        String res = "";
        int n = strs.length;
        if (n == 0) {
            return res;
        }
        
        int i = 0;
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (String str: strs) {
                if (i >= str.length() || str.charAt(i) != c) {
                    return res;
                }
            }
            res += c;
            i++;
        }
        return res;
    }

}
