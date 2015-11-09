package first;

public class powxn2 {
	public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        else if (n < 0) {
            double temp = 0;
            if (n == Integer.MIN_VALUE) {
                temp = myPow(x, Integer.MAX_VALUE) * x;
            } else {
                temp = myPow(x, -n);
            }
            return 1.0 / temp;
        }
        else {
            double temp = myPow(x, n / 2);
            if (n % 2 == 1) {
                return x * temp * temp;
            } else{
                return temp * temp;
            }
        }
    }

}
