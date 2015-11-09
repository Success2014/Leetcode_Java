package first;

public class sqrtx {
	public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long temp = mid * mid;
            if (temp == x) {
                return (int) mid;
            } else if (temp > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return (int) end;
        } else {
            return (int) start;
        }
    }
	public static void main(String[] args) {
		sqrtx sx = new sqrtx();
		System.out.println(sx.mySqrt(2147395599));
	}

}
