package first;

public class binaryTreeMaximumPathSum2 {
	int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        maxSum = Math.max(maxSum, left + root.val + right);
        return Math.max(0, Math.max(root.val + left, root.val + right));
    }

}
