package first;
import java.util.HashMap;
public class bullsAndCows {
	public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> gMap = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g){
                a++;
            }
            else{
                if (sMap.containsKey(g) && sMap.get(g) > 0){
                    b++;
                    sMap.put(g, sMap.get(g) - 1);
                }
                else{
                    int tmp = gMap.containsKey(g) ? gMap.get(g) + 1 : 1; 
                    gMap.put(g, tmp);
                }
                if (gMap.containsKey(s) && gMap.get(s) > 0){
                    b++;
                    gMap.put(s, gMap.get(s) - 1);
                }
                else{
                    int tmp = sMap.containsKey(s) ? sMap.get(s) + 1 : 1;
                    sMap.put(s, tmp);
                }
            }
        }
        String res = "";
        res += a + "A" + b + "B";
        return res;
    }
	public static void main(String[] args) {
		bullsAndCows bac = new bullsAndCows();
		String s1 = "1122";
		String g1 = "2211";
		String s2 = "1";
		String g2 = "0";
		System.out.println(bac.getHint(s1, g1));
		System.out.println(bac.getHint(s2, g2));
	}

}
