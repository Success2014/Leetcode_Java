
public class validPalindrom {
	public boolean isPalindrom(String s){
		int i = 0;
		int j = s.length() - 1;
		while (i < j){
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "A man, a plan, a canal: Panama";
		validPalindrom vp = new validPalindrom();
		System.out.println(vp.isPalindrom(s));
	}

}
