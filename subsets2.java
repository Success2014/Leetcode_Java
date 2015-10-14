package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class subsets2 {
	public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res, nums, 0, list);
        return res;
    }
    public void dfs(ArrayList<List<Integer>> res, int[] nums, int pos, ArrayList<Integer> list){
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            dfs(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
