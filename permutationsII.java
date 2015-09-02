package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class permutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List res = new ArrayList();
        if (nums == null || nums.length == 0){
            return res;
        }
        ArrayList<Integer> level = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        helper(nums, res, level, visited);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> level, int[] visited){
        if (level.size() == nums.length){
            res.add(new ArrayList<Integer>(level));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 1 ||(i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1;
            level.add(nums[i]);
            helper(nums, res, level, visited);
            level.remove(level.size() - 1);
            visited[i] = 0;
        }
        
    }

}
