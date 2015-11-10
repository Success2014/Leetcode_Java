package first;

public class medianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            return 1.0 * findKth(nums1, 0, nums2, 0, n / 2  + 1);
        } else {
            return 0.5 * (findKth(nums1, 0, nums2, 0, n / 2) + findKth(nums1, 0, nums2, 0, n / 2 + 1));
        }
    }
    
    public int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int key1 = (start1 + k / 2 - 1 >= n1) ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
        int key2 = (start2 + k / 2 - 1 >= n2) ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];
        
        if (key1 < key2) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
