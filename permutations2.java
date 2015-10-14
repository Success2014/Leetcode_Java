package first;

import java.util.List;
import java.util.ArrayList;


public class permutations2 {
	public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(res, nums, list);
        return res;
    }
    
    public void dfs(ArrayList<List<Integer>> res, int[] nums, ArrayList<Integer> list){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(res, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
