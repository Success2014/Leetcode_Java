package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class subsets {
	public List<List<Integer>> subsetsM(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, nums, 0, list);
        return res;
    }
    
    public void helper(ArrayList<List<Integer>> res, int[] nums, int pos, List<Integer> list){
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, nums, i + 1, list);//i+1, not pos+1
            list.remove(list.size() - 1);
        }
    }
    
    
    public List<List<Integer>> subsetsIter(int[] nums) {
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
                res.add(list);
            }
        }
        
        return res;
    }  
    
    
    
    public static void main(String[] args){
    	subsets ss = new subsets();
    	int[] nums1 = {0};
    	int[] nums2 = {1,2,3};
    	int[] nums3 = {1,2,2};
    	System.out.println(ss.subsetsM(nums1));
    	System.out.println(ss.subsetsIter(nums2));
    	System.out.println(ss.subsetsM(nums3));
    	
    }

}
