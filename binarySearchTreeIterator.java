package first;
import java.util.Stack;

public class binarySearchTreeIterator {	
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur;
    public binarySearchTreeIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.empty() || cur != null);
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }
    /*below is also correct
    public int next() {
        int res = 0;
        while (!stack.empty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode node = stack.pop();
                res = node.val;
                cur = node.right;
                break;
            }
        }
        return res;
    }*/
    
    
}

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */


