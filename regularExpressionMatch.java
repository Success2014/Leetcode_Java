package first;

public class regularExpressionMatch {
	/**
	 * DFS. Handling * is the key point. If there is a *, two cases could happen:
	 * (1) aab, c*a*b, match after the *
	 * (2) aab, a*c*b, match before the * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) return s.length() == 1 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0));
        if (p.charAt(1) =='*'){
            if (isMatch(s, p.substring(2))) {//case 1
                return true;
            }
            else{//case 2
                return s.length() > 0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)) && isMatch(s.substring(1), p);
            }
        }
        else{//no *
            return s.length() > 0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)) && isMatch(s.substring(1),p.substring(1));
        }
    }
	
	public static void main (String[] args){
		regularExpressionMatch rem = new regularExpressionMatch();
		String s1 = "aab";
		String p1 = "c*a*b";
		String p2 = "a*c*b";
		System.out.println(rem.isMatch(s1, p1));
		System.out.println(rem.isMatch(s1, p2));
	}

}
