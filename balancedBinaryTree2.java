package first;

public class balancedBinaryTree2 {
	public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1 || leftDepth == -1 || rightDepth == -1) {
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
