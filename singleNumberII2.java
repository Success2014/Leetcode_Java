package first;

public class singleNumberII2 {
	public int singleNumber(int[] nums) {
        int res = 0;
        int[] bits = new int[32];
        for (int j = 0; j < 32; j++) {
            for (int i = 0; i < nums.length; i++) {
                bits[j] += (nums[i] >> j) & 1;
                bits[j] %= 3;
            }
            res |= (bits[j] & 1) << j;
        }
        return res;
    }

}
