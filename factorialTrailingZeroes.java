package first;

public class factorialTrailingZeroes {
	public int trailingZeroes(int n) {
        int count = 0;
        long div = 5;
        while (n / div >= 1) {
            count += n / div;
            div *= 5;
        }
        return count;
    }
	public static void main(String[] args) {
		factorialTrailingZeroes ftz = new factorialTrailingZeroes();
		System.out.println(ftz.trailingZeroes(1808548329));
	}

}
