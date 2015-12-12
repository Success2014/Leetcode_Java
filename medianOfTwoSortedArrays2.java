package first;

public class medianOfTwoSortedArrays2 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1) {
            return 1.0 * getKth(nums1, nums2, 0, m, 0, n, (m + n) / 2 + 1);
        } else {
            return 0.5 * (getKth(nums1, nums2, 0, m, 0, n, (m + n) / 2) + getKth(nums1, nums2, 0, m, 0, n, (m + n) / 2 + 1));
        }
    }
    public int getKth(int[] nums1, int[] nums2, int s1, int len1, int s2, int len2, int k) {//k starts from 1
        if (s1 == len1) {
            return nums2[s2 + k - 1];
        }
        if (s2 == len2) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        if (len1 > len2) {
            return getKth(nums2, nums1, s2, len2, s1, len1, k);
        }
        
        int mid = k / 2;
        
        int temp1 = (s1 + mid - 1 >= len1) ? Integer.MAX_VALUE : nums1[s1 + mid - 1];
        int temp2 = (s2 + mid - 1 >= len2) ? Integer.MAX_VALUE : nums2[s2 + mid - 1];
        
        if (temp1 > temp2) {
            return getKth(nums1, nums2, s1, len1, s2 + mid, len2, k - mid);
        } else {
            return getKth(nums1, nums2, s1 + mid, len1, s2, len2, k - mid);
        }
    }
    public static void main(String[] args) {
    	medianOfTwoSortedArrays2 mt = new medianOfTwoSortedArrays2();
    	int[] A1 = {1,2,2};
    	int[] A2 = {1,2,3};
    	System.out.println(mt.findMedianSortedArrays(A1, A2));
    }

}
