package first;

public class balancedBinaryTree {
	/**
	 * method 1, brute force, top-down, O(n^2).
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<=1 &&
        isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    /**
     * method 2, bottom-up, O(n)
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return maxDepth2(root) != -1;
    }
    
    public int maxDepth2(TreeNode root){
        if (root == null) return 0;
        int L = maxDepth2(root.left);
        if (L == -1) return -1;
        int R = maxDepth2(root.right);
        if (R == -1) return -1;
        return (Math.abs(L-R) <= 1) ? Math.max(L, R) + 1 : -1;
    }

}
