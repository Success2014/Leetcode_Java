package first;

public class majorityElementII3 {
	public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            return res;
        }
        Integer cand1 = null;
        int count1 = 0;
        Integer cand2 = null;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cand1 != null && nums[i] == cand1.intValue()) {
                count1++;
            } else if (cand2 != null && nums[i] == cand2.intValue()) {
                count2++;
            } else if (count1 == 0) {
                cand1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                cand2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cand1 != null && nums[i] == cand1.intValue()) {
                count1++;
            } else if (cand2 != null && nums[i] == cand2.intValue()) {
                count2++;
            }
        }
        
        
        if (count1 > n / 3) {
            res.add(cand1.intValue());
        }
        if (count2 > n / 3) {
            res.add(cand2.intValue());
        }
        return res;
    }

}
