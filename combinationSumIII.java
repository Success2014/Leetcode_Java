package first;

import java.util.List;
import java.util.ArrayList;

public class combinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n > 9 * k || n <= 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(k, n, list, res, 1);
        return res;
    }
    public void dfs(int k, int n, ArrayList<Integer> list, ArrayList<List<Integer>> res, int pos){
        if (n == 0 && k == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (n < 0 || k < 1){
            return;
        }
        for (int i = pos; i <= 9; i++){
            list.add(i);
            dfs(k - 1, n - i, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args){
    	combinationSumIII cs = new combinationSumIII();
    	System.out.println(cs.combinationSum3(3, 15));
    }

}
