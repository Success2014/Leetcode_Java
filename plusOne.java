import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class plusOne {

	public void pOne (List<Integer> digits){
		for (int i = digits.size() - 1; i >= 0; i--){
			int digit = digits.get(i);
			if (digit == 9){
				digits.set(i, 0);
			}
			else{
				digits.set(i, digit + 1);
				return;
			}
		}
		digits.add(0);//add a zero at the end
		digits.set(0, 1);
	}
	
	public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            else{
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
	
	public static void main (String[] args){
		List<Integer> digits = new LinkedList<Integer>();
		digits.add(9);digits.add(9);
		plusOne po = new plusOne();
		po.pOne(digits);
		System.out.println(digits);
		
		int[] nums = {9};
		System.out.println(Arrays.toString(po.plusOne2(nums)));
		
	}
}
