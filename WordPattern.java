package first;

import java.util.HashMap;

public class WordPattern {
	/**
	 * Use two hashmaps.
	 * @param pattern
	 * @param str
	 * @return
	 */
	public boolean wordPattern(String pattern, String str) {
		String[] stra = str.split(" ");
        if (pattern.length() != stra.length){
            return false;
        }
        HashMap<Character, String> p2s = new HashMap<Character, String>();
        HashMap<String, Character> s2p = new HashMap<String, Character>();
        
        for (int i = 0; i < stra.length; i++){
            String temp = stra[i];
            Character c = pattern.charAt(i);
            
            if (s2p.containsKey(temp)){
                c = s2p.get(temp);
                if (c != pattern.charAt(i)){
                    return false;
                }
            }
            else{
                s2p.put(temp, c);
            }
            
            
            if (p2s.containsKey(c)){
                temp = p2s.get(c);
                if (!temp.equals(stra[i])){
                    return false;
                }
            }
            else{
                p2s.put(c, temp);
            }
            
        }
        return true;
    }
	
	/**
	 * Use only one hashmap;
	 * @param pattern
	 * @param str
	 * @return
	 */
	public boolean wordPattern2(String pattern, String str) {
		String[] stra = str.split(" ");
        if (pattern.length() != stra.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        
        for (int i = 0; i < stra.length; i++){
            Character c = pattern.charAt(i);
            String temp = stra[i];
            if (map.containsKey(c)){
                if (!temp.equals(map.get(c))){
                    return false;
                }
            }
            else{
                if (map.containsValue(temp)){
                    return false;
                }
                map.put(c, temp);
            }
        }
        return true;
		
	}
	
	public static void main(String[] args){
		WordPattern wp = new WordPattern();
		String pattern = "ab";
		String str = "dog cat";
		System.out.println(wp.wordPattern(pattern, str));
		
	}

}
