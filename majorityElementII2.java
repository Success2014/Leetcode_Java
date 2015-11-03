package first;
import java.util.List;
import java.util.ArrayList;
public class majorityElementII2 {
	public List<Integer> majorityElement(int[] nums) {
        Integer cand1 = null;
        int c1 = 0;
        Integer cand2 = null;
        int c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cand1 != null && nums[i] == cand1.intValue()) {
                c1++;
            } else if (cand2 != null && nums[i] == cand2.intValue()) {
                c2++;
            } else if (c1 == 0) {
                cand1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                cand2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cand1 != null && nums[i] == cand1.intValue()) {
                c1++;
            }
            else if (cand2 != null && nums[i] == cand2.intValue()) {
                c2++;
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        if (c1 > nums.length /3 ) {
            res.add(cand1.intValue());
        }
        if (c2 > nums.length /3 ) {
            res.add(cand2.intValue());
        }
        return res;
    }
	
	public static void main(String[] args) {
		majorityElementII2 me = new majorityElementII2();
		int[] nums1 = {1, 2};
		int[] nums2 = {8, 8, 7, 7, 7};
		System.out.println(me.majorityElement(nums1));
		System.out.println(me.majorityElement(nums2));
	}

}
