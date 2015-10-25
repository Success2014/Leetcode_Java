package first;

import java.util.List;

public class triangle3 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; i++){
            for (int j = i; j >= 0; j--){
                if (j == i){
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }
                else if (j == 0){
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
                else{
                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++){
            min = Math.min(min, dp[k]);
        }
        
        return min;
    }

}
