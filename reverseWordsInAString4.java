package first;

public class reverseWordsInAString4 {
	public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (n == 0) {
            return "";
        }
        int j = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(i, j));
            }
        }
        return sb.toString();
    }

}
