package first;

public class binaryTreeMaximumPathSum3 {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findSum(root);
        return max;
    }
    public int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findSum(root.left);
        int right = findSum(root.right);
        max = Math.max(max, left + right + root.val);
        return Math.max(0, Math.max(root.val + left, root.val + right));
    }
    public static void main(String[] args) {
    	binaryTreeMaximumPathSum3 bt = new binaryTreeMaximumPathSum3();
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	node1.left = node2;
    	node1.right = node3;
    	System.out.println(bt.maxPathSum(node1));
    }

}
