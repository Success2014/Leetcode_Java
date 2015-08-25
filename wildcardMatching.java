package first;

public class wildcardMatching {
	public boolean isMatch(String s, String p) {
        int scur = 0;//current position in s
        int pcur = 0;//current position in p
        int star = -1;//most recent position of star
        int match = 0;//before this position, s,p are matched
        
        int slen = s.length();
        int plen = p.length();
        
        while (scur < slen){
            if (pcur < plen && (s.charAt(scur) == p.charAt(pcur) || p.charAt(pcur) == '?')){
                scur++;
                pcur++;
            }
            else if (pcur < plen && p.charAt(pcur) == '*'){
                star = pcur;
                match = scur;//not pcur, otherwise s1,p1 will fail
                pcur++;
            }
            else if (star != -1){
                pcur = star + 1;
                match++;
                scur = match;
            }
            else return false;
        }
        
        while (pcur < plen && p.charAt(pcur)== '*') pcur++;
        
        return pcur == plen;
        
    }
	
	public static void main (String[] args){
		String s1 = "abcde";
		String p1 = "*?*?*?*?";
		wildcardMatching wm = new wildcardMatching();
		System.out.println(wm.isMatch(s1, p1));
	}

}
