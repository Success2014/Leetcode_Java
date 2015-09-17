package first;

import java.util.List;
import java.util.ArrayList;

public class permutations {
	public List<List<Integer>> permute(int[] nums) {
        List res = new ArrayList();
        if (nums == null || nums.length == 0){
            return res;
        }
        ArrayList<Integer> level = new ArrayList<Integer>();
        helper(nums, res, level);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> level){
        if (level.size() == nums.length){
        	res.add(new ArrayList<Integer>(level));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (level.contains(nums[i])){
                continue;
            }
            level.add(nums[i]);
            helper(nums, res, level);
            level.remove(level.size() - 1);
        }
        
    }
    
    public static void main(String[] args){
    	
    }

}
