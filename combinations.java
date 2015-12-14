package first;
import java.util.*;
public class combinations {
	public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(n, k, 1, res, list);
        return res;
    }
    public void dfs(int n, int k, int pos, ArrayList<List<Integer>> res, ArrayList<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

}
