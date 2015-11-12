package first;
import java.util.*;
public class permutationsII3 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, list, visited);
        return res;
    }
    public void dfs(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
