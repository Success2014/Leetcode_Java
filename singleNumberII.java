package first;

public class singleNumberII {
	/**
	 * http://www.cnblogs.com/daijinqiao/p/3352893.html
	 * 扩展一：
	 * 给定一个包含n个整数的数组，除了一个数出现二次外所有的整数均出现三次，找出这个只出现二次的整数。ones记录1出现一次的数，twos记录1出现2次的数，
	 * 容易知道twos记录的即是最终结果。
	 * 扩展二：
	 * 给定一个包含n个整数的数组，有一个整数x出现b次，一个整数y出现c次，其他所有的数均出现a次，其中b和c均不是a的倍数，找出x和y。使用二进制模拟a进制，
	 * 累计二进制位1出现的次数，当次数达到a时，对其清零，这样可以得到b mod a次x，c mod a次y的累加。遍历剩余结果（用ones、twos、fours...变量表示）
	 * 中每一位二进制位1出现的次数，如果次数为b mod a 或者 c mod a，可以说明x和y的当前二进制位不同（一个为0，另一个为1），据此二进制位将原数组分成两组，
	 * 一组该二进制位为1，另一组该二进制位为0。这样问题变成“除了一个整数出现a1次（a1 = b 或 a1 = c）外所有的整数均出现a次”，使用和上面相同的方式计算就
	 * 可以得到最终结果，假设模拟a进制计算过程中使用的变量为ones、twos、fours...那么最终结果可以用ones | twos | fours ...表示。
	 * @param nums
	 * @return
	 */

	public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int count = 0;
            for (int num: nums){
                count += (num >> i) & 1;
            }
            res |= (count) % 3 << i;
        }
        return res;
    }
	public int singleNumber(int A[], int n) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < n; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
	
	public static void main (String[] args){
		int[] nums = {8,8,8,1};
		singleNumberII sn = new singleNumberII();
		System.out.println(sn.singleNumber(nums, 4));
	}
}
