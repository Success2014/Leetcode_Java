import java.util.Stack;
import java.util.HashMap;



public class basicCalculator {
	
	public int calculate(String s) {
	
		Stack<Character> operator = new Stack<Character>();
		Stack<Integer> result = new Stack<Integer>();
		
		s = s.replace(" ", "");//remove paces
		int len = s.length();
		
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		
		
		int i = 0;
		while (i < len){
			if (Character.isDigit(s.charAt(i))){//if digit, get the number and push
				int j = i + 1;
				while (j < len && Character.isDigit(s.charAt(j))){
					j++;
				}
				int number = Integer.parseInt(s.substring(i,j));
				result.push(number);
				i = j;
			}
			else if (s.charAt(i) == '('){//if '('
				operator.push('(');
				i++;
			}
			else if (s.charAt(i) == ')'){//if ')', pop till '('			
				while (operator.peek() != '('){
					calculateValue(operator.pop(), result);					
				}
				operator.pop();
				i++;
			}
			else{//other operators, push higher or equal level operators
				while (!operator.isEmpty() && priority.get(operator.peek()) >= priority.get(s.charAt(i))){
					calculateValue(operator.pop(), result);
				}
				operator.push(s.charAt(i));
				i++;
			}
		}
		while (!operator.isEmpty()){
			calculateValue(operator.pop(), result);
		}
		return result.pop();
			
	}
	
	public void calculateValue (char operator, Stack<Integer> s){
		int a = s.pop();
		int b = s.pop();		
		if (operator == '+'){
			s.push(a+b);
		}
		else if (operator == '-'){
			s.push(b-a);
		}
		else if (operator == '*'){
			s.push(a*b);
		}
		else if (operator == '/'){
			s.push(b/a);
		}
		else{
			throw new IllegalArgumentException("Wrong operator");
		}
	}
	
	
	/**
	 * Convert normal notation to reverse polish notation
	 * http://blog.csdn.net/mvpsendoh/article/details/6440559
	 * http://blog.csdn.net/sgbfblog/article/details/8001651
	 * @param s
	 * @return
	 */
	public Stack<String> toRPN(String s){
		Stack<Character> operator = new Stack<Character>();
		Stack<String> result = new Stack<String>();
		
		s = s.replace(" ", "");//remove paces
		int len = s.length();
		
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		
		
		int i = 0;
		while (i < len){
			if (Character.isDigit(s.charAt(i))){//if digit, get the number and push
				int j = i + 1;
				while (j < len && Character.isDigit(s.charAt(j))){
					j++;
				}
				String number = s.substring(i,j);
				result.push(number);
				i = j;
			}
			else if (s.charAt(i) == '('){//if '('
				operator.push('(');
				i++;
			}
			else if (s.charAt(i) == ')'){//if ')', pop till '('			
				while (operator.peek() != '('){
					result.push(Character.toString(operator.pop()));
				}
				operator.pop();
				i++;
			}
			else{//other operators, push higher or equal level operators
				while (!operator.isEmpty() && priority.get(operator.peek()) >= priority.get(s.charAt(i))){
					result.push(Character.toString(operator.pop()));
				}
				operator.push(s.charAt(i));
				i++;
			}
		}
		while (!operator.isEmpty()){
			result.push(Character.toString(operator.pop()));
		}
		return result;
	}	
	
	
	
	public static void main(String[] args){
		basicCalculator bc = new basicCalculator();
		String s1 = "1+2*3+(4*5+6)*7";
		Stack<String> ss = bc.toRPN(s1);		
		System.out.println(ss);
		
		int res = bc.calculate(s1);
		System.out.println(res);
	}

}
