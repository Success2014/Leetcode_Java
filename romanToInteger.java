package first;

import java.util.HashMap;

public class romanToInteger {
	public int romanToInt(String s) {
        int res = 0;
        if (s == ""){
            return res;
        }
        
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5); 
        table.put('X', 10);
        table.put('L', 50); 
        table.put('C', 100); 
        table.put('D', 500);
        table.put('M', 1000);
        
        char prev = s.charAt(0);
        res = table.get(prev);
        int i = 1;
        while(i < s.length()){
            char cur = s.charAt(i);
            res += table.get(cur);
            if (table.get(cur) > table.get(prev)){
                res -= 2 * table.get(prev);
            }
            i++;
            prev = cur;
        }
        return res;
    }

}
