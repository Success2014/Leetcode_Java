
public class reverseWordsInAString {
	 public String reverseWords(String s) {
		 
		 StringBuilder res = new StringBuilder();
		 int j = s.length();
		 for (int i = s.length() - 1; i >=0; i--){
			 if (s.charAt(i) == ' '){
				 j =i;
			 }
			 else if(i == 0 || s.charAt(i-1) == ' '){
				 if (res.length() != 0){
					 res.append(' ');
				 }
				 
				 res.append(s.substring(i, j));
				 
			 }
		 }
		 return res.toString();
	        
	    }
	 public static void main(String[] args){
		 String s ="a";
		 reverseWordsInAString rw = new reverseWordsInAString();
		 System.out.println(rw.reverseWords(s));
	 }
}
