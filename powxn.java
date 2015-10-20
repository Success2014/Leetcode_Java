package first;

public class powxn {
	public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        else if (n < 0){
            double temp = 0;
            if (n == Integer.MIN_VALUE){
                temp = myPow(x, -(n + 1)) * x;
            }
            else{
                temp = myPow(x, -n);
            }
            if (temp == 0){
                return Double.MAX_VALUE;
            }
            else{
                return 1.0 / temp;
            }
        }
        else{
            double temp = myPow(x, n / 2);
            if (n % 2 == 1){
                return temp * temp * x;
            }
            else{
                return temp * temp;
            }
        }
    }
	
	/**
	 * Iterative solution
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
        double res = 1.0;
        boolean neg = (n < 0);
        n = Math.abs(n);
        while (n > 0){
            if (n % 2 == 0){
                x *= x;
                n /= 2;
            }
            else{
                n -= 1;
                res *= x;
            }
        }
        return neg ? 1/res : res;
    }
	
	public static void main(String[] args){
		powxn px = new powxn();
		double x = 2.0;
		int n = -2147483648;
		System.out.println(px.myPow2(x, n));
	}

}
