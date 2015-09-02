package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class binaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.empty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }

}
