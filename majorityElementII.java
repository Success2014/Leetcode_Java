package first;

import java.util.List;
import java.util.ArrayList;

public class majorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        Integer n1 = null;
        int c1 = 0;
        Integer n2 = null;
        int c2 = 0;
        
        for (int i = 0; i < nums.length; i++){
            if ((n1 != null) && (nums[i] == n1.intValue())){
                c1++;
            }
            else if ((n2 != null) && (nums[i] == n2.intValue())){
                c2++;
            }
            else if (c1 == 0){
                n1 = nums[i];
                c1 = 1;
            }
            else if (c2 == 0){
                n2 = nums[i];
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        
        c1 = 0; 
        c2 = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == n1.intValue()){
                c1++;
            }
            else if (nums[i] == n2.intValue()){
                c2++;
            }
        }
        if (c1 > nums.length / 3){
            res.add(n1);
        }
        if (c2 > nums.length / 3){
            res.add(n2);
        }
        return res;
    }
	
	public static void main (String[] args){
		majorityElementII me = new majorityElementII();
		int[] nums = {1,1,1,3,3,2,2,2};
		System.out.println(me.majorityElement(nums));
	}

}
