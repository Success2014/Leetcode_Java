public class addDigits {
    public static int addDigit(int num) {
    	
    	while (num >= 10){
    		int sum = 0;
    		String s = Integer.toString(num);
    		for (int i = 0 ; i < s.length(); i++){
    			sum += Character.getNumericValue(s.charAt(i));
    		}
    		num = sum;
    	}
    	return num;   			
        
    }
    
    public static int addDigit2(int num){
    	//digital root
    	return (num - 1) % 9 + 1;
    	
    }
    
    public static void main(String[] args){
    	int num = 38;
    	System.out.println(addDigits.addDigit(num));
    }
}