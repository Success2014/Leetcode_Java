package first;

public class reverseWordsInAString2 {
	public String reverseWords(String s) {
        int j = s.length();//keep track of the end
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--){
            if(s.charAt(i) == ' '){//trailing spaces
                j = i;
            }
            else if(i == 0 || s.charAt(i - 1) == ' '){
                if (res.length() != 0){
                    res.append(' ');
                }
                res.append(s.substring(i,j));
            }
        }
        return res.toString();
    }

}
