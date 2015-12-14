package first;
import java.util.*;
public class combinationSumIII3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(k, n, 1, res, list);
        return res;
    }
    public void dfs(int k, int n, int pos, ArrayList<List<Integer>> res, ArrayList<Integer> list) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(list));
        } else if (k < 0 || n < 0) {
            return;
        } else {
            for (int i = pos; i <= 9; i++) {
                list.add(i);
                dfs(k - 1, n - i, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

}
