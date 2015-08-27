package first;

public class binaryTreeMaximumPathSum {

	private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    public int findMax(TreeNode root){
        if (root == null) return 0;
        int lval = findMax(root.left);
        int rval = findMax(root.right);
        maxSum = Math.max(maxSum, lval + rval + root.val);
        int maxVal = Math.max(0, Math.max(lval + root.val, rval + root.val));
        return maxVal;
    }
    
    public static void main (String[] args){
    	binaryTreeMaximumPathSum btmp = new binaryTreeMaximumPathSum();
    	TreeNode node1 = new TreeNode(-1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(-2);
    	node1.left = node2;
    	node1.right = node3;
    	
    	System.out.println(btmp.findMax(node1));
    }

}
