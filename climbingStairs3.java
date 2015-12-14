package first;

public class climbingStairs3 {
	public int climbStairs(int n) {
        int res1 = 1;
        int res2 = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                res2 += res1;
            } else {
                res1 += res2;
            }
        }
        if (n % 2 == 0) {
            return res2;
        } else {
            return res1;
        }
    }

}
