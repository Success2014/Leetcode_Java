package first;

public class validPalindrom2 {
	public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
	public static void main(String[] args){
		validPalindrom2 vp = new validPalindrom2();
		String s1 = "a.";
		System.out.println(vp.isPalindrome(s1));
	}
}
