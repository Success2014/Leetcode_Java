package first;
import java.util.HashMap;
public class validAnagram {
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            }
            else{
                map.put(temp, 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++){
            char temp = t.charAt(i);
            if (!map.containsKey(temp)){
                return false;
            }
            else{
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0){
                    map.remove(temp);
                }
            }
        }
        return map.isEmpty();
    }
	
	public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            char schar = s.charAt(i);
            char tchar = t. charAt(i);
            if (map.containsKey(schar)){
                map.put(schar, map.get(schar) + 1);
            }
            else{
                map.put(schar, 1);
            }
            if (map.containsKey(tchar)){
                map.put(tchar, map.get(tchar) - 1);
            }
            else{
                map.put(tchar, -1);
            }
        }
        for (char key: map.keySet()){
            if (map.get(key) != 0){
                return false;
            }
        }
        return true;
        
    }

}
