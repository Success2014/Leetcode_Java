package first;

public class maximumGap {
	class Bucket {
        int low;
        int high;
        public Bucket() {
            low = -1;
            high = -1;
        }
    }
    public int maximumGapM(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        Bucket[] buckets = new Bucket[n + 1];
        for (int i = 0; i <= n; i++) {
            buckets[i] = new Bucket();
        }
        
        double interval = (double) n / (max - min);
        for (int i = 0; i < n; i++) {
            int index = (int) ((nums[i] - min) * interval);
            if (buckets[index].low == -1) {
                buckets[index].low = nums[i];
                buckets[index].high = nums[i];
            } else {
                buckets[index].low = Math.min(buckets[index].low, nums[i]);
                buckets[index].high = Math.max(buckets[index].high, nums[i]);
            }
        }
        
        int low = buckets[0].high;
        int high = buckets[0].low;
        int res = buckets[0].high - buckets[0].low;
        for (int i = 1; i <= n; i++) {
            if (buckets[i].low != -1) {
                high = buckets[i].low;
                res = Math.max(res, high - low);
                low = buckets[i].high;
            }
        }
        return res;
    }
    public static void main(String[] args) {
    	maximumGap mg = new maximumGap();
    	int[] nums1 = {100,3,2,1};
    	System.out.println(mg.maximumGapM(nums1));
    }

}
