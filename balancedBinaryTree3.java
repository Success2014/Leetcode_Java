package first;

public class balancedBinaryTree3 {
	public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return findHeight(root) > 0;
    }
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
