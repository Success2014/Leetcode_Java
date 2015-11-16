package first;
import java.util.*;
public class combinationSumIII2 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n > 9 * k) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(k, n, res, list, 1);
        return res;
    }
    public void dfs(int k, int n, ArrayList<List<Integer>> res, ArrayList<Integer> list, int pos) {
        if (list.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = pos; i <= 9; i++) {
            list.add(i);
            dfs(k, n - i, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
