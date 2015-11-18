package first;

public class singNumberIII3 {
	public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }
        
        int one = 1;
        while ((diff & one) == 0) {
            one <<= 1;
        }
        
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & one) == one) {
                res1 ^= nums[i];
            } else {
                res2 ^= nums[i];
            }
        }
        int[] res = {res1, res2};
        return res;
    }

}
