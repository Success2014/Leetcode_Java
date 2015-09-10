package first;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class validParentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')'); map.put('[',']');map.put('{','}');
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            else if(stack.empty() || s.charAt(i) != map.get(stack.peek())){
                return false;
            }
            else{
                stack.pop();
            }
        }
        return stack.empty();
    }

}
