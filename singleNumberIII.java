package first;

public class singleNumberIII {
	/**
	 * idea:
	 * We want to find res1 and res2.
	 * (1) we can use xor to get the sum of these two.
	 * Since they are different, the sum must not be 0.
	 * (2) we find the rightmost position where the bit is 1, which means res1 and res2 are different 
	 * at the position, denoted as p. We make a number which at position p is 1, all other positions 
	 * are 0. In this way, we could separate these two numbers into two groups. One group is 0 at p, the 
	 * other is 1 at p.
	 * (3) update res1 and res2, useless numbers will cancel out, useful number will come out.
	 *  
	 * @param nums
	 * @return
	 */
	public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int num: nums){
            xor ^= num;
        }
        int dif = xor & (~(xor - 1));//find the rightmost position where two numbers differ
        
        /*could also use the following code
        int dif = 1;
        while ((xor & dif) == 0){
            dif <<= 1;
        }
         */
        
        int res1 = 0, res2 = 0;
        for (int num: nums){
            if ((num & dif) == 0){
                res1 ^= num;
            }
            else{
                res2 ^= num;
            }
        }
        res[0] = res1;
        res[1] = res2;
        return res;
    }

}
