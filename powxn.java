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
	
	public static void main(String[] args){
		powxn px = new powxn();
		double x = 1.0;
		int n = -2147483648;
		System.out.println(px.myPow(x, n));
	}

}
