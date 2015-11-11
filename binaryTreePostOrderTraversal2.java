package first;
import java.util.*;
public class binaryTreePostOrderTraversal2 {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curt = stack.peek();
            if (prev == null || curt == prev.left || curt == prev.right) { // traverse down
                if (curt.left != null) {
                    stack.push(curt.left);
                } else if (curt.right != null) {
                    stack.push(curt.right);
                } else { // leaf
                    res.add(curt.val);
                    stack.pop();
                }
            } else if (curt.left == prev) { // from left child
                if (curt.right != null) {
                    stack.push(curt.right);
                } else { // leaf
                    res.add(curt.val);
                    stack.pop();
                }
            } else { // from right child
                res.add(curt.val);
                stack.pop();
            }
            prev = curt;
        }
        return res;
    }

}
