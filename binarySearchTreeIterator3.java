package first;
import java.util.*;
public class binarySearchTreeIterator3 {
	TreeNode root;
    Stack<TreeNode> stack;
    public binarySearchTreeIterator3(TreeNode root) {
        this.root = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (root != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        int res = 0;
        while(hasNext()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                res = node.val;
                root = node.right;
                break;
            }
        }
        return res;
    }

}
