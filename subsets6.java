package first;
import java.util.*;
public class subsets6 {
	public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, res, list, 0);
        return res;
    }
    public void dfs(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> list, int pos) {
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
