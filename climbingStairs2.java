package first;

public class climbingStairs2 {
	public int climbStairs(int n) {
        int step1 = 1;
        int step2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = step2;
            step2 += step1;
            step1 = temp;
        }
        return step2;
    }

}
