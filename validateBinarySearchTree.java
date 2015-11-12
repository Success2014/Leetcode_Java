package first;
import java.util.*;
public class validateBinarySearchTree {
	/**
	 * Method 1, set a upper and lower bound for each node, check if each node is in the bounds.
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
	public boolean validBST(TreeNode node, long low, long high){
        if (node == null) return true;        
        return node.val > low && node.val < high && validBST(node.left, low, node.val) && validBST(node.right, node.val, high);
    }
	
	/**
	 * Method 2, in-order traversal. Check sequentially if the previous node is less than the current node.
	 */
	private TreeNode prev;
	public boolean isValidBST2(TreeNode root) {
		prev = null;
		return isMonoIncrease(root);
	}

	public boolean isMonoIncrease(TreeNode p){
	    if (p == null) return true;
	    if (isMonoIncrease(p.left)){
	        if (prev != null && prev.val >= p.val) return false;
	        prev = p;
	        return isMonoIncrease(p.right);
	    }
	    return false;
	}
	
	/**
	 * Method 3, in-order traversal. Iterative solution.
	 * @param root
	 * @return
	 */
	public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (prev!= null && node.val <= prev.val) {
                    return false;
                }
                prev = node;
                root = node.right;
            }
        }
        return true;
    }
	
	
    
    public static void main (String[] args){
    	validateBinarySearchTree vbst = new validateBinarySearchTree();
    	TreeNode node1 = new TreeNode(0);
    	System.out.println(vbst.isValidBST(node1));
    	TreeNode node2 = new TreeNode(2147483647);
    	System.out.println(vbst.isValidBST(node2));
    }

}
