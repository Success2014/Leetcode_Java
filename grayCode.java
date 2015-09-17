package first;

import java.util.List;
import java.util.ArrayList;

public class grayCode {
	public List<Integer> grayCodeM(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0){
            return res;
        }
        for (int i = 0; i < n; i++){
            int size = res.size();
            int temp = 1 << i;
            for (int j = size - 1; j >= 0; j--){
                res.add(temp | res.get(j));
            }
        }
        return res;
    }
	public static void main(String[] args){
		grayCode gc = new grayCode();
		System.out.println(gc.grayCodeM(2));
	}
}
