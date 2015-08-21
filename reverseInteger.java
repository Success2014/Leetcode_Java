
public class reverseInteger {
	public class Solution {
	    public int reverse(int x) {
	        int res = 0;
	        int maxDiv10 = Integer.MAX_VALUE / 10;
	        while (x != 0){
	            if (Math.abs(res) > maxDiv10){
	                return 0;
	            }
	            res = res * 10 + x % 10;
	            x /= 10;
	        }
	        return res;
	    }
	}

}
