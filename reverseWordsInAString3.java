package first;

public class reverseWordsInAString3 {
	public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i] + " ");
            }
        }
        return (sb.length() == 0) ? "" : sb.substring(0, sb.length() -1);
    }

}
