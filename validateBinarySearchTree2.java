package first;

import java.util.Stack;

public class validateBinarySearchTree2 {
	public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean firstNode = true;
        int prev = Integer.MIN_VALUE;
        while(!stack.empty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode node = stack.pop();
                if (node.val <= prev && !firstNode){
                    return false;
                }
                firstNode = false;
                root = node.right;
                prev = node.val;
            }
        }
        return true;
    }

}
