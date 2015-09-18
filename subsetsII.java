package first;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class subsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, list, 0, nums);
        return res;
    }
    
    public void helper(ArrayList<List<Integer>> res, ArrayList<Integer> list, int pos, int[] nums){
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++){
            if (i != pos && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            helper(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
    
    /**
     * Helper function below can also be accepted. But time complexity is higher.
     * @param res
     * @param list
     * @param pos
     * @param nums
     */
    public void helper2(ArrayList<List<Integer>> res, ArrayList<Integer> list, int pos, int[] nums){        
        if (!res.contains(list)){
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = pos; i < nums.length; i++){            
            list.add(nums[i]);
            helper(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
    
    /**
     * Iterative method
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDupIter(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (n == 0){
            return res;
        }
        Arrays.sort(nums);
        //add empty set, then res has size 1
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < n; i++){
            int size = res.size();//size of current result
            for (int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(res.get(j));
                list.add(nums[i]);
                if (res.contains(list)){
                    continue;
                }
                res.add(list);
            }
        }
        
        return res;
    }

}
