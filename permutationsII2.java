package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class permutationsII2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(res, nums, list, visited);
        return res;
    }
    
    public void dfs(ArrayList<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if ((visited[i]) || (i != 0 && (nums[i] == nums[i-1]) && !visited[i-1])){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(res, nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
