package first;

public class singleNumberII {
	/**
	 * http://www.cnblogs.com/daijinqiao/p/3352893.html
	 * ��չһ��
	 * ����һ������n�����������飬����һ�������ֶ��������е��������������Σ��ҳ����ֻ���ֶ��ε�������ones��¼1����һ�ε�����twos��¼1����2�ε�����
	 * ����֪��twos��¼�ļ������ս����
	 * ��չ����
	 * ����һ������n�����������飬��һ������x����b�Σ�һ������y����c�Σ��������е���������a�Σ�����b��c������a�ı������ҳ�x��y��ʹ�ö�����ģ��a���ƣ�
	 * �ۼƶ�����λ1���ֵĴ������������ﵽaʱ���������㣬�������Եõ�b mod a��x��c mod a��y���ۼӡ�����ʣ��������ones��twos��fours...������ʾ��
	 * ��ÿһλ������λ1���ֵĴ������������Ϊb mod a ���� c mod a������˵��x��y�ĵ�ǰ������λ��ͬ��һ��Ϊ0����һ��Ϊ1�����ݴ˶�����λ��ԭ����ֳ����飬
	 * һ��ö�����λΪ1����һ��ö�����λΪ0�����������ɡ�����һ����������a1�Σ�a1 = b �� a1 = c�������е�����������a�Ρ���ʹ�ú�������ͬ�ķ�ʽ�����
	 * ���Եõ����ս��������ģ��a���Ƽ��������ʹ�õı���Ϊones��twos��fours...��ô���ս��������ones | twos | fours ...��ʾ��
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
