package first;
import java.util.*;
public class combinationSumII3 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, res, list, 0, target);
        return res;
    }
    public void dfs(int[] candidates, ArrayList<List<Integer>> res, ArrayList<Integer> list, int pos, int target) {
        if (target == 0 && !res.contains(list)) {
            res.add(new ArrayList<Integer>(list));
        } else if (target < 0) {
            return;
        } else {
            for (int i = pos; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    list.add(candidates[i]);
                    dfs(candidates, res, list, i + 1, target - candidates[i]);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}
