package first;
import java.util.*;
public class permutations5 {
	public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(nums, res, list);
        return res;
    }
    public void dfs(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, res, list);
            list.remove(list.size() - 1);
        }
    }

}
