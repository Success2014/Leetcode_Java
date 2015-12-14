package first;

public class wildcardMatching2 {
	public boolean isMatch(String s, String p) {
        int scur = 0;
        int pcur = 0;
        int star = -1;
        int match = 0;
        int slen = s.length();
        int plen = p.length();
        
        while (scur < slen) {
            if (pcur < plen && (s.charAt(scur) == p.charAt(pcur) || p.charAt(pcur) == '?')) {
                scur++;
                pcur++;
            } else if (pcur < plen && p.charAt(pcur) == '*') {
                star = pcur;
                match = scur;
                pcur++;
            } else if (star != -1) {
                pcur = star + 1;
                match++;
                scur = match;
            } else {
                return false;
            }
        }
        while (pcur < plen && p.charAt(pcur) == '*') {
            pcur++;
        }
        return pcur == plen;
    }

}
