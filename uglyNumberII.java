package first;

import java.util.List;
import java.util.ArrayList;

public class uglyNumberII {
	/**
	 * http://bookshadow.com/weblog/2015/08/19/leetcode-ugly-number-ii/
	 * idea: Every ugly number is a multiple of previous ugly number.
	 * So there are 3 sublists:
	 * 1¡Á2, 2¡Á2, 3¡Á2, 4¡Á2, 5¡Á2, ¡­
	 * 1¡Á3, 2¡Á3, 3¡Á3, 4¡Á3, 5¡Á3, ¡­
	 * 1¡Á5, 2¡Á5, 3¡Á5, 4¡Á5, 5¡Á5, ¡­
	 * Get the minimum of the 3, and move the pointer 1 step.
	 * Note that, some numbers are in more than 1 list, e.g. 6, you need to move pointers in 
	 * all the lists. Otherwise, you will get duplicate numbers. 
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        List<Integer> q = new ArrayList<Integer>();
        q.add(1);
        
        int i2 = 0, i3 = 0, i5 = 0;
        
        while (q.size() < n){
            int m2 = q.get(i2) * 2;
            int m3 = q.get(i3) * 3;
            int m5 = q.get(i5) * 5;
            
            int m = Math.min(m2, Math.min(m3, m5));
            q.add(m);
            if (m == m2) i2++;//not if, else if, else!!!
            if (m == m3) i3++;
            if (m == m5) i5++;
        }
        return q.get(n-1);
        
    }
	public static void main(String[] args){
		uglyNumberII un = new uglyNumberII();
		int n = 7;
		System.out.println(un.nthUglyNumber(n));
	}

}
