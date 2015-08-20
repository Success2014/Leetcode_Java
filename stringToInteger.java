
public class stringToInteger {
	public int myAtoi(String str) {
        int maxDiv10 = Integer.MAX_VALUE / 10;
        int len = str.length();
        
        int i = 0, res = 0, sign = 1;
        while (i < len && str.charAt(i) == ' ') i++;
        if (i < len && str.charAt(i) == '+'){
            i++;
        }
        else if (i < len && str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        
        while (i < len && Character.isDigit(str.charAt(i))){
            int digit = Character.getNumericValue(str.charAt(i));
            if (res > maxDiv10 || (res == maxDiv10 && digit >= 8)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return sign * res;
    }
	
	public static void main (String[] args){
		String str = "2147483648";
		stringToInteger sti = new stringToInteger();
		System.out.println(sti.myAtoi(str));
	}

}
