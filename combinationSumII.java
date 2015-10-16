package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class combinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, list, res);
        return res;
    }
    
    public void dfs(int[] candidates, int target, int pos, ArrayList<Integer> list, ArrayList<List<Integer>> res){
        if (target == 0 && !res.contains(list)){
            res.add(new ArrayList<Integer>(list));
        }
        if (target < 0){
            return;
        }
        for (int i = pos; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

}
