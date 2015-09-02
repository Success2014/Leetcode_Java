package first;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class binaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur){//traverse down the tree
                if (cur.left != null){
                    stack.push(cur.left);
                }
                else if (cur.right != null){
                    stack.push(cur.right);
                }
                else{//leaf
                    res.add(cur.val);
                    stack.pop();
                }
            }
            else if (cur.left == prev){
                if (cur.right != null){
                    stack.push(cur.right);
                }
                else{
                    res.add(cur.val);
                    stack.pop();
                }
            }
            else if (cur.right == prev){
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
    return res;    
    }

}
