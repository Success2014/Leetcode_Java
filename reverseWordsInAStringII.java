
public class reverseWordsInAStringII {
	public String reverseWords(String s){
		int len = s.length();
		char[] sa = s.toCharArray();
		reverse(sa, 0, len);
		for (int i = 0, j = 0; j <= len; j++){
			if (j == len || sa[j] == ' '){
				reverse(sa,i,j);
				i = j + 1;
			}
		}
		String sn = new String(sa);
		return sn;
		
	}
	
	public void reverse(char[] s, int start, int end){//start inclusive, end exclusive
		for (int i = 0; i < (end-start)/2; i++){
			char temp = s[start + i];
			s[start + i] = s[end - i -1];
			s[end - i - 1] = temp;
		}
	}
	
	public static void main(String[] args){
		String s = "the sky is blue";
		reverseWordsInAStringII rw = new reverseWordsInAStringII();
		System.out.println(rw.reverseWords(s));
	}

}
