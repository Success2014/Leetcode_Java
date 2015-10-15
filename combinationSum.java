package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class combinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, list, 0, res);
        return res;
    }
    public void dfs(int[] candidates, int target, ArrayList<Integer> list, int pos, ArrayList<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<Integer>(list));
        }
        if (target < 0){
            return;
        }
        for (int i = pos; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], list, i, res);
            list.remove(list.size() - 1);
        }
    }

}
