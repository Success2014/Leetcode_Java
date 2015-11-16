package first;
import java.util.*;
public class combinationSum2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, res, list, 0, target);
        return res;
    }
    public void dfs(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> list, int pos, int t) {
        if (t < 0) {
            return;
        } else if (t == 0) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i, t - nums[i]);
            list.remove(list.size() - 1);
        }
    }

}
