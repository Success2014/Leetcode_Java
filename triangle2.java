package first;

import java.util.List;
import java.util.ArrayList;

public class triangle2 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; i++){// must follow this order 
            for (int j = i; j >= 0; j--){
                if (j == i){
                    dp[j] = dp[j-1] + triangle.get(i).get(j);
                }
                else if (j > 0){
                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
                }
                else{
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++){
            min = Math.min(min, dp[k]);
        }
        return min;
    }
	
	public static void main(String[] args){
		triangle2 tl = new triangle2();
		ArrayList<List<Integer>> tr = new ArrayList<List<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();l1.add(2);
		ArrayList<Integer> l2 = new ArrayList<Integer>();l2.add(3);l2.add(4);
		ArrayList<Integer> l3 = new ArrayList<Integer>();l3.add(6);l3.add(5);l3.add(7);
		ArrayList<Integer> l4 = new ArrayList<Integer>();l4.add(4);l4.add(1);l4.add(8);l4.add(3);
		tr.add(l1);tr.add(l2);tr.add(l3);tr.add(l4);
		System.out.println(tl.minimumTotal(tr));
	}

}
