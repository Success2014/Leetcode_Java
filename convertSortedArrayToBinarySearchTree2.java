package first;

public class convertSortedArrayToBinarySearchTree2 {
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0 , nums.length - 1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n <= 0) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, start, mid - 1);
        TreeNode right = helper(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

}
