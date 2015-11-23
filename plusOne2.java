package first;

public class plusOne2 {
	public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

}
