
public class palindromNumber {
	
	    public boolean isPalindrome(int x) {
	        if (x < 0) return false;
	        int highest = 1;
	        while (x / highest >= 10){
	            highest *= 10; 
	        }
	        //if you write like below, it may overflow, e.g. x = 1000000001
	        /*while (x / highest > 0){
	            highest *= 10;
	        }
	        highest /= 10;*/
	        
	        
	       
	        while (x > 0){
	            int left = x / highest;
	            int right = x % 10;
	            if (left != right){
	                return false;
	            }
	            x %= highest;
	            x /= 10;
	            highest /= 100;
	        }
	        return true;
	    }
	
	public static void main(String[] args){
		palindromNumber pn = new palindromNumber();
		int x = 1000000001;
		System.out.println(pn.isPalindrome(x));
	}

}
