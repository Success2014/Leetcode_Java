
public class validNumber {
	public boolean isNumber(String s) {
        int len = s.length();
        int i = 0;
        boolean isNum = false;
        //space
        while (i < len && s.charAt(i) == ' ') i++;
        
        //sign
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        
        //numbers
        while (i < len && Character.isDigit(s.charAt(i))){
        	i++;
        	isNum = true;
        }
        
        //dot and numbers
        if (i < len && s.charAt(i) == '.'){
        	i += 1;
        	while (i < len && Character.isDigit(s.charAt(i))){
        		i++;
        		isNum = true;
        	}
        }
        
        //e and numbers
        if (i < len && (s.charAt(i) == 'e' || s.charAt(i) == 'E' ) && isNum){
        	i += 1;
        	isNum = false;
        	
        	if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i += 1;
        	
        	while (i < len && Character.isDigit(s.charAt(i))){
        		i++;
        		isNum = true;
        	}
        }
        
        while (i < len && s.charAt(i) == ' ') i++;
        
        return isNum && (i == len);
    }
	
	
	public static void main(String[] args){
		validNumber vn = new validNumber();
		String s = "46.e3";
		System.out.println(vn.isNumber(s));
	}
}
