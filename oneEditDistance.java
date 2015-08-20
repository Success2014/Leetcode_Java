/**
 * Check if one string can be transformed to another string using just one edit.
 * Idea: if the difference of length is greater than 1, then definitely no.
 * Otherwise, there could be 4 cases: same(abc,abc),append(abc,abcd),modify(abc,axc),insert(abc,axbc)
 * 原题应该是假设了两个string是不一样的。
 * @author Neo
 *
 */
public class oneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s.equals(t)) return true;
		int m = s.length();
		int n = t.length();
		if (m > n){
			return isOneEditDistance(t, s);
		}
		
		int i = 0;
		int shift = n - m;
		if (shift > 1) return false;
		
		while (i < m && s.charAt(i) == t.charAt(i)){			
			i++;						
		}		
		if (i == m) return shift > 0;
		
		if (shift == 0) i++; //if shift=0, skip this non-matching
		while (i < m && s.charAt(i) == t.charAt(i+shift)){
			i++;
		}
		return i == m;
		
	}
	public static void main(String[] args){
		oneEditDistance ied = new oneEditDistance();
		String s1 = "abcde";
		String t1 = "abcdex";
		String s2 = "abcde";
		String t2 = "abxde";
		String s3 = "abcde";
		String t3 = "abxcde";
		String s4 = "abc";
		String t4 = "abc";
		String s5 = "abcd";
		String t5 = "ab";
		System.out.println(ied.isOneEditDistance(s1, t1));
		System.out.println(ied.isOneEditDistance(s2, t2));
		System.out.println(ied.isOneEditDistance(s3, t3));
		System.out.println(ied.isOneEditDistance(s4, t4));
		System.out.println(ied.isOneEditDistance(s5, t5));
		System.out.println(ied.isOneEditDistance(t3, s5));
	}
}
