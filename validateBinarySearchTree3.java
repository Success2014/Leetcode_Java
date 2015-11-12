package first;
import java.util.*;
public class validateBinarySearchTree3 {
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    
    public boolean isValidBST2(TreeNode root) {
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
    public static void main(String[] args) {
    	validateBinarySearchTree3 vbs = new validateBinarySearchTree3();
    	TreeNode root = new TreeNode(0);
    	System.out.println(vbs.isValidBST(root));
    }

}
