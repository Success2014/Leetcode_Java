package first;

public class implementStrstr2 {
	public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == m) {
                    return i;
                } else if (i + j == n) {
                    return -1;
                } else if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

}
