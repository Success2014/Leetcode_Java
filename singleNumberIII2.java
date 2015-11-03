package first;

public class singleNumberIII2 {
	public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }
        
        int firstOne = 1;
        for (int i = 0; i < 32; i++) {
            firstOne <<= i;
            if ((diff & firstOne) != 0) {
                break;
            }
        }
        
        int[] res = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & firstOne) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

}
